/** 
 * Project Name:iask 
 * File Name:AnswerResult.java 
 * Package Name:com.downjoy.iask.domain 
 * Date:2014年8月8日上午8:49:40 
 * Copyright (c) 2014, jian.yang@downjoy.com All Rights Reserved. 
 * 
 * @author jiang.yang@downjoy.com  
 * @since JDK 1.6 
 */

package com.downjoy.iask.domain;

import java.util.ArrayList;
import java.util.List;


/**
 * ClassName: AnswerResult <br/>
 * decription: 返回的答案实体类. <br/>
 * reason: TODO ADD REASON(可选). <br/>
 * date: 2014年8月8日 上午8:49:40 <br/>
 * 
 */

public class ResponseAnswerResult {

	/**
	 * 问题pv
	 */
	private String qpv;
	/**
	 * 问题ID
	 */
	private String qid;
	/**
	 * 问题标题
	 */
	private String qtitle;
	/**
	 * 问题描述
	 */
	private String qdescription;
	/**
	 * 问题的发布者
	 */
	private String qusername;
	/**
	 * 问题的创建时间
	 */
	private String qcreatetime;
	/**
	 * 回答的内容
	 */
	private List<ResponseAnswer> acontext = new ArrayList<ResponseAnswer>();


	public String getQpv() {
		return qpv;
	}

	public void setQpv(String qpv) {
		this.qpv = qpv;
	}

	public String getQid() {
		return qid;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}

	public String getQtitle() {
		return qtitle;
	}

	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}

	public String getQdescription() {
		return qdescription;
	}

	public void setQdescription(String qdescription) {
		this.qdescription = qdescription;
	}

	public String getQusername() {
		return qusername;
	}

	public void setQusername(String qusername) {
		this.qusername = qusername;
	}

	public String getQcreatetime() {
		return qcreatetime;
	}

	public void setQcreatetime(String qcreatetime) {
		this.qcreatetime = qcreatetime;
	}

	public List<ResponseAnswer> getAcontext() {
		return acontext;
	}

	public void setAcontext(List<ResponseAnswer> acontext) {
		this.acontext = acontext;
	}

	

}
