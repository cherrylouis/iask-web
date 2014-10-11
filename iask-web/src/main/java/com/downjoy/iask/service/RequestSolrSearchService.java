package com.downjoy.iask.service;

import java.util.List;

import com.downjoy.iask.domain.ResponseSimiResult;
import com.downjoy.iask.domain.ResponseTitleAnswer;
import com.downjoy.iask.domain.User;

/**
 * @Description: 请求solr服务器查询service层泛型接口，定义基本的service功能
 * @author jian.yang@downjoy.com
 * @date 2014年9月1日 下午5:26:45
 * @version 1.0
 */
public interface RequestSolrSearchService {

    /**
     * @Description: 获取类似问题
     * @param questionId
     *            问题ID
     * @param gameId
     *            游戏ID
     * @return List<ResponseSimiResult> 返回类似问题
     * @throws Exception
     */
    List<ResponseSimiResult> getSimilarityService(String gameId,
            String questionId) throws Exception;

    /**
     * @Description: 获取类似问题
     * @param questionId
     *            问题ID
     * @param gameId
     *            游戏ID
     * @param flag
     *            是否按时间排序
     * @return List<ResponseTitleAnswer> 返回类似问题
     * @throws Exception
     */
    List<ResponseTitleAnswer> getSimilarityTitleAnswer(String gameId,
            String questionId, String flag) throws Exception;
	/**
	 * @Description: 获取类似问题
	 * @param questionId
	 *            问题ID
	 * @return List<ResponseSimiResult> 返回类似问题
	 * @throws Exception
	 */
	List<ResponseSimiResult> getSimilarityService(String questionId)
			throws Exception;

	/**
	 * 获取用户的回答问题数
	 * 
	 * @param userId
	 *            用户id
	 * @return 用户的回答数
	 */
	List<ResponseSimiResult> getUserQuestions(String userId);

}
