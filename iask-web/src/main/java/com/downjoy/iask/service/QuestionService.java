package com.downjoy.iask.service;

import java.util.List;

import com.downjoy.iask.domain.Questions;
import com.downjoy.iask.domain.RequestAdopt;
import com.downjoy.iask.domain.RequestRecommendation;
import com.downjoy.iask.domain.ResponseQuestion;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.service.baseservice.BaseService;

public interface QuestionService extends BaseService<Questions, Long> {


	/**
	 * @Description:根据问题的紧急度返回未被采纳的问题
	 * @param requestAdopt
	 *            请求未被采纳的参数
	 * @return 设定文件
	 * @return List<ResponseQuestion> 返回类型
	 * @throws
	 */
	public List<ResponseQuestion> getIsNotAdoptQuestions(
			RequestAdopt requestAdopt);

	/**
	 * @Description: 保存问题提交的数据
	 * @param questions
	 * @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public int insertQuestion(Questions questions);

	/**
	 * 查询浏览次数
	 * @param questions
	 * @return
	 * @throws BaseException
	 */
	public int queryBrowseNum(Questions questions) throws BaseException;

	/**
	 * 获取推荐内容
	 * @return
	 * @throws BaseException
	 */
	public List<RequestRecommendation> getRecommendationContent()
			throws BaseException;
}
