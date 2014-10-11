package com.downjoy.iask.service;

import com.downjoy.iask.model.Page;
import com.downjoy.iask.model.Question;

/**
 * @Description: 搜索标题及答案
 * @author jian.yang@downjoy.com
 * @date 2014年9月2日 上午9:03:21
 * @version 1.0
 */
public interface DownjoySolrService
{

    /**
     * @Description: 搜索标题业务方法
     * @param q
     *            查询的对象
     * @param gameId
     *            游戏ID
     * @param pageNum
     *            当前页数
     * @param pageSize
     *            每页大小
     * @param sort
     *            排序字段
     * @return Page<Question> 返回类型
     * @throws
     */
    public Page<Question> queryQuestion(String q, String gameId,
            Integer pageNum, Integer pageSize, String sort);

    /**
     * @Description: 搜索问题对应的答案
     * @param questionId
     *            问题id
     * @return Question 返回类型
     * @throws
     */
    public Question queryQuestionById(String questionId);
}
