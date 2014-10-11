package com.downjoy.iask.domain;

/**
 * @Description: 游戏问题的Id
 * @author jian.yang@downjoy.com
 * @date 2014年9月12日 上午10:16:03
 * @version 1.0
 */
public class ResponseGameQuestion
{
    /**
     * 游戏ID
     */
    private String gameId;

    /**
     * 游戏所拥有的问答数量
     */
    private String gameQuestionNum;

    public String getGameId()
    {
        return gameId;
    }

    public void setGameId(String gameId)
    {
        this.gameId = gameId;
    }

    public String getGameQuestionNum()
    {
        return gameQuestionNum;
    }

    public void setGameQuestionNum(String gameQuestionNum)
    {
        this.gameQuestionNum = gameQuestionNum;
    }

}
