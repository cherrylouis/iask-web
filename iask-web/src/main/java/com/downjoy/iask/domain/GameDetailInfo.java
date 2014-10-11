package com.downjoy.iask.domain;

import com.downjoy.iask.domain.basedomain.BaseDoMain;

public class GameDetailInfo extends BaseDoMain
{
    /**
     * 主键
     */
    private Long id;

    /**
     * 游戏名称
     */
    private String gameName;

    /**
     * 游戏名称拼音首字母组合
     */
    private String gameInitCode;

    /**
     * 游戏名称全拼组合
     */
    private String gameAllCode;

    /**
     * 游戏版本号
     */
    private String gameVersion;

    /**
     * 游戏更新时间
     */
    private String gameUpdateTime;

    /**
     * 游戏当前状态
     */
    private String gameStatus;
    
    
    private String gameIcon;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getGameName()
    {
        return gameName;
    }

    public void setGameName(String gameName)
    {
        this.gameName = gameName;
    }

    public String getGameInitCode()
    {
        return gameInitCode;
    }

    public void setGameInitCode(String gameInitCode)
    {
        this.gameInitCode = gameInitCode;
    }

    public String getGameAllCode()
    {
        return gameAllCode;
    }

    public void setGameAllCode(String gameAllCode)
    {
        this.gameAllCode = gameAllCode;
    }

    public String getGameVersion()
    {
        return gameVersion;
    }

    public void setGameVersion(String gameVersion)
    {
        this.gameVersion = gameVersion;
    }

    public String getGameUpdateTime()
    {
        return gameUpdateTime;
    }

    public void setGameUpdateTime(String gameUpdateTime)
    {
        this.gameUpdateTime = gameUpdateTime;
    }

    public String getGameStatus()
    {
        return gameStatus;
    }

    public void setGameStatus(String gameStatus)
    {
        this.gameStatus = gameStatus;
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
