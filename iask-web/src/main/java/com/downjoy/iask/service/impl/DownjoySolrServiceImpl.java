package com.downjoy.iask.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.SortClause;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.downjoy.iask.dao.KeyWordRelationDao;
import com.downjoy.iask.domain.KeyWordRelation;
import com.downjoy.iask.domain.KeyWords;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.model.Page;
import com.downjoy.iask.model.Question;
import com.downjoy.iask.service.DownjoySolrService;
import com.downjoy.iask.util.IKAnalzyerUtil;
import com.downjoy.iask.util.SolrContents;
import com.downjoy.iask.util.SolrUtils;

/**
 * 
 * @Description: 中文分词业务逻辑类
 * @author jian.yang@downjoy.com
 * @date 2014年8月21日 下午2:53:54
 * @version 1.0
 */
@Service("downjoySolrService")
public class DownjoySolrServiceImpl implements DownjoySolrService
{
    @Autowired
    @Qualifier("keyWordRelationDao")
    private KeyWordRelationDao keyWordRelationDao;

    public KeyWordRelationDao getKeyWordRelationDao()
    {
        return keyWordRelationDao;
    }

    public void setKeyWordRelationDao(KeyWordRelationDao keyWordRelationDao)
    {
        this.keyWordRelationDao = keyWordRelationDao;
    }

    /**
     * <p>
     * Description:查询标题列表
     * </p>
     * 
     * @param q
     *            查询的参数
     * @param gameId
     *            游戏ID
     * @param pageNum
     *            当前页面
     * @param pageSize
     *            每一页的大小
     * @param sort
     *            排序字段
     * @return
     */
    @Override
    public Page<Question> queryQuestion(String q, String gameId,
            Integer pageNum, Integer pageSize, String sort)
    {

        boolean isBak = false;
        // 需要返回的数据
        List<Question> questions = new ArrayList<Question>();
        long num = 0;
        SolrDocumentList docs = null;
        try
        {
            QueryResponse queryResponse = null;
            if (StringUtils.isNotEmpty(q) && q.contains(" "))
            {
                queryResponse = tokenizeSearch(q, gameId, pageNum, pageSize,
                        sort);
            }
            else
            {
                // 优先使用短语查询
                queryResponse = phraseSearch(q, gameId, pageNum, pageSize, sort);
                if (queryResponse != null)
                {
                    docs = queryResponse.getResults();
                    num = docs.getNumFound();
                }
                // 没有结果，就使用指定专业关键词查询
                if (num < 1)
                {
                    List<KeyWords> list = IKAnalzyerUtil.getTerm(q);
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < list.size(); i++)
                    {
                        sb.append(list.get(i).getKeyWords());
                        if (i < list.size() - 1)
                        {
                            sb.append(" OR ");
                        }
                    }
                    queryResponse = tokenizeSearch(sb.toString(), gameId,
                            pageNum, pageSize, sort);
                }
                else
                {
                    isBak = true;// 告诉组装model的方法，这个地方返回的title应该去q_title_bak字段
                }
            }

            if (queryResponse != null)
            {
                docs = queryResponse.getResults();
                num = docs.getNumFound();
            }
            // 如果上面两种查询都没有结果，那么直接采用,solr的分词查询
            if (num < 1)
            {
                queryResponse = tokenizeSearch(StringUtils.remove(q, " "),
                        gameId, pageNum, pageSize, sort);
            }

            if (queryResponse != null)
            {
                docs = queryResponse.getResults();
                num = docs.getNumFound();
                Map<String, Map<String, List<String>>> highlightingMap = queryResponse
                        .getHighlighting();
                questions = SolrUtils.docToQuestions(docs, highlightingMap,
                        true, isBak);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        if (!isBak)
        {
            List<KeyWords> list = IKAnalzyerUtil.getTerm(q);
            if (list.size() > 1)
            {
                KeyWordRelation keyWordRelation = new KeyWordRelation();
                keyWordRelation.setSource(list.get(0).getKeyWords());
                keyWordRelation.setTarget(list.get(1).getKeyWords());
                keyWordRelation.setFirstId(list.get(0).getId());
                keyWordRelation.setSencondId(list.get(1).getId());

                try
                {
                    keyWordRelationDao.insert(keyWordRelation);
                }
                catch(BaseException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        Page<Question> page = new Page<Question>();
        page.setList(questions);
        page.setTotalItemNumber(num);
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);

        return page;
    }

    @Override
    public Question queryQuestionById(String id)
    {
        Question question = null;
        if (StringUtils.isEmpty(id))
        {
            return null;
        }
        try
        {
            // 设置solr查询
            SolrQuery solrQuery = new SolrQuery();
            solrQuery.setStart(0);
            solrQuery.setRows(1);
            StringBuffer queryBuffer = new StringBuffer();
            queryBuffer.append(SolrContents.Index_Fields.Q_ID);
            queryBuffer.append(SolrContents.DOUBLE_MARKS);
            queryBuffer.append(id);
            solrQuery.setParam("q", queryBuffer.toString());

            // 执行solr查询
            HttpSolrServer httpSolrServer = SolrUtils.getSolrServer();
            QueryResponse queryResponse = httpSolrServer.query(solrQuery);
            if (queryResponse != null)
            {
                SolrDocumentList docs = queryResponse.getResults();
                question = SolrUtils.docToQuestion(docs);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return question;
    }

    /**
     * 精确搜索，也就是完全匹配，不分词
     */
    private QueryResponse phraseSearch(String q, String gameId,
            Integer pageNum, Integer pageSize, String sort)
    {
        if (StringUtils.isEmpty(q))
        {
            return null;
        }
        if (pageNum <= 0 || pageSize <= 0)
        {
            return null;
        }
        try
        {
            // 设置solr查询
            SolrQuery solrQuery = new SolrQuery();
            // solrQuery.setSort(SortClause.asc(sort));
            solrQuery.setSort(SortClause.desc(sort)); // yangjian modify
            solrQuery.setStart((pageNum - 1) * pageSize);
            solrQuery.setRows(pageSize);

            // 高亮
            // solrQuery.setHighlight(true);
            // solrQuery.addHighlightField(SolrContents.Index_Fields.Q_TITLE);
            // //yangjian modify
            // solrQuery.addHighlightField(SolrContents.Index_Fields.Q_TITLE_BAK);
            // solrQuery.setHighlightSimplePre("<font color=\"red\">")
            // .setHighlightSimplePost("</font>");// 渲染标签

            StringBuffer queryBuffer = new StringBuffer();
            queryBuffer.append(SolrContents.Index_Fields.Q_TITLE_BAK);
            queryBuffer.append(SolrContents.DOUBLE_MARKS);
            queryBuffer.append(q);

            if (StringUtils.isNotEmpty(gameId))
            {
                queryBuffer.append(" AND ");
                queryBuffer.append(SolrContents.Index_Fields.Q_GAMEID);
                queryBuffer.append(SolrContents.DOUBLE_MARKS);
                // queryBuffer.append(q);
                queryBuffer.append(gameId);
            }

            // solrQuery.setQuery(queryBuffer.toString());
            solrQuery.setParam("q", queryBuffer.toString());

            // 执行solr查询
            HttpSolrServer httpSolrServer = SolrUtils.getSolrServer();
            QueryResponse queryResponse = httpSolrServer.query(solrQuery);

            return queryResponse;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 拆词搜索，支持AND和OR两种查询
     */
    private QueryResponse tokenizeSearch(String q, String gameId,
            Integer pageNum, Integer pageSize, String sort)
    {
        if (StringUtils.isEmpty(q))
        {
            return null;
        }
        try
        {
            // 设置solr查询
            SolrQuery solrQuery = new SolrQuery();
            // solrQuery.setSort(SortClause.asc(sort));
            solrQuery.setSort(SortClause.desc(sort));
            solrQuery.setStart((pageNum - 1) * pageSize);
            solrQuery.setRows(pageSize);

            // 高亮
            // solrQuery.setHighlight(true);
            // solrQuery.addHighlightField(SolrContents.Index_Fields.Q_TITLE);
            // yangjian modify
            // solrQuery.addHighlightField(SolrContents.Index_Fields.Q_TITLE_BAK);
            // solrQuery.setHighlightSimplePre("<font color=\"red\">")
            // .setHighlightSimplePost("</font>");// 渲染标签

            StringBuffer queryBuffer = new StringBuffer();
            queryBuffer.append(SolrContents.Index_Fields.Q_TITLE);
            queryBuffer.append(SolrContents.DOUBLE_MARKS);
            queryBuffer.append(q);

            if (StringUtils.isNotEmpty(gameId))
            {
                queryBuffer.append(" AND ");
                queryBuffer.append(SolrContents.Index_Fields.Q_GAMEID);
                queryBuffer.append(SolrContents.DOUBLE_MARKS);
                queryBuffer.append(gameId);
            }

            // solrQuery.setQuery(queryBuffer.toString());
            solrQuery.setParam("q", queryBuffer.toString());

            // 执行solr查询
            HttpSolrServer httpSolrServer = SolrUtils.getSolrServer();
            QueryResponse queryResponse = httpSolrServer.query(solrQuery);
            return queryResponse;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
