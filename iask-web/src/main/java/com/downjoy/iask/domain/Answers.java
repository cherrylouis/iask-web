package com.downjoy.iask.domain;

/**
 * @Description: 问题对应的答案实体
 * @author jian.yang@downjoy.com
 * @date 2014年10月8日 下午5:34:25
 * @version 1.0
 */

public class Answers
{
    /**
     * 问题ID
     */
    private Long id;

    /**
     * 答案的内容
     */
    private String answerContext;

    /**
     * 最佳答案的标识
     */
    private String answerBestMark;

    /**
     * 答案的采纳数量
     */
    private String answerSupportNum;

    /**
     * 答案的采纳数量
     */
    private String answerOppositionNum;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 回答的时间
     */
    private String answerTime;

    /**
     * 问题ID
     */
    private String questionId;

    /**
     * 答案的pv
     */
    private String answerPv;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getAnswerContext()
    {
        return answerContext;
    }

    public void setAnswerContext(String answerContext)
    {
        this.answerContext = answerContext;
    }

    public String getAnswerBestMark()
    {
        return answerBestMark;
    }

    public void setAnswerBestMark(String answerBestMark)
    {
        this.answerBestMark = answerBestMark;
    }

    public String getAnswerSupportNum()
    {
        return answerSupportNum;
    }

    public void setAnswerSupportNum(String answerSupportNum)
    {
        this.answerSupportNum = answerSupportNum;
    }

    public String getAnswerOppositionNum()
    {
        return answerOppositionNum;
    }

    public void setAnswerOppositionNum(String answerOppositionNum)
    {
        this.answerOppositionNum = answerOppositionNum;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getAnswerTime()
    {
        return answerTime;
    }

    public void setAnswerTime(String answerTime)
    {
        this.answerTime = answerTime;
    }

    public String getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(String questionId)
    {
        this.questionId = questionId;
    }

    public String getAnswerPv()
    {
        return answerPv;
    }

    public void setAnswerPv(String answerPv)
    {
        this.answerPv = answerPv;
    }

}
