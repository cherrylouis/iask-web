/** 
 * Project Name:iask 
 * File Name:Similarity.java 
 * Package Name:com.downjoy.iask.domain 
 * Date:2014年8月8日上午8:51:40 
 * Copyright (c) 2014, jian.yang@downjoy.com All Rights Reserved. 
 * 
 * @author jiang.yang@downjoy.com  
 * @since JDK 1.6 
 */

package com.downjoy.iask.domain;


/**
 * ClassName: Similarity <br/>
 * decription: 相似的问题实体类. <br/>
 * reason: TODO ADD REASON(可选). <br/>
 * date: 2014年8月8日 上午8:51:40 <br/>
 * 
 */

public class ResponseSimiResult {
	/**
	 * 问题ID
	 */
	private String qid;
	/**
	 * 问题标题
	 */
	private String qtitle;
	/**
	 * 问题创建的时间
	 */
	private String qcreatime;
	/**
	 * 总的记录数
	 */
	private String totalNum;

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

	public String getQcreatime() {
		return qcreatime;
	}

	public void setQcreatime(String qcreatime) {
		this.qcreatime = qcreatime;
	}

	public String getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}
    
}
