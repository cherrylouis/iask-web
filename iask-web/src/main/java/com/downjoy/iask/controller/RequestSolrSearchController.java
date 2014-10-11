package com.downjoy.iask.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.BindException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;

import org.apache.http.HttpRequest;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.druid.util.StringUtils;
import com.downjoy.iask.domain.GameDetailInfo;
import com.downjoy.iask.domain.KeyWordRelation;
import com.downjoy.iask.domain.RequestAdopt;
import com.downjoy.iask.domain.RequestRecommendation;
import com.downjoy.iask.domain.ResponseAnswer;
import com.downjoy.iask.domain.ResponseAnswerResult;
import com.downjoy.iask.domain.ResponseData;
import com.downjoy.iask.domain.ResponseGameDetail;
import com.downjoy.iask.domain.ResponseGameQuestion;
import com.downjoy.iask.domain.ResponseKeyWord;
import com.downjoy.iask.domain.ResponseQuestion;
import com.downjoy.iask.domain.ResponseSimiResult;
import com.downjoy.iask.domain.ResponseSimiTitleAnswerData;
import com.downjoy.iask.domain.ResponseTitleAnswer;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.model.Answer;
import com.downjoy.iask.model.Page;
import com.downjoy.iask.model.Question;
import com.downjoy.iask.model.RestResult;
import com.downjoy.iask.service.DownjoySolrService;
import com.downjoy.iask.service.GameDetailInfoService;
import com.downjoy.iask.service.GameQuestionService;
import com.downjoy.iask.service.KeyWordRelationService;
import com.downjoy.iask.service.QuestionService;
import com.downjoy.iask.service.RequestSolrSearchService;
import com.downjoy.iask.service.SolrService;
import com.downjoy.iask.util.SolrContents;

/**
 * @Description: 请求服务器端查询数据
 * @author jian.yang@downjoy.com
 * @date 2014年9月1日 下午4:13:21
 * @version 1.0
 */
@Controller
public class RequestSolrSearchController {

	Logger logger = Logger.getLogger(RequestSolrSearchController.class);

	@Autowired
	@Qualifier("requestSolrSearchService")
	private RequestSolrSearchService requestSolrSearchService;

	@Autowired
	@Qualifier("downjoySolrService")
	private DownjoySolrService downjoySolrService;

	@Autowired
	@Qualifier("keyWordRelationService")
	private KeyWordRelationService keyWordRelationService;

	@Autowired
	@Qualifier("solrService")
	private SolrService solrService;

	@Autowired
	@Qualifier("gameDetailInfoService")
	private GameDetailInfoService gameDetailInfoService;

	@Autowired
	@Qualifier("gameQuestionService")
	private GameQuestionService gameQuestionService;

	@Autowired
	@Qualifier("questionService")
	private QuestionService questionService;

	/**
	 * @Description: 返回问题的答案及类型问题接口
	 * @param request
	 *            请求参数集合
	 * @param response
	 *            响应对象集合
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            每一页大小
	 * @param questionId
	 *            问题ID
	 * @param gameId
	 *            游戏ID
	 * @param callback
	 *            回调函数
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping("searchAnswer")
	public void searchAnswer(HttpServletRequest request,
			HttpServletResponse response, String currentPage, String pageSize,
			String questionId, String gameId, String callback) {

		Question question = downjoySolrService.queryQuestionById(questionId);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		// 以下是封装成统一的返回数据的实体类
		ResponseData responseData = new ResponseData();

		// ================问题答案==========================
		if (question != null) {
			ResponseAnswer responseAnswer = null;
			ResponseAnswerResult responseAnswerResult = new ResponseAnswerResult();
			List<Answer> listAnswer = null;
			responseAnswerResult = new ResponseAnswerResult();
			responseAnswerResult.setQid(question.getId());
			responseAnswerResult.setQpv(String.valueOf(question.getPv()));
			responseAnswerResult.setQtitle(question.getTitle());
			responseAnswerResult.setQdescription(question.getDescription());
			responseAnswerResult.setQusername(question.getUsername());
			try {
				responseAnswerResult.setQcreatetime(simpleDateFormat
						.format(DateUtil.parseDate(question.getCreatetime())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			listAnswer = question.getAnswers();
			if (listAnswer != null && !listAnswer.isEmpty()) {
				for (Answer answer : listAnswer) {
					responseAnswer = new ResponseAnswer();
					responseAnswer.setAbestmark(answer.isBestmark());
					responseAnswer.setAcontext(answer.getContext());
					responseAnswer.setAusername(answer.getUsername());
					responseAnswer.setAcreatetime(answer.getCreatetime());
					responseAnswerResult.getAcontext().add(responseAnswer);
				}
			}
			responseData.setAnswerResult(responseAnswerResult);

		}

		// =====================相似问题答案=============================
		List<ResponseSimiResult> similist;
		List<ResponseSimiResult> replaceList;
		try {
			similist = requestSolrSearchService.getSimilarityService(gameId,
					questionId);

			if (similist != null && !similist.isEmpty()) {
				replaceList = new ArrayList<ResponseSimiResult>();
				for (ResponseSimiResult responseSimiResult : similist) {
					if (responseSimiResult.getQcreatime() != null
							&& !"null"
									.equals(responseSimiResult.getQcreatime())
							&& !"".equals(responseSimiResult.getQcreatime())) {
						responseSimiResult.setQcreatime(simpleDateFormat
								.format(DateUtil.parseDate(responseSimiResult
										.getQcreatime())));
					}
					replaceList.add(responseSimiResult);
				}
				if (replaceList != null) {
					responseData.getSimilarity().addAll(replaceList);
				}
			}
		} catch (Exception e) {
			logger.info("查询答案，及相关问题出错: " + e.getMessage());
			e.printStackTrace();
		}
		// 将model中的数据转换为JSON格式
		JSON json = JSONSerializer.toJSON(responseData);
		// 得到JSONP的callback函数名称
		// 将数据填充到callback，并回调
		StringBuffer buf = new StringBuffer();
		if (callback != null) {
			buf.append(callback);
			buf.append("(");
			buf.append(json.toString());
			buf.append(");");

		} else {
			buf.append(json.toString());
		}

		response.setCharacterEncoding("UTF-8"); // 设置编码格式
		response.setContentType("text/html"); // 设置数据格式
		// response.setContentType("application/octet-stream");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(buf.toString()); // 将json数据写入流中
			out.flush();
		} catch (IOException e) {
			logger.info("获取答案及类似问题破抛IOException： " + e.getMessage());
		}

	}

	/**
	 * @Description: 请求的标题列表接口类型
	 * @param request
	 *            请求对象集合
	 * @param response
	 *            响应对象集合
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            每页大小
	 * @param gameId
	 *            游戏ID
	 * @param callback
	 *            回调函数
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping("searchTitleList")
	public void searchTitleList(HttpServletRequest request,
			HttpServletResponse response, String currentPage, String pageSize,
			String gameId, String callback) {
		String flag = request.getParameter("flag");
		if (currentPage == null || "".equals(currentPage)) {
			currentPage = "1";
		}
		if (pageSize == null || "".equals(pageSize)) {
			pageSize = "7";
		}
		String sort = SolrContents.Index_Fields.Q_PV;
		if (flag != null && !"".equals(flag)) {
			sort = SolrContents.Index_Fields.Q_CREATETIME;
		}
		String q = "*";
		Page<Question> page = downjoySolrService.queryQuestion(q, gameId,
				Integer.valueOf(currentPage), Integer.valueOf(pageSize), sort);

		// 以下是封装成统一的返回数据的实体类
		List<ResponseSimiResult> list = new ArrayList<ResponseSimiResult>();
		if (page != null && page.getList() != null && !page.getList().isEmpty()) {
			List<Question> listQuestion = page.getList();
			for (Question question : listQuestion) {
				ResponseSimiResult responseSimiReuslt = new ResponseSimiResult();
				responseSimiReuslt.setQid(question.getId());
				responseSimiReuslt.setQtitle(question.getTitle());
				responseSimiReuslt.setQcreatime(question.getCreatetime());
				responseSimiReuslt.setTotalNum(String.valueOf(page
						.getTotalItemNumber()));
				list.add(responseSimiReuslt);
			}
		}
		// 将model中的数据转换为JSON格式
		JSON json = JSONSerializer.toJSON(list);
		// 得到JSONP的callback函数名称
		// 将数据填充到callback，并回调
		StringBuffer buf = new StringBuffer();
		if (callback != null) {

			buf.append(callback);
			buf.append("(");
			buf.append(json.toString());
			buf.append(");");
		} else {
			buf.append(json.toString());
		}

		response.setCharacterEncoding("UTF-8"); // 设置编码格式
		response.setContentType("text/html"); // 设置数据格式
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(buf.toString()); // 将json数据写入流中
			out.flush();
		} catch (IOException e) {
			logger.info("请求的标题列表接口 :" + e.getMessage());
		}

	}

	/**
	 * @Description: 关键词预留接口（直接查询数据返回结果）
	 * @param gameId
	 *            游戏ID
	 * @param keyWord
	 *            关键词
	 * @return List<KeyWordRelation> 返回类型
	 * @throws
	 */
	@RequestMapping("getKeyWords")
	@ResponseBody
	public List<KeyWordRelation> getKeyWordKeyWords(String gameId,
			String keyWord) {
		List<KeyWordRelation> list = null;
		if (StringUtils.isEmpty(gameId)) {
			list = keyWordRelationService.getGameKeyWords(keyWord);
		} else {
			list = keyWordRelationService.getKeyWordKeyWords(gameId, keyWord);
		}
		return list;
	}

	/**
	 * @Description: 获取关键词提示接口(通过solr服务直接查询)
	 * @param gameId
	 *            游戏ID
	 * @param keyWord
	 *            关键词
	 * @return List<String> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "getKeyWordRelationTip", method = RequestMethod.GET)
	public void getKeyWordRelationTip(HttpServletResponse response,
			HttpServletRequest request, String gameId, String keyWord,
			String callback) {
		String encodeKeyword = request.getParameter("keyWord");
		if (encodeKeyword != null) {
			try {
				encodeKeyword = new String(
						encodeKeyword.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		List<String> suggestionList = null;
		try {
			suggestionList = solrService.KeyWordSeachTip(gameId, encodeKeyword);
		} catch (SolrServerException e) {
			logger.info("获取关键词提示出现错误:" + e.getMessage());
		}
		responseJSON(response, suggestionList, callback);
	}

	/**
	 * @Description: 获取游戏列表接口
	 * @param response
	 *            返回对象的集合
	 * @param callback
	 *            回调函数
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping("getGameDetailList")
	public void getGameDetailList(HttpServletResponse response, String callback) {
		List<ResponseGameDetail> responseGameDetailList = null;
		try {
			List<GameDetailInfo> gameDetailList = gameDetailInfoService
					.select();
			if (gameDetailList != null && !gameDetailList.isEmpty()) {
				responseGameDetailList = new ArrayList<ResponseGameDetail>();
				for (GameDetailInfo gameDetailInfo : gameDetailList) {
					ResponseGameDetail responseGameDetail = new ResponseGameDetail();
					responseGameDetail.setGameId(gameDetailInfo.getId());
					responseGameDetail
							.setGameName(gameDetailInfo.getGameName());
					responseGameDetail
							.setGameIcon(gameDetailInfo.getGameIcon());
					responseGameDetailList.add(responseGameDetail);
				}
			}
		} catch (BaseException e) {
			logger.info("获取游戏列表出现异常：" + e.getMessage());
		}
		responseJSON(response, responseGameDetailList, callback);
	}

	/**
	 * @Description: 获取类似关键词
	 * @param gameId
	 *            游戏ID
	 * @param keyWord
	 *            关键词
	 * @return List<String> 返回类型
	 * @throws
	 */
	@RequestMapping("getSimilarityKeyWord")
	public void getSimilarityKeyWord(HttpServletResponse response,
			HttpServletRequest request, String gameId, String keyWord,
			String callback) {
		String encodeKeyword = request.getParameter("keyWord");
		if (encodeKeyword != null) {
			try {
				encodeKeyword = new String(
						encodeKeyword.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		List<String> similarityKeyWordList = null;
		try {
			similarityKeyWordList = solrService.similarityKeyWord(gameId,
					encodeKeyword);
		} catch (SolrServerException e) {
			logger.info("获取类似关键词错误:" + e.getMessage());
		}
		responseJSON(response, similarityKeyWordList, callback);
	}

	/**
	 * @Description: 可以实现输入“错误”提示，如：输入“刀嗒游戏”搜索时，提示：您是不是要找“刀塔游戏”
	 * @param gameId
	 *            游戏Id
	 * @param keyWord
	 *            关键词
	 * @return List<String> 返回类型
	 * @throws SolrServerException
	 */
	@RequestMapping("getAutoCorrectKeyWord")
	public void getAutoCorrectKeyWord(HttpServletResponse response,
			HttpServletRequest request, String gameId, String keyWord,
			String callback) {

		String encodeKeyword = request.getParameter("keyWord");
		if (encodeKeyword != null) {
			try {
				encodeKeyword = new String(
						encodeKeyword.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		List<String> autoCorrectionList = null;
		try {
			autoCorrectionList = solrService.autoCorrectKeyWord(gameId,
					encodeKeyword);
		} catch (SolrServerException e) {
			logger.info("智能纠错出现错误" + e.getMessage());
		}

		responseJSON(response, autoCorrectionList, callback);
	}

	/**
	 * @Description: 获取关键词(或者热门关键词)
	 * @param gameId
	 *            游戏Id
	 * @param isSortByHighFrequency
	 *            是否查询高频词
	 * @return List<ResponseKeyWord> 返回类型
	 * @throws SolrServerException
	 */
	@RequestMapping("searchKeyWord")
	public void searchKeyWord(HttpServletResponse response, String gameId,
			Boolean isSortByHighFrequency, String callback) {
		List<ResponseKeyWord> seachKeyWordList = null;
		try {
			if (isSortByHighFrequency == null
					|| "".equals(isSortByHighFrequency)) {
				isSortByHighFrequency = false;
			}
			seachKeyWordList = solrService.searchKeyWord(gameId,
					isSortByHighFrequency);
		} catch (SolrServerException e) {
			logger.info("获取热门关键词错误" + e.getMessage());
		}

		responseJSON(response, seachKeyWordList, callback);
	}

	/**
	 * @Description: 多游戏搜索，进行分组
	 * @param keyWord
	 *            关键词
	 * @return Map<String,Long> 返回类型
	 * @throws SolrServerException
	 */
	@RequestMapping("searchKeyWordBygroup")
	public void searchKeyWordBygroup(HttpServletResponse response,
			HttpServletRequest request, String gameId, String keyWord,
			String callback) {
		String encodeKeyword = request.getParameter("keyWord");
		if (encodeKeyword != null) {
			try {
				encodeKeyword = new String(
						encodeKeyword.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		try {
			List<Question> list = solrService.searchKeyWordBygroup(gameId,
					encodeKeyword);
			responseJSON(response, list, callback);
		} catch (SolrServerException e) {
			logger.info("多游戏搜索进行分组失败!" + e.getMessage());
		}

	}

	/**
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param response
	 * @param gameId
	 * @param callback
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping("searchGameQuestion")
	public void searchGameQuestion(HttpServletResponse response, String gameId,
			String callback) {
		Integer num = gameQuestionService.searchQuestionByGameId(gameId);
		ResponseGameQuestion responseGameQuestion = new ResponseGameQuestion();
		responseGameQuestion.setGameId(gameId);
		responseGameQuestion.setGameQuestionNum(String.valueOf(num));
		responseJSON(response, responseGameQuestion, callback);
	}

	/**
	 * @Description: 返回Json的公共方法
	 * @param response
	 *            响应对象集合
	 * @param obj
	 *            转换为json对象的源数据
	 * @param callback
	 *            回调函数
	 * @return void 返回类型
	 * @throws
	 */
	private void responseJSON(HttpServletResponse response, Object obj,
			String callback) {
		// 将model中的数据转换为JSON格式
		JSON json = JSONSerializer.toJSON(obj);
		// 得到JSONP的callback函数名称
		// 将数据填充到callback，并回调
		StringBuffer buf = new StringBuffer();
		if (callback != null) {

			buf.append(callback);
			buf.append("(");
			buf.append(json.toString());
			buf.append(");");
		} else {
			buf.append(json.toString());
		}

		response.setCharacterEncoding("UTF-8"); // 设置编码格式
		response.setContentType("text/html"); // 设置数据格式
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(buf.toString()); // 将json数据写入流中
			out.flush();
		} catch (IOException e) {
			logger.info("返回json的公共方法抛出异常:" + e.getMessage());
		}
	}

	/**
	 * @Description: 获取标题和答案
	 * @param response
	 *            响应参数集合
	 * @param request
	 *            请求参数集合
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            每页的大小
	 * @param gameId
	 *            游戏ID
	 * @param callback
	 *            回调函数 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping("/bestAnswer")
	public void searchTitleAndAnswer(HttpServletResponse response,
			HttpServletRequest request, String currentPage, String pageSize,
			String gameId, String flag, String callback) {
		if (currentPage == null || "".equals(currentPage)) {
			currentPage = "1";
		}
		if (pageSize == null || "".equals(pageSize)) {
			pageSize = "7";
		}
		String sort = SolrContents.Index_Fields.Q_PV;
		if (flag != null && !"".equals(flag)) {
			sort = SolrContents.Index_Fields.Q_CREATETIME;
		}
		String q = "*";
		Page<Question> page = downjoySolrService.queryQuestion(q, gameId,
				Integer.valueOf(currentPage), Integer.valueOf(pageSize), sort);

		// 以下是封装成统一的返回数据的实体类
		List<ResponseTitleAnswer> list = new ArrayList<ResponseTitleAnswer>();
		if (page != null && page.getList() != null && !page.getList().isEmpty()) {
			List<Question> listQuestion = page.getList();
			for (Question question : listQuestion) {
				ResponseTitleAnswer responseTitleAnswer = new ResponseTitleAnswer();
				responseTitleAnswer.setQid(question.getId());
				responseTitleAnswer.setQtitle(question.getTitle());
				responseTitleAnswer.setQcreatime(question.getCreatetime());
				responseTitleAnswer.setTotalNum(String.valueOf(page
						.getTotalItemNumber()));
				List<Answer> listAnswer = question.getAnswers();
				if (listAnswer != null && !listAnswer.isEmpty()) {
					for (Answer answer : listAnswer) {
						if (answer.isBestmark()) {
							responseTitleAnswer.setAnswer(answer);
							break;
						}
					}
				}
				list.add(responseTitleAnswer);
			}
		}

		responseJSON(response, list, callback);
	}

	/**
	 * @Description: 相似的问题标题和答案
	 * @param response
	 * @param request
	 * @param currentPage
	 * @param pageSize
	 * @param gameId
	 * @param callback
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping("similarityBestAnswer")
	public void searchSimilarityTitleAnswer(HttpServletResponse response,
			HttpServletRequest request, String currentPage, String pageSize,
			String questionId, String flag, String gameId, String callback) {
		Question question = downjoySolrService.queryQuestionById(questionId);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");

		// 以下是封装成统一的返回数据的实体类
		ResponseSimiTitleAnswerData responseData = new ResponseSimiTitleAnswerData();

		// ================问题答案==========================
		if (question != null) {
			ResponseAnswer responseAnswer = null;
			ResponseAnswerResult responseAnswerResult = new ResponseAnswerResult();
			List<Answer> listAnswer = null;
			responseAnswerResult = new ResponseAnswerResult();
			responseAnswerResult.setQid(question.getId());
			responseAnswerResult.setQpv(String.valueOf(question.getPv()));
			responseAnswerResult.setQtitle(question.getTitle());
			responseAnswerResult.setQdescription(question.getDescription());
			responseAnswerResult.setQusername(question.getUsername());
			try {
				responseAnswerResult.setQcreatetime(simpleDateFormat
						.format(DateUtil.parseDate(question.getCreatetime())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			listAnswer = question.getAnswers();
			if (listAnswer != null && !listAnswer.isEmpty()) {
				for (Answer answer : listAnswer) {
					responseAnswer = new ResponseAnswer();
					responseAnswer.setAbestmark(answer.isBestmark());
					responseAnswer.setAcontext(answer.getContext());
					responseAnswer.setAusername(answer.getUsername());
					responseAnswer.setAcreatetime(answer.getCreatetime());
					responseAnswerResult.getAcontext().add(responseAnswer);
				}
			}
			responseData.setAnswerResult(responseAnswerResult);

		}

		// =====================相似问题答案=============================
		List<ResponseTitleAnswer> similist;
		List<ResponseTitleAnswer> replaceList;
		try {
			similist = requestSolrSearchService.getSimilarityTitleAnswer(
					gameId, questionId, flag);

			if (similist != null && !similist.isEmpty()) {
				replaceList = new ArrayList<ResponseTitleAnswer>();
				for (ResponseTitleAnswer responseSimiResult : similist) {
					if (responseSimiResult.getQcreatime() != null
							&& !"null"
									.equals(responseSimiResult.getQcreatime())
							&& !"".equals(responseSimiResult.getQcreatime())) {
						responseSimiResult.setQcreatime(simpleDateFormat
								.format(DateUtil.parseDate(responseSimiResult
										.getQcreatime())));
					}
					replaceList.add(responseSimiResult);
				}
				if (replaceList != null) {
					responseData.getSimilarity().addAll(replaceList);
				}
			}
		} catch (Exception e) {
			logger.info("查询答案，及相关问题出错: " + e.getMessage());
			e.printStackTrace();
		}
		responseJSON(response, responseData, callback);
	}

	/**
	 * @Description: 未采纳的问题
	 * @param response
	 * @param request
	 * @param flag
	 * @param currentPage
	 * @param pageSize
	 * @param callback
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping("searchIsNotAdopt")
	public void searchIsNotAdoptQuestion(HttpServletResponse response,
			HttpServletRequest request, String flag, String currentPage,
			String pageSize, String callback) {
		RequestAdopt requestAdopt = new RequestAdopt();
		if ("1".equals(flag)) {
			requestAdopt.setCreateTime(true);
		} else if ("2".equals(flag)) {
			requestAdopt.setQuestionRewardPoints(true);
		}
		List<ResponseQuestion> responseGameQuestionlist = questionService
				.getIsNotAdoptQuestions(requestAdopt);

		responseJSON(response, responseGameQuestionlist, callback);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void uploadFile(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest
				.getFile("file");

		String name = multipartRequest.getParameter("name");
		System.out.println("name: " + name);
		// 获得文件名：
		String realFileName = file.getOriginalFilename();
		System.out.println("获得文件名：" + realFileName);
		// 获取路径
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "images/";
		// 创建文件
		File dirPath = new File(ctxPath);
		if (!dirPath.exists()) {
			dirPath.mkdir();
		}
		File uploadFile = new File(ctxPath + realFileName);
		FileCopyUtils.copy(file.getBytes(), uploadFile);
		request.setAttribute("files", loadFiles(request));
	}

	@RequestMapping(value = "/upload2", method = RequestMethod.POST)
	public void onSubmit2(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {

		// 转型为MultipartHttpRequest
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 根据前台的name名称得到上传的文件
		MultipartFile file = multipartRequest.getFile("file");
		// 获得文件名：
		String realFileName = file.getOriginalFilename();
		// 获取路径
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "\\" + "images\\";
		// 创建文件
		File dirPath = new File(ctxPath);
		if (!dirPath.exists()) {
			dirPath.mkdir();
		}
		File uploadFile = new File(ctxPath + realFileName);
		FileCopyUtils.copy(file.getBytes(), uploadFile);
		request.setAttribute("files", loadFiles(request));
	}

	@RequestMapping(value = "/upload3", method = RequestMethod.POST)
	public void upload(@RequestParam("file") MultipartFile image,
			HttpServletRequest request) throws IOException {

		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "\\" + "images\\";
		System.out.println("路径：" + ctxPath);
		File file = new File(ctxPath + "/" + image.getOriginalFilename());
		// FileCopyUtils.copy(image.getBytes(),new
		// File(ctxPath+"/"+image.getOriginalFilename()));
		try {
			image.transferTo(file); // 保存上传的文件
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.setAttribute("files", loadFiles(request));
	}

	// 多文件上传
	@RequestMapping(value = "/upload4", method = RequestMethod.POST)
	public void fileUpload(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "\\" + "images\\";

		File file = new File(ctxPath);
		if (!file.exists()) {
			file.mkdir();
		}
		String fileName = null;
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			// 上传文件名
			// System.out.println("key: " + entity.getKey());
			MultipartFile mf = entity.getValue();
			fileName = mf.getOriginalFilename();
			File uploadFile = new File(ctxPath + fileName);
			FileCopyUtils.copy(mf.getBytes(), uploadFile);
		}
		request.setAttribute("files", loadFiles(request));

	}

	// @ModelAttribute("files")//此属性用于初始类时调用,但上传文件后不能时时反应上传文件个数,不适合动态数据
	public List<String> loadFiles(HttpServletRequest request) {
		List<String> files = new ArrayList<String>();
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "\\" + "images\\";
		File file = new File(ctxPath);
		if (file.exists()) {
			File[] fs = file.listFiles();
			String fname = null;
			for (File f : fs) {
				fname = f.getName();
				if (f.isFile()) {
					files.add(fname);
				}
			}
		}
		return files;
	}

	@RequestMapping("/download/{fileName}")
	public void download(@PathVariable("fileName") String fileName,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;

		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "\\" + "images\\";
		String downLoadPath = ctxPath + fileName;
		System.out.println(downLoadPath);
		try {
			long fileLength = new File(downLoadPath).length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String(fileName.getBytes("utf-8"), "ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
	}

}
