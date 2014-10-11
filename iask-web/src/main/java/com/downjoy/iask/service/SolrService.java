/**   
 * @Description: solr业务逻辑接口
 * @author jian.yang@downjoy.com
 * @date 2014年8月26日 下午1:43:59 
 * @version V1.0   
 */
package com.downjoy.iask.service;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrException;

import com.downjoy.iask.domain.ResponseKeyWord;
import com.downjoy.iask.model.Question;

/**
 * @Description: solr业务逻辑接口
 * @author jian.yang@downjoy.com
 * @date 2014年8月26日 下午1:43:59
 * @version 1.0
 */
public interface SolrService
{
    /**
     * @Description: 关键词与关键词联调提示
     * @param keyWord
     *            关键词
     * @param gameId
     *            游戏ID
     * @return List<String> 返回类型
     * @throws SolrServerException
     *             solr服务异常
     */
    List<String> KeyWordSeachTip(String gameId, String keyWord)
            throws SolrServerException;

    /**
     * @Description: 获取类似关键词接口(而且热度很高的关键词，可以参考PV值)
     * @param gameId
     *            游戏ID
     * @param keyWord
     *            关键词
     * @return List<String> 返回类型
     * @throws SolrServerException
     */
    List<String> similarityKeyWord(String gameId, String keyWord)
            throws SolrServerException;

    /**
     * @Description: 可以实现输入“错误”提示，如：输入“刀嗒游戏”搜索时，提示：您是不是要找“刀塔游戏”
     * @param gameId
     *            游戏Id
     * @param keyWord
     *            关键词
     * @return List<String> 返回类型
     * @throws SolrServerException
     */
    List<String> autoCorrectKeyWord(String gameId, String keyWord)
            throws SolrServerException;

    /**
     * @Description: 获取关键词
     * @param gameId
     *            游戏Id
     * @param isSortByHighFrequency
     *            是否高频词排序
     * @return List<ResponseKeyWord> 返回类型
     * @throws SolrServerException
     */
    List<ResponseKeyWord> searchKeyWord(String gameId,
            Boolean isSortByHighFrequency) throws SolrServerException;

    /**
     * @Description: 多游戏搜索，进行分组
     * @param keyWord
     *            关键词
     * @param gameId
     *            游戏ID
     * @return List<Question> 返回类型
     * @throws SolrServerException
     */
    List<Question> searchKeyWordBygroup(String gameId, String keyWord)
            throws SolrServerException;
    
    
}
