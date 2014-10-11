/**   
 * @Description: solr服务业务逻辑类 
 * @author jian.yang@downjoy.com
 * @date 2014年8月27日 上午10:46:06 
 * @version V1.0   
 */
package com.downjoy.iask.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.downjoy.iask.domain.ResponseKeyWord;
import com.downjoy.iask.model.Question;
import com.downjoy.iask.service.SolrService;
import com.downjoy.iask.service.baseservice.SolrSearchService;

/**
 * @Description: solr服务业务逻辑类
 * @author jian.yang@downjoy.com
 * @date 2014年8月27日 上午10:46:06
 * @version 1.0
 */
@Service("solrService")
public class SolrServiceImpl implements SolrService
{
    @Autowired
    @Qualifier("solrSearchService")
    private SolrSearchService solrSearchService;

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
    @Override
    public List<String> KeyWordSeachTip(String gameId, String keyWord)
            throws SolrServerException
    {
        return solrSearchService.getKeywordRelationTip(gameId, keyWord);
    }

    /**
     * @Description: 获取类似关键词接口
     * @param gameId
     *            游戏ID
     * @param keyWord
     *            关键词
     * @return List<String> 返回类型
     * @throws SolrServerException
     */
    @Override
    public List<String> similarityKeyWord(String gameId, String keyWord)
            throws SolrServerException
    {
        return solrSearchService.getSimilarityKeyWord(gameId, keyWord);
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
    @Override
    public List<String> autoCorrectKeyWord(String gameId, String keyWord)
            throws SolrServerException
    {

        return solrSearchService.getAutoCorrectKeyWord(gameId, keyWord);
    }

    /**
     * @Description: 获取关键词
     * @param gameId
     *            游戏Id
     * @param isSortByHighFrequency
     *            是否高频词排序
     * @return List<ResponseKeyWord> 返回类型
     * @throws SolrServerException
     */
    @Override
    public List<ResponseKeyWord> searchKeyWord(String gameId,
            Boolean isSortByHighFrequency) throws SolrServerException
    {
        return solrSearchService.searchKeyWord(gameId, isSortByHighFrequency);
    }

    /**
     * @Description: 多游戏搜索，进行分组
     * @param keyWord
     *            关键词
     * @param gameId
     *            游戏Id
     * @return Map<String,Long> 返回类型
     * @throws SolrServerException
     */
    @Override
    public List<Question> searchKeyWordBygroup(String gameId, String keyWord)
            throws SolrServerException
    {
        return solrSearchService.searchKeyWordBygroup(gameId,keyWord);
    }

}
