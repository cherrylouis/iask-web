package com.downjoy.iask.domain;

/**
 * @Description: 问题是否被采纳的实体类
 * @author jian.yang@downjoy.com
 * @date 2014年10月8日 下午1:47:06
 * @version 1.0
 */
public class RequestAdopt
{
    private Boolean questionId = false;

    private Boolean createTime = false;

    private Boolean questionRewardPoints = false;

    public Boolean getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Boolean createTime)
    {
        this.createTime = createTime;
    }

    public Boolean getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(Boolean questionId)
    {
        this.questionId = questionId;
    }

    public Boolean getQuestionRewardPoints()
    {
        return questionRewardPoints;
    }

    public void setQuestionRewardPoints(Boolean questionRewardPoints)
    {
        this.questionRewardPoints = questionRewardPoints;
    }

}
