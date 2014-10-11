/** 
 * Project Name:iask 
 * File Name:ResponseData.java 
 * Package Name:com.downjoy.iask.domain 
 * Date:2014年8月8日上午8:46:21 
 * Copyright (c) 2014, jian.yang@downjoy.com All Rights Reserved. 
 * 
 * @author jiang.yang@downjoy.com  
 * @since JDK 1.6 
 */

package com.downjoy.iask.domain;

import java.util.ArrayList;
import java.util.List;


/**
 * ClassName: ResponseData <br/>
 * decription: 返回数据的实体类 <br/>
 * reason: TODO ADD REASON(可选). <br/>
 * date: 2014年8月8日 上午8:46:21 <br/>
 * 
 */

public class ResponseData  {

	/**
	 * 问题的答案
	 */
	private ResponseAnswerResult answerResult;
	/**
	 * 类似的问题
	 */
	private List<ResponseSimiResult> similarity = new ArrayList<ResponseSimiResult>();

    



	public ResponseAnswerResult getAnswerResult() {
		return answerResult;
	}

	public void setAnswerResult(ResponseAnswerResult answerResult) {
		this.answerResult = answerResult;
	}

	public List<ResponseSimiResult> getSimilarity() {
		return similarity;
	}

	public void setSimilarity(List<ResponseSimiResult> similarity) {
		this.similarity = similarity;
	}

   

}
