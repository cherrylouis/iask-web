package com.downjoy.push.domain;

import java.io.Serializable;

/**
 * @Description: 问答数据
 * @author jian.yang@downjoy.com
 * @date 2014年10月9日 下午2:36:25
 * @version 1.0
 */
public class PushMessageData implements Serializable
{

    private static final long serialVersionUID = 3479535161464399610L;

    private String senderId;

    private String receiverId;

    private String context;

    private String questionRewardPoints;

    private String gameId;

    private String questionId;

    /**
     * 区分提问，还是答案（1=代表提问, 2=代表答案）
     */
    private String pushType;

    /**
     * 区分推送的对象（1,特定的用户 2,所有的用户）
     */
    private String pushUserType;

    public String getPushUserType()
    {
        return pushUserType;
    }

    public void setPushUserType(String pushUserType)
    {
        this.pushUserType = pushUserType;
    }

    public String getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(String questionId)
    {
        this.questionId = questionId;
    }

    public String getGameId()
    {
        return gameId;
    }

    public void setGameId(String gameId)
    {
        this.gameId = gameId;
    }

    public String getSenderId()
    {
        return senderId;
    }

    public void setSenderId(String senderId)
    {
        this.senderId = senderId;
    }

    public String getReceiverId()
    {
        return receiverId;
    }

    public void setReceiverId(String receiverId)
    {
        this.receiverId = receiverId;
    }

    public String getContext()
    {
        return context;
    }

    public void setContext(String context)
    {
        this.context = context;
    }

    public String getQuestionRewardPoints()
    {
        return questionRewardPoints;
    }

    public void setQuestionRewardPoints(String questionRewardPoints)
    {
        this.questionRewardPoints = questionRewardPoints;
    }

    public String getPushType()
    {
        return pushType;
    }

    public void setPushType(String pushType)
    {
        this.pushType = pushType;
    }

}
