package com.downjoy.iask.dao;

import java.util.List;

import com.downjoy.iask.dao.basedao.BaseDao;
import com.downjoy.iask.domain.Questions;
import com.downjoy.iask.domain.RequestAdopt;
import com.downjoy.iask.domain.RequestRecommendation;

public interface QuestionDao extends BaseDao<Questions, Long> {

	/**
	 * @Description: 查询未被采纳的问题
	 * @param requestAdopt
	 * @return 设定文件
	 * @return List<Questions> 返回类型
	 * @throws
	 */
	public List<Questions> queryIsNotAdopt(RequestAdopt requestAdopt);

	/**
	 * @Description: 保存问题提交的数据
	 * @param questions
	 * @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public int insertQuestion(Questions questions);

	public int queryBrowseNum(Questions questions);

	public List<RequestRecommendation> getRecommendationContent();

}
