package com.downjoy.iask.domain;

/**
 * @Description: 游戏详情实体类
 * @author jian.yang@downjoy.com
 * @date 2014年9月1日 下午1:35:05
 * @version 1.0
 */
public class ResponseGameDetail
{
    /**
     * 游戏ID
     */
    private Long gameId;

    /**
     * 游戏名称
     */
    private String gameName;

    /**
     * 游戏Icon
     */

    private String gameIcon;

    /**
     * @Description: 获取游戏Id
     * @return Long 返回类型
     * @throws
     */
    public Long getGameId()
    {
        return gameId;
    }

    /**
     * @Description: 设置游戏Id
     * @param gameId
     *            void 返回类型
     * @throws
     */
    public void setGameId(Long gameId)
    {
        this.gameId = gameId;
    }

    /**
     * @Description: 获取游戏名称
     * @return String 返回类型
     * @throws
     */
    public String getGameName()
    {
        return gameName;
    }

    /**
     * @Description: 设置游戏名称
     * @param gameName
     *            void 返回类型
     * @throws
     */
    public void setGameName(String gameName)
    {
        this.gameName = gameName;
    }

    public String getGameIcon()
    {
        return gameIcon;
    }

    public void setGameIcon(String gameIcon)
    {
        this.gameIcon = gameIcon;
    }

}
