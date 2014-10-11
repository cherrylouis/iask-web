package com.downjoy.iask.domain;

/**
 * 日志model
 */
public class Log {

	private String userId;

	private String logCreateTime;

	private String logSearchKey;

	private String logSearchResultNum;

	private String gameId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLogCreateTime() {
		return logCreateTime;
	}

	public void setLogCreateTime(String logCreateTime) {
		this.logCreateTime = logCreateTime;
	}

	public String getLogSearchKey() {
		return logSearchKey;
	}

	public void setLogSearchKey(String logSearchKey) {
		this.logSearchKey = logSearchKey;
	}

	public String getLogSearchResultNum() {
		return logSearchResultNum;
	}

	public void setLogSearchResultNum(String logSearchResultNum) {
		this.logSearchResultNum = logSearchResultNum;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

}
