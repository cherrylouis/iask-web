package com.downjoy.iask.service.baseservice;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.SortClause;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.Group;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SpellCheckResponse;
import org.apache.solr.client.solrj.response.SpellCheckResponse.Collation;
import org.apache.solr.client.solrj.response.SpellCheckResponse.Correction;
import org.apache.solr.client.solrj.response.SpellCheckResponse.Suggestion;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Service;

import com.downjoy.iask.domain.ResponseKeyWord;
import com.downjoy.iask.domain.ResponseSimiResult;
import com.downjoy.iask.domain.ResponseTitleAnswer;
import com.downjoy.iask.model.Answer;
import com.downjoy.iask.model.Question;
import com.downjoy.iask.util.SolrContents;
import com.downjoy.iask.util.SolrUtils;

/**
 * @Description: 连接solr服务器
 * @author jian.yang@downjoy.com
 * @date 2014年8月26日 下午5:36:50
 * @version 1.0
 */
@Service("solrSearchService")
public class SolrSearchService
{

    private static final Logger logger = Logger
            .getLogger(SolrSearchService.class);

    /**
     * solr服务器的地址
     */
    private String url;

    /**
     * solrkeywordUrl服务器的地址
     */
    private String keywordUrl;

    /**
     * solr服务器的连接失效时间
     */
    private Integer soTimeOut;

    /**
     * solr服务器的连接时间
     */
    private Integer connectionTimeOut;

    /**
     * 最大的连接时间
     */
    private Integer maxConnectionsPerHost;

    /**
     * 最大的连接数
     */
    private Integer maxTotalConnections;

    /**
     * 最大的重试次数
     */
    private Integer maxRetries;

    /**
     * 连接服务器类
     */
    private HttpSolrServer solrServer;

    private HttpSolrServer keywordSolrServer;

    /**
     * solr查询类
     */
    private SolrQuery solrQuery;

    /**
     * 初始化参数
     * 
     * @throws MalformedURLException
     */
    public void init() throws MalformedURLException
    {
        solrServer = new HttpSolrServer(url);
        keywordSolrServer = new HttpSolrServer(keywordUrl);
    }

    public SolrSearchService()
    {
        super();
    }
    
	/**
	 * 获取用户的相关问题
	 * 
	 * @param userId
	 *            用户id
	 * @return 用户相关信息
	 */
	public List<ResponseSimiResult> getUserQuestions(String userId) {
		solrQuery.setRequestHandler("/select");
		solrQuery.setStart(0);
		solrQuery.setRows(10);
		solrQuery.setParam("q_user_id", userId);
		QueryResponse qrsp;
		try {
			qrsp = solrServer.query(solrQuery);
			SolrDocumentList docs = qrsp.getResults();
			List<ResponseSimiResult> list = new ArrayList<ResponseSimiResult>();
			if (docs != null && !docs.isEmpty()) {
				ResponseSimiResult simiresult = null;
				for (SolrDocument sordocument : docs) {
					simiresult = new ResponseSimiResult();
					String q_id = String.valueOf(sordocument
							.getFieldValue("q_id"));
					String q_title = String.valueOf(sordocument
							.getFieldValue("q_title"));
					String q_createtime = String.valueOf(sordocument
							.getFieldValue("q_createtime"));
					simiresult.setQid(q_id);
					simiresult.setQtitle(q_title);
					simiresult.setQcreatime(q_createtime);
					list.add(simiresult);
				}

			}
			return list;
		} catch (SolrServerException e) {
			logger.error("查询相关的问题出现错: " + e.getMessage());
		}
		return null;
	}


    /**
     * @Description: 获取类似标题
     * @param questionId
     *            问题ID
     * @param gameId
     *            游戏ID
     * @return List<ResponseSimiResult> 返回类型标题结果
     * @throws
     */

    public List<ResponseSimiResult> getSimilarityService(String gameId,
            String questionId)
    {
        solrQuery.setRequestHandler("/mlt");
        solrQuery.setStart(0);
        solrQuery.setRows(15);
        solrQuery.setParam("q", "q_id:" + questionId);
        solrQuery.setParam("mlt", "true");
        solrQuery.setParam("mlt.fl", "q_title");
        solrQuery.setParam("mlt.mintf", "1");
        solrQuery.setParam("mlt.mindf", "1");
        QueryResponse qrsp;
        try
        {
            qrsp = solrServer.query(solrQuery);
            SolrDocumentList docs = qrsp.getResults();
            List<ResponseSimiResult> list = new ArrayList<ResponseSimiResult>();
            if (docs != null && !docs.isEmpty())
            {
                ResponseSimiResult simiresult = null;
                for (SolrDocument sordocument : docs)
                {
                    String q_gameId = String.valueOf(sordocument
                            .getFieldValue("q_gameid"));
                    if (!q_gameId.equals(gameId))
                    {
                        continue;
                    }
                    String q_id = String.valueOf(sordocument
                            .getFieldValue("q_id"));
                    String q_title = String.valueOf(sordocument
                            .getFieldValue("q_title"));
                    String q_createtime = String.valueOf(sordocument
                            .getFieldValue("q_createtime"));
                    simiresult = new ResponseSimiResult();
                    simiresult.setQid(q_id);
                    simiresult.setQtitle(q_title);
                    simiresult.setQcreatime(q_createtime);
                    list.add(simiresult);
                }

            }
            return list;
        }
        catch(SolrServerException e)
        {
            logger.error("查询相关的问题出现错: " + e.getMessage());
        }
        return null;

    }

    /**
     * @Description: 提供给前端自动填充数据的业务方法
     * @param gameId
     *            游戏ID
     * @param querykeyWord
     *            输入的关键字
     * @return List<String> 返回关键词
     * @throws SolrServerException
     *             solr服务器异常
     */
    public List<String> getKeywordRelationTip(String gameId, String querykeyWord)
            throws SolrServerException
    {
        solrQuery.setParam("qt", "/suggest");
        solrQuery.setParam("q", querykeyWord);
        solrQuery.setParam("spellcheck.build", "true");
        solrQuery.setParam("spellcheck.count", "10");
        solrQuery.setParam("spellcheck.collate", "true");
        QueryResponse response = keywordSolrServer.query(solrQuery);
        SpellCheckResponse spellCheckResponse = response
                .getSpellCheckResponse();
        List<String> suggestedWordList = null;
        if (spellCheckResponse != null)
        {
            List<Suggestion> suggestionList = spellCheckResponse
                    .getSuggestions();
            if (suggestionList != null && !suggestionList.isEmpty())
            {
                List<String> tempList = null;
                suggestedWordList = new ArrayList<String>();
                for (Suggestion suggestion : suggestionList)
                {
                    System.out.println("Suggestions NumFound: "
                            + suggestion.getNumFound());
                    System.out.println("Token: " + suggestion.getToken());
                    System.out.print("Suggested: ");
                    tempList = suggestion.getAlternatives();
                    if (tempList != null)
                    {
                        for (String str : tempList)
                        {
                            if (str.indexOf("|") != -1)
                            {
                                String tempstr = str
                                        .substring(str.indexOf("|") + 1);
                                suggestedWordList.add(tempstr);
                            }
                            else
                            {
                                suggestedWordList.add(str);
                            }
                        }
                    }
                    for (String word : tempList)
                    {
                        System.out.println(word + ", ");
                    }
                    System.out.println();
                }
            }
        }
        return suggestedWordList;
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
    public List<String> getSimilarityKeyWord(String gameId, String keyWord)
    {
        // solrQuery.setRequestHandler("/select");
        solrQuery.setQuery("r_gameid:" + gameId);
        solrQuery.setParam("main_keyword", keyWord);
        solrQuery.setParam("mlt", "true");
        solrQuery.setParam("mlt.fl", "suggest_word");
        solrQuery.setParam("mlt.mintf", "1");
        solrQuery.setParam("mlt.mindf", "1");
        solrQuery.setParam("mlt.count", "10");
        QueryResponse qrsp;
        List<String> list = new ArrayList<String>();
        try
        {
            qrsp = keywordSolrServer.query(solrQuery);
            SolrDocumentList docs = qrsp.getResults();
            Set<String> set = new HashSet<String>();

            if (docs != null && !docs.isEmpty())
            {
                for (SolrDocument sordocument : docs)
                {
                    String q_keyWord = String.valueOf(sordocument
                            .getFieldValue("suggest_word"));

                    set.add(q_keyWord);
                }

            }
            list.addAll(set);
        }
        catch(SolrServerException e)
        {
            logger.error("类似关键词抛出异常: " + e.getMessage());
        }
        return list;
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
    public List<String> getAutoCorrectKeyWord(String gameId, String keyWord)
            throws SolrServerException
    {
        List<String> retrunList = null;
        solrQuery.setRequestHandler("/spell");
        solrQuery.setQuery(keyWord);
        if (gameId != null && !"".equals(gameId))
        {
            solrQuery.setParam(SolrContents.Index_Fields.Q_GAMEID, gameId);
        }
        solrQuery.setStart(0);
        solrQuery.setRows(10);
        solrQuery.setParam("spellcheck.build", "true");
        solrQuery.setParam("spellcheck.collate", "true");
        solrQuery.setParam("spellcheck.check", "true");
        solrQuery.setParam("spellcheck", "true");

        QueryResponse queryResponse = keywordSolrServer.query(solrQuery);
        if (queryResponse != null)
        {
            SpellCheckResponse spellCheckResponse = queryResponse
                    .getSpellCheckResponse();
            if (spellCheckResponse != null)
            {
                List<Collation> collationList = spellCheckResponse
                        .getCollatedResults();
                if (collationList != null && !collationList.isEmpty())
                {
                    retrunList = new ArrayList<String>();
                    for (Collation collation : collationList)
                    {
                        List<Correction> correctionList = collation
                                .getMisspellingsAndCorrections();
                        if (correctionList != null && !correctionList.isEmpty())
                        {
                            for (Correction correction : correctionList)
                            {
                                System.out.println("correction==="
                                        + correction.getCorrection());
                                System.out.println("Original==="
                                        + correction.getOriginal());
                            }
                        }
                        retrunList.add(collation.getCollationQueryString());
                    }
                }
            }
        }
        return retrunList;
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
    public List<ResponseKeyWord> searchKeyWord(String gameId,
            Boolean isSortByHighFrequency) throws SolrServerException
    {

        List<ResponseKeyWord> responseKeyWordList = null;
        if (gameId != null && !"".equals(gameId))
        {
            solrQuery.setParam("q", "r_gameid:" + gameId);
        }
        else
        {
            solrQuery.setParam("q", "*:*");
        }
        if (isSortByHighFrequency)
        {
            solrQuery.setSort(SortClause.desc("r_quency"));
        }
        QueryResponse queryResponse = keywordSolrServer.query(solrQuery);
        if (queryResponse != null)
        {
            SolrDocumentList solrDocumentList = queryResponse.getResults();
            responseKeyWordList = SolrUtils
                    .solrDocumentListToResponseKeyWord(solrDocumentList);
        }
        return responseKeyWordList;
    }

    /**
     * @Description: 多游戏搜索，进行分组
     * @param keyWord
     *            关键词
     * @return Map<String,Long> 返回类型
     * @throws SolrServerException
     */
    public List<Question> searchKeyWordBygroup(String gameId, String keyWord)
            throws SolrServerException
    {
        List<Question> listquestion = new ArrayList<Question>();
        StringBuffer sb = new StringBuffer();
        sb.append(SolrContents.Index_Fields.Q_TITLE)
                .append(SolrContents.DOUBLE_MARKS).append(keyWord);

        if (gameId != null && !"".equals(gameId))
        {
            solrQuery.setParam("q_gameid", gameId);
        }
        else
        {
            solrQuery.setParam("q_gameid", "*");
        }
        solrQuery.setQuery(sb.toString());

        solrQuery.setParam("group", true);// 是否分组

        solrQuery.setParam("group.field", "q_gameid");// 分组的域（此处以游戏id进行分组）

        // solrQuery.setParam("group.query",
        // "price:[0 TO 100]");//还可以根据其他条件进行过滤，如价格在1到100之间

        solrQuery.setParam("group.limit", String.valueOf(Integer.MAX_VALUE));// 每组显示的个数，默认为1

        solrQuery.setParam("group.ngroups", true);// 是否计算所得分组个数；注意：当每个分组显示数目大于1个时，不能用分组数量来计算总页码

        solrQuery.setStart(0); // 起始索引值

        solrQuery.setRows(Integer.MAX_VALUE);// 显示几条数据

        QueryResponse resp = solrServer.query(solrQuery);
        GroupResponse gresp = resp.getGroupResponse();// 注意：此处不能再用resp.getResults()接收结果
        List<GroupCommand> commands = gresp.getValues();

        if (commands != null)
        {
            for (GroupCommand com : commands)
            {

                System.out.println("总的分组个数：" + com.getNGroups().longValue());

                for (Group group : com.getValues())
                {

                    SolrDocumentList hits = group.getResult();
                    System.out.println("*******" + group.getGroupValue());
                    for (SolrDocument doc : hits)
                    {

                        Question question = SolrUtils
                                .solrDocumentToQuestion(doc);
                        listquestion.add(question);
                    }

                }

            }
        }

        return listquestion;
    }

    /**
     * @Description: 标题和答案
     * @param gameId
     * @param questionId 问题ID
     * @param flag 是否按时间排序
     * @return 设定文件
     * @return List<ResponseTitleAnswer> 返回类型
     * @throws
     */
    @SuppressWarnings("unchecked")
    public List<ResponseTitleAnswer> getSimilarityTitleAnswer(String gameId,
            String questionId,String flag)
    {
        solrQuery = new SolrQuery();
        solrQuery.setRequestHandler("/mlt");
        solrQuery.setStart(0);
        solrQuery.setRows(15);
        solrQuery.setParam("q", "q_id:" + questionId);
        solrQuery.setParam("mlt", "true");
        solrQuery.setParam("mlt.fl", "q_title");
        solrQuery.setParam("mlt.mintf", "1");
        solrQuery.setParam("mlt.mindf", "1");
        if(flag !=null && !"".equals(flag)){
            
            solrQuery.setSort(SortClause.desc(SolrContents.Index_Fields.Q_CREATETIME));
        }else {
            
            solrQuery.setSort(SortClause.desc(SolrContents.Index_Fields.Q_PV));
        }
        QueryResponse qrsp;
        try
        {
            qrsp = solrServer.query(solrQuery);
            SolrDocumentList docs = qrsp.getResults();
            List<ResponseTitleAnswer> list = new ArrayList<ResponseTitleAnswer>();
            if (docs != null && !docs.isEmpty())
            {
                ResponseTitleAnswer simiresult = null;
                for (SolrDocument sordocument : docs)
                {
                    simiresult = new ResponseTitleAnswer();
                    String q_gameId = String.valueOf(sordocument
                            .getFieldValue("q_gameid"));
                    if (!q_gameId.equals(gameId))
                    {
                        continue;
                    }
                    String q_id = String.valueOf(sordocument
                            .getFieldValue("q_id"));
                    String q_title = String.valueOf(sordocument
                            .getFieldValue("q_title"));
                    String q_createtime = String.valueOf(sordocument
                            .getFieldValue("q_createtime"));

                    List<String> answerIdList = ((List<String>) sordocument
                            .getFieldValue("a_id"));
                    List<String> answerContextList = ((List<String>) sordocument
                            .getFieldValue("a_context"));
                    List<String> answerUsernameList = ((List<String>) sordocument
                            .getFieldValue("a_username"));
                    List<Long> answerPvList = ((List<Long>) sordocument
                            .getFieldValue("a_pv"));
                    List<Date> answerTimeList = (List<Date>) sordocument
                            .getFieldValue("a_createtime");
                    List<Long> answerBestmarkList = ((List<Long>) sordocument
                            .getFieldValue("a_bestmark"));
                    if (answerContextList != null
                            && !answerContextList.isEmpty())
                    {
                        SimpleDateFormat dateFormat = new SimpleDateFormat(
                                "yyyy-MM-dd hh:mm:ss");
                        for (int j = 0; j < answerContextList.size(); j++)
                        {
                            if (answerBestmarkList != null
                                    && answerBestmarkList.get(j) > 0)
                            {
                                Answer answer = new Answer();
                                if (answerIdList != null)
                                {
                                    answer.setId(answerIdList.get(j));
                                }
                                if (answerContextList != null)
                                {
                                    answer.setContext(answerContextList.get(j));
                                }
                                if (answerPvList != null)
                                {
                                    answer.setPv(answerPvList.get(j));
                                }
                                if (answerTimeList != null)
                                {
                                    answer.setCreatetime(dateFormat
                                            .format(answerTimeList.get(j)));
                                }
                                if (answerUsernameList != null)
                                {
                                    answer.setUsername(answerUsernameList
                                            .get(j));
                                }
                                if (answerBestmarkList != null)
                                {
                                    answer.setBestmark(answerBestmarkList
                                            .get(j) > 0);
                                }
                                simiresult.setAnswer(answer);
                                break;
                            }
                        }
                    }
                    simiresult.setQid(q_id);
                    simiresult.setQtitle(q_title);
                    simiresult.setQcreatime(q_createtime);
                    list.add(simiresult);
                }

            }
            return list;
        }
        catch(SolrServerException e)
        {
            logger.error("查询相关的问题出现错: " + e.getMessage());
        }
        return null;

    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getKeywordUrl()
    {
        return keywordUrl;
    }

    public void setKeywordUrl(String keywordUrl)
    {
        this.keywordUrl = keywordUrl;
    }

    public Integer getSoTimeOut()
    {
        return soTimeOut;
    }

    public void setSoTimeOut(Integer soTimeOut)
    {
        this.soTimeOut = soTimeOut;
    }

    public Integer getConnectionTimeOut()
    {
        return connectionTimeOut;
    }

    public void setConnectionTimeOut(Integer connectionTimeOut)
    {
        this.connectionTimeOut = connectionTimeOut;
    }

    public Integer getMaxConnectionsPerHost()
    {
        return maxConnectionsPerHost;
    }

    public void setMaxConnectionsPerHost(Integer maxConnectionsPerHost)
    {
        this.maxConnectionsPerHost = maxConnectionsPerHost;
    }

    public Integer getMaxTotalConnections()
    {
        return maxTotalConnections;
    }

    public void setMaxTotalConnections(Integer maxTotalConnections)
    {
        this.maxTotalConnections = maxTotalConnections;
    }

    public Integer getMaxRetries()
    {
        return maxRetries;
    }

    public void setMaxRetries(Integer maxRetries)
    {
        this.maxRetries = maxRetries;
    }

    public HttpSolrServer getSolrServer()
    {
        return solrServer;
    }

    public void setSolrServer(HttpSolrServer solrServer)
    {
        this.solrServer = solrServer;
    }

    public SolrQuery getSolrQuery()
    {
        return solrQuery;
    }

    public void setSolrQuery(SolrQuery solrQuery)
    {
        this.solrQuery = solrQuery;
    }
}
