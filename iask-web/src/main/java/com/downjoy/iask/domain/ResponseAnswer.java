/** 
 * Project Name:iask 
 * File Name:ResponseAnswer.java 
 * Package Name:com.downjoy.iask.domain 
 * Date:2014年8月8日上午9:46:52 
 * Copyright (c) 2014, jian.yang@downjoy.com All Rights Reserved. 
 * 
 * @author jiang.yang@downjoy.com  
 * @since JDK 1.6 
 */

package com.downjoy.iask.domain;

/**
 * ClassName: ResponseAnswer <br/>
 * decription: TODO ADD FUNCTION. <br/>
 * reason: TODO ADD REASON(可选). <br/>
 * date: 2014年8月8日 上午9:46:52 <br/>
 * 
 */

public class ResponseAnswer {

	/**
	 * 答案内容
	 */
	private String acontext;

	/**
	 * 最佳标识
	 */
	private boolean abestmark;
	/**
	 * 答案发布者的名称
	 */
	private String ausername;
	/**
	 * 答案发布者的时间
	 */
	private String acreatetime;

	public String getAcontext() {
		return acontext;
	}

	public void setAcontext(String acontext) {
		this.acontext = acontext;
	}

	public boolean isAbestmark() {
		return abestmark;
	}

	public void setAbestmark(boolean abestmark) {
		this.abestmark = abestmark;
	}

	public String getAusername() {
		return ausername;
	}

	public void setAusername(String ausername) {
		this.ausername = ausername;
	}

	public String getAcreatetime() {
		return acreatetime;
	}

	public void setAcreatetime(String acreatetime) {
		this.acreatetime = acreatetime;
	}

	
}
