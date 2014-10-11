package com.downjoy.iask.domain;

import com.downjoy.iask.domain.basedomain.BaseDoMain;

/**
 * 举报信息实体
 * 
 * @author Administrator
 */
public class Inform extends BaseDoMain {

	private long id;

	private long questionId;// 问题Id

	private long userId; // 用户ID

	private String informUrl; // 举报地址

	private String informContent;// 举报内容

	private String informType; // 举报类型

	private int informNum; // 举报数目

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getInformUrl() {
		return informUrl;
	}

	public void setInformUrl(String informUrl) {
		this.informUrl = informUrl;
	}

	public String getInformContent() {
		return informContent;
	}

	public void setInformContent(String informContent) {
		this.informContent = informContent;
	}

	public String getInformType() {
		return informType;
	}

	public void setInformType(String informType) {
		this.informType = informType;
	}

	public int getInformNum() {
		return informNum;
	}

	public void setInformNum(int informNum) {
		this.informNum = informNum;
	}

	@Override
	public String toString() {
		return "Inform [id=" + id + ", userId=" + userId + ", informUrl="
				+ informUrl + ", informContent=" + informContent
				+ ", informType=" + informType + ", informNum=" + informNum
				+ "]";
	}

}
