package com.downjoy.iask.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.downjoy.iask.domain.ResponseSimiResult;
import com.downjoy.iask.domain.ResponseTitleAnswer;
import com.downjoy.iask.service.RequestSolrSearchService;
import com.downjoy.iask.service.baseservice.SolrSearchService;

/**
 * 请求solr服务器进行查询
 * 
 * @author jian.yang@downjoy.com
 * 
 */

@Service("requestSolrSearchService")
public class RequestSolrSearchServiceImpl implements RequestSolrSearchService {

	Logger logger = Logger.getLogger(RequestSolrSearchServiceImpl.class);

	@Autowired
	@Qualifier("solrSearchService")
	private SolrSearchService solrSearchService;

	/**
	 * @Description: 获取类似问题
	 * @param questionId
	 *            问题ID
	 * @param gameId
	 *            游戏ID
	 * @return List<ResponseSimiResult> 返回类似问题
	 * @throws Exception
	 */

	@Override
	public List<ResponseSimiResult> getSimilarityService(String gameId,
			String questionId) throws Exception {
		return solrSearchService.getSimilarityService(gameId, questionId);
	}

	/**
	 * @Description: 获取类似问题
	 * @param questionId
	 *            问题ID
	 * @param gameId
	 *            游戏ID
	 * @param flag
	 *            问答是否按时间排序
	 * @return List<ResponseTitleAnswer> 返回类似问题
	 * @throws Exception
	 */
	@Override
	public List<ResponseTitleAnswer> getSimilarityTitleAnswer(String gameId,
			String questionId, String flag) throws Exception {
		return solrSearchService.getSimilarityTitleAnswer(gameId, questionId,
				flag);
	}

	@Override
	public List<ResponseSimiResult> getUserQuestions(String userId) {
		return solrSearchService.getUserQuestions(userId);
	}

	@Override
	public List<ResponseSimiResult> getSimilarityService(String questionId)
			throws Exception {
		return null;
	}

}
