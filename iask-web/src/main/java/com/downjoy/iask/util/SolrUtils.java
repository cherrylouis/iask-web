package com.downjoy.iask.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.util.DateUtil;

import com.downjoy.iask.domain.ResponseKeyWord;
import com.downjoy.iask.model.Answer;
import com.downjoy.iask.model.Question;

/**
 * @Description: solr的document对象与实体对象的转换工具类
 * @author jian.yang@downjoy.com
 * @date 2014年9月3日 上午10:19:31
 * @version 1.0
 */
public class SolrUtils
{

    /**
     * 日志对象
     */
    private static final Logger logger = Logger.getLogger(SolrUtils.class);

    /**
     * 获取solr服务器的地址
     */
    private static String url = IAskConfig.getInstance().getIaskSolrUrl();

    /**
     * 请求solr服务器的对象
     */
    private static HttpSolrServer solrServer;

    /**
     * 日期格式对象
     */
    private static SimpleDateFormat dateFormat;

    static
    {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    private SolrUtils()
    {
    }

    /**
     * @Description: 获取单列对象
     * @return HttpSolrServer 返回类型
     * @throws
     */
    public static HttpSolrServer getSolrServer()
    {
        if (solrServer == null)
        {
            synchronized (SolrUtils.class)
            {
                if (solrServer == null)
                {
                    solrServer = new HttpSolrServer(url);
                }
            }
        }
        return solrServer;
    }

    /**
     * 转换从solr获取到的document到Question对象
     * 
     * @param sors
     *            solr返回的文档列表
     * @param highlightingMap
     *            solr返回的高亮词对应列表
     * @param flag
     *            是否需要获取高亮词
     * @param isBak
     *            是不是读取q_title_bak，这个字段和q_title匹配模式不一样
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<Question> docToQuestions(SolrDocumentList sors,
            Map<String, Map<String, List<String>>> highlightingMap,
            boolean flag, boolean isBak)
    {
        List<Question> qList = new ArrayList<Question>();
        if (sors != null && !sors.isEmpty())
        {

            for (int i = 0; i < sors.size(); i++)
            {
                SolrDocument doc = sors.get(i);
                Question question = new Question();

                String q_id = String.valueOf(doc.getFieldValue("q_id"));
                long q_pv = 0;

                q_pv = Long
                        .parseLong(String.valueOf(doc.getFieldValue("q_pv")));

                String q_title = getHighlightingString(doc, highlightingMap,
                        q_id, SolrContents.Index_Fields.Q_TITLE, flag);

                String q_title_bak = getHighlightingString(doc,
                        highlightingMap, q_id,
                        SolrContents.Index_Fields.Q_TITLE_BAK, flag);

                String q_description = String.valueOf(doc
                        .getFieldValue("q_description"));
                String q_username = String.valueOf(doc
                        .getFieldValue("q_username"));
                String q_createtime = String.valueOf(doc
                        .getFieldValue("q_createtime"));
                List<String> answerIdList = ((List<String>) doc
                        .getFieldValue("a_id"));
                List<String> answerContextList = ((List<String>) doc
                        .getFieldValue("a_context"));
                List<String> answerUsernameList = ((List<String>) doc
                        .getFieldValue("a_username"));
                List<Long> answerPvList = ((List<Long>) doc
                        .getFieldValue("a_pv"));
                List<Date> answerTimeList = (List<Date>) doc
                        .getFieldValue("a_createtime");
                List<Long> answerBestmarkList = ((List<Long>) doc
                        .getFieldValue("a_bestmark"));

                List<Answer> answers = new ArrayList<Answer>();
                Answer answer = null;
                if (answerContextList != null && answerContextList.size() > 0)
                {
                    for (int j = 0; j < answerContextList.size(); j++)
                    {
                        answer = new Answer();
                        answer.setId(answerIdList.get(j));
                        answer.setContext(answerContextList.get(j));
                        if (answerPvList != null)
                        {
                            answer.setPv(answerPvList.get(j));
                        }
                        if (answerTimeList != null
                                && answerTimeList.get(j) != null)
                        {
                            answer.setCreatetime(dateFormat
                                    .format(answerTimeList.get(j)));
                        }
                        if (answerUsernameList != null)
                        {
                            answer.setUsername(answerUsernameList.get(j));
                        }
                        answer.setBestmark(answerBestmarkList.get(j) > 0);
                        answers.add(answer);
                    }
                }

                question.setId(q_id);
                if (isBak)
                {
                    question.setTitle(q_title_bak);
                }
                else
                {
                    question.setTitle(q_title);
                }
                question.setDescription(q_description);
                question.setPv(q_pv);
                question.setUsername(q_username);
                question.setAnswers(answers);
                try
                {
                    question.setCreatetime(dateFormat.format(DateUtil
                            .parseDate(q_createtime)));
                }
                catch(ParseException e)
                {
                    logger.info("转换对象出错! " + e.getMessage());
                    question.setCreatetime(dateFormat.format(new Date()));
                }
                qList.add(question);
            }
        }
        return qList;
    }

    /**
     * @Description: 转换从solr获取到的document到Question对象
     * @param sors
     *            solr查询的document对象
     * @return Question 返回类型
     * @throws
     */
    public static Question docToQuestion(SolrDocumentList sors)
    {
        if (sors != null && sors.size() > 0)
        {
            SolrDocument doc = sors.get(0);
            return solrDocumentToQuestion(doc);
        }
        return null;
    }

    /**
     * @Description: 转换从solr获取到的document到Question对象
     * @param doc
     *            document 对象
     * @return Question 返回类型
     * @throws
     */
    @SuppressWarnings("unchecked")
    public static Question solrDocumentToQuestion(SolrDocument doc)
    {
        Question question = new Question();
        String q_id = String.valueOf(doc.getFieldValue("q_id"));
        long q_pv = 0;
        try
        {
            q_pv = Long.parseLong(String.valueOf(doc.getFieldValue("q_pv")));
        }
        catch(RuntimeException e)
        {

        }

        String q_title = String.valueOf(doc
                .getFieldValue(SolrContents.Index_Fields.Q_TITLE));

        String q_description = String.valueOf(doc
                .getFieldValue("q_description"));
        String q_username = String.valueOf(doc.getFieldValue("q_username"));
        String q_createtime = String.valueOf(doc.getFieldValue("q_createtime"));
        List<String> answerIdList = ((List<String>) doc.getFieldValue("a_id"));
        List<String> answerContextList = ((List<String>) doc
                .getFieldValue("a_context"));
        List<String> answerUsernameList = ((List<String>) doc
                .getFieldValue("a_username"));
        List<Long> answerPvList = ((List<Long>) doc.getFieldValue("a_pv"));
        List<Date> answerTimeList = (List<Date>) doc
                .getFieldValue("a_createtime");
        List<Long> answerBestmarkList = ((List<Long>) doc
                .getFieldValue("a_bestmark"));

        List<Answer> answers = new ArrayList<Answer>();
        Answer answer = null;
        if (answerContextList != null && answerContextList.size() > 0)
        {
            for (int j = 0; j < answerContextList.size(); j++)
            {
                answer = new Answer();
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
                    answer.setCreatetime(dateFormat.format(answerTimeList
                            .get(j)));
                }
                if (answerUsernameList != null)
                {
                    answer.setUsername(answerUsernameList.get(j));
                }
                if (answerBestmarkList != null)
                {
                    answer.setBestmark(answerBestmarkList.get(j) > 0);
                }
                answers.add(answer);
            }
        }

        question.setId(q_id);
        question.setTitle(q_title);
        question.setDescription(q_description);
        question.setPv(q_pv);
        question.setUsername(q_username);
        question.setAnswers(answers);
        try
        {
            question.setCreatetime(dateFormat.format(DateUtil
                    .parseDate(q_createtime)));
        }
        catch(ParseException e)
        {
            logger.info("转换对象出错!" + e.getMessage());
            question.setCreatetime("1900-01-01 00:00:00");
        }

        return question;
    }

    /**
     * @Description: 获取高亮词辅助函数
     * @param doc
     *            solr查询的document对象
     * @param highlightingMap
     *            存储高亮字段的map
     * @param id
     *            key
     * @param field
     *            key
     * @param flag
     *            标识
     * @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public static String getHighlightingString(SolrDocument doc,
            Map<String, Map<String, List<String>>> highlightingMap, String id,
            String field, boolean flag)
    {
        String str = "";
        if (flag)
        {
            try
            {
                List<String> list = null;
                list = highlightingMap.get(id).get(field);
                if (list != null && list.size() > 0)
                {
                    str = list.get(0);
                }
                else
                {
                    str = String.valueOf(doc.getFieldValue(field));
                }
            }
            catch(RuntimeException e)
            {
                logger.info("设置字段高亮出现错误:" + e.getMessage());
                str = String.valueOf(doc.getFieldValue(field));
            }
        }
        else
        {
            str = String.valueOf(doc.getFieldValue(field));
        }
        return str;
    }

    /**
     * @Description: 查询后的solrdocument对象转换为关键词对象
     * @param solrDocumentList
     *            solr的document对象
     * @return ResponseKeyWord 返回类型
     * @throws
     */
    public static List<ResponseKeyWord> solrDocumentListToResponseKeyWord(
            SolrDocumentList solrDocumentList)
    {
        List<ResponseKeyWord> responseKeyWordList = null;
        Set<ResponseKeyWord> responseKeyWordSet = null;
        if (solrDocumentList != null && !solrDocumentList.isEmpty())
        {
            responseKeyWordList = new ArrayList<ResponseKeyWord>();
            responseKeyWordSet = new HashSet<ResponseKeyWord>();
            for (SolrDocument solrDocument : solrDocumentList)
            {
                String maikeyWordId = String.valueOf(solrDocument
                        .getFieldValue(SolrContents.Index_Fields.R_KEYWORDID));
                String mainKeyWord = String.valueOf(solrDocument
                        .getFieldValue(SolrContents.Index_Fields.SUGGEST_WORD));
                String frequency = String.valueOf(solrDocument
                        .getFieldValue(SolrContents.Index_Fields.R_QUENCY));
                ResponseKeyWord responseKeyWord = new ResponseKeyWord();
                responseKeyWord.setKeyWordId(maikeyWordId);
                responseKeyWord.setKeyWord(mainKeyWord);
                responseKeyWord.setFrequency(frequency);
                responseKeyWordSet.add(responseKeyWord);

            }

            responseKeyWordList.addAll(responseKeyWordSet);
        }
        return responseKeyWordList;
    }

}
