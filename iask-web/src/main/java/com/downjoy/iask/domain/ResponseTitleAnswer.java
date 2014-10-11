package com.downjoy.iask.domain;

import com.downjoy.iask.model.Answer;

/**
 * @Description: 问答标题和答案
 * @author jian.yang@downjoy.com
 * @date 2014年9月22日 上午11:14:23
 * @version 1.0
 */
public class ResponseTitleAnswer
{
    /**
     * 问题ID
     */
    private String qid;

    /**
     * 问题标题
     */
    private String qtitle;

    /**
     * 问题创建的时间
     */
    private String qcreatime;

    /**
     * 总的记录数
     */
    private String totalNum;

    /**
     * 答案内容
     */
    private Answer answer;

    public String getQid()
    {
        return qid;
    }

    public void setQid(String qid)
    {
        this.qid = qid;
    }

    public String getQtitle()
    {
        return qtitle;
    }

    public void setQtitle(String qtitle)
    {
        this.qtitle = qtitle;
    }

    public String getQcreatime()
    {
        return qcreatime;
    }

    public void setQcreatime(String qcreatime)
    {
        this.qcreatime = qcreatime;
    }

    public String getTotalNum()
    {
        return totalNum;
    }

    public void setTotalNum(String totalNum)
    {
        this.totalNum = totalNum;
    }

    public Answer getAnswer()
    {
        return answer;
    }

    public void setAnswer(Answer answer)
    {
        this.answer = answer;
    }

}
