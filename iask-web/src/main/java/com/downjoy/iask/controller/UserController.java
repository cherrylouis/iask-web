package com.downjoy.iask.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.downjoy.iask.domain.Inform;
import com.downjoy.iask.domain.ResponseSimiResult;
import com.downjoy.iask.domain.User;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.model.RestResult;
import com.downjoy.iask.service.InformService;
import com.downjoy.iask.service.QuestionService;
import com.downjoy.iask.service.RequestSolrSearchService;
import com.downjoy.iask.service.UserService;
import com.downjoy.iask.util.Constants;
import com.downjoy.iask.util.CookieUtils;

/**
 * @Description: 用户控制器类
 * @author jian.yang@downjoy.com
 * @date 2014年9月2日 上午9:00:58
 * @version 1.0
 */
@Controller
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private InformService informService;

	@Autowired
	@Qualifier("requestSolrSearchService")
	private RequestSolrSearchService requestSolrSearchService;

	/**
	 * 举报信息接口
	 * 
	 * @param userId
	 *            用户ID
	 * @param questionId
	 *            问题ID
	 * @param informUrl
	 *            举报地址
	 * @param informContent
	 *            举报内容
	 * @param informType
	 *            举报类型
	 * @param request
	 *            请求参数
	 * @param response
	 *            返回参数
	 */
	@RequestMapping(value = "uploadInformInfo", method = RequestMethod.GET)
	public void uploadInformInfo(Long userId, Long questionId,
			String informUrl, String informContent, String informType,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			Inform inform = informService.get(questionId);
			if (inform == null) {
				inform = new Inform();
				inform.setQuestionId(questionId);
				inform.setUserId(userId);
				inform.setInformUrl(informUrl);
				inform.setInformContent(informContent);
				inform.setInformType(informType);
				inform.setInformNum(1);
				informService.insert(inform);
			} else {
				// inform.setQuestionId(questionId);
				// inform.setUserId(userId);
				// inform.setInformUrl(informUrl);
				// inform.setInformContent(informContent);
				// inform.setInformType(informType);
				inform.setInformNum(inform.getInformNum() + 1);
				informService.update(inform);
			}
		} catch (BaseException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) {

		// Cookie[] cookies = request.getCookies();
		// for (Cookie c : cookies) {
		// String name = c.getName();
		// if (name.contains("DJ_MEMBER_INFO")) {
		// String value = c.getValue();
		// String userName = value.substring(0, value.indexOf("%"));
		// String userId = value.substring(value.indexOf("%") + 1,
		// value.lastIndexOf("%"));
		// break;
		// }
		// }

		// System.out.println(userService);
		//
		// System.out.println(userTrackerMemcachedClient);
		// // 尝试登录
		// UserTrackerHelper.tryLogin(userTrackerMemcachedClient, request,
		// response, true);
		// // 通过request获取用户信息
		// UserTracker userTracker = UserTrackerHelper
		// .getUserTrackerFromReqAttr(request);
		//
		// System.out.println(userTracker);
		// //检测用户是否登录，true登录成功，false登录失败
		// Boolean flag = UserTrackerHelper.isLogined(userTracker);
		// //获取用户信息
		// Long mid = userTracker.getMemberId();
		// //获取消息数
		// UserTrackerHelper.getNewMessageCnt(request,userTracker);

		// 获取用户信息
		// Long mid = userTracker.getMemberId();
		// 获取消息数
		// UserTrackerHelper.getNewMessageCnt(request, userTracker);

		// System.out.println(""+userTracker.getMemberId());
		// System.out.println("flag=" + flag);
		// System.out.println("mid=" + mid);

		// System.out.println("index");
		return "index";
	}

	/**
	 * 登录接口
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public @ResponseBody RestResult login(HttpServletRequest request,
			HttpServletResponse response) {

		User user = CookieUtils.getUserInfo(request);

		try {
			if (user != null) {
				if (userService.getUserCount(user.getId()) == 0) {
					userService.insert(user);
				} else {
					userService.update(user);
				}
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (BaseException e1) {
			e1.printStackTrace();
		}

		RestResult restResult = new RestResult();
		restResult.setData(user);

		if (user != null) {
			request.getSession().setAttribute(Constants.CURRENT_USER_ID,
					String.valueOf(user.getId()));
			request.getSession().setAttribute(Constants.CURRENT_SESSION_USER,
					user);
		}

		return restResult;
	}

	/**
	 * 注册接口
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public @ResponseBody RestResult register(HttpServletRequest request,
			HttpServletResponse response) {
		User user = CookieUtils.getUserInfo(request);
		try {
			if (user != null) {
				if (userService.getUserCount(user.getId()) == 0) {
					userService.insert(user);
				} else {
					userService.update(user);
				}
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (BaseException e1) {
			e1.printStackTrace();
		}
		RestResult restResult = new RestResult();
		restResult.setData(user);
		return restResult;
	}

	/**
	 * @description 获取用户问答信息
	 * @param request
	 *            请求参数
	 * @return
	 */
	@RequestMapping(value = "showUserInfo", method = RequestMethod.GET)
	public @ResponseBody List<ResponseSimiResult> showUserInfo(String userId,
			HttpServletRequest request, HttpServletResponse response) {

		List<ResponseSimiResult> rList = new ArrayList<ResponseSimiResult>();

		if (userId != null) {
			rList.addAll(requestSolrSearchService.getUserQuestions(userId));
		}

		return rList;
	}

	/**
	 * 回答数排行
	 * 
	 * @param beginData
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @param rows
	 *            返回多少个
	 * @param request
	 * @param response
	 * @return
	 */
	public @ResponseBody RestResult getAnswerNumberList(String beginDate,
			String endDate, int rows, HttpServletRequest request,
			HttpServletResponse response) {

		RestResult restResult = new RestResult();

		if (beginDate != null && endDate != null) {
			try {
				restResult.setData(userService.getAdoptionList(beginDate,
						endDate));
			} catch (BaseException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	/**
	 * 采纳率排行
	 * 
	 * @param beginData
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @param rows
	 *            返回多少个
	 * @param request
	 * @param response
	 * @return
	 */
	public @ResponseBody RestResult getAdoptionList(String beginDate,
			String endDate, int rows, HttpServletRequest request,
			HttpServletResponse response) {

		RestResult restResult = new RestResult();

		if (beginDate != null && endDate != null) {
			try {
				restResult.setData(userService.getAdoptionList(beginDate,
						endDate));
			} catch (BaseException e) {
				e.printStackTrace();
			}
		}

		return null;

	}

	/**
	 * 获取用户信息
	 * 
	 * @param userId
	 * @param request
	 * @param response
	 * @return
	 */
	public @ResponseBody RestResult getUserInfo(String userId,
			HttpServletRequest request, HttpServletResponse response) {

		RestResult restResult = new RestResult();

		if (userId != null) {
			try {
				restResult.setData(userService.getUserInfo(Integer
						.valueOf(userId)));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (BaseException e) {
				e.printStackTrace();
			}
		}

		return restResult;
	}

}