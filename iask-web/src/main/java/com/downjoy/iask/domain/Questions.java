

package com.downjoy.iask.domain;

/**
 *Questions  问题实体类 
 * 
 * @author jian.yang@downjoy.com
 * @version 1.0
 */
public class Questions {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 问题标题
	 */
	private String questionTitle;
	/**
	 * 游戏ID
	 */
	private Long gameId;
	/**
	 * 问题描述
	 */
	private String questionDescription;
	/**
	 * 问题创建时间
	 */
	private String questionCreateTime;
	/**
	 * 问题状态
	 */
	private String questionStatus;
	/**
	 * 问题的悬赏积分
	 */
	private String questionRewardPoints;
	/**
	 * 问题图片数量
	 */
	private String questionPicNum;
	/**
	 * 问题pv
	 */
	private String questionPV;
	/**
	 * 问题答案数量
	 */
	private String questionAnswNum;
	/**
	 * 问题回答限制
	 */
	private String questionAnswLimit;
	/**
	 * 问题的浏览数量
	 */
	private String questionBrowseNum;
	/**
	 * 问题的来源
	 */
	private String questionSource;
	/**
	 * 问题的地址
	 */
	private String questionSite;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public String getQuestionCreateTime() {
		return questionCreateTime;
	}

	public void setQuestionCreateTime(String questionCreateTime) {
		this.questionCreateTime = questionCreateTime;
	}

	public String getQuestionStatus() {
		return questionStatus;
	}

	public void setQuestionStatus(String questionStatus) {
		this.questionStatus = questionStatus;
	}

	public String getQuestionRewardPoints() {
		return questionRewardPoints;
	}

	public void setQuestionRewardPoints(String questionRewardPoints) {
		this.questionRewardPoints = questionRewardPoints;
	}

	public String getQuestionPicNum() {
		return questionPicNum;
	}

	public void setQuestionPicNum(String questionPicNum) {
		this.questionPicNum = questionPicNum;
	}

	public String getQuestionPV() {
		return questionPV;
	}

	public void setQuestionPV(String questionPV) {
		this.questionPV = questionPV;
	}

	public String getQuestionAnswNum() {
		return questionAnswNum;
	}

	public void setQuestionAnswNum(String questionAnswNum) {
		this.questionAnswNum = questionAnswNum;
	}

	public String getQuestionAnswLimit() {
		return questionAnswLimit;
	}

	public void setQuestionAnswLimit(String questionAnswLimit) {
		this.questionAnswLimit = questionAnswLimit;
	}

	public String getQuestionBrowseNum() {
		return questionBrowseNum;
	}

	public void setQuestionBrowseNum(String questionBrowseNum) {
		this.questionBrowseNum = questionBrowseNum;
	}

	public String getQuestionSource() {
		return questionSource;
	}

	public void setQuestionSource(String questionSource) {
		this.questionSource = questionSource;
	}

	public String getQuestionSite() {
		return questionSite;
	}

	public void setQuestionSite(String questionSite) {
		this.questionSite = questionSite;
	}

}
