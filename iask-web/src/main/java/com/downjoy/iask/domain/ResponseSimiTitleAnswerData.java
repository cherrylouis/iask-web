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

public class ResponseSimiTitleAnswerData  {

	/**
	 * 问题的答案
	 */
	private ResponseAnswerResult answerResult;
	/**
	 * 类似的问题
	 */
	private List<ResponseTitleAnswer> similarity = new ArrayList<ResponseTitleAnswer>();

    



	public ResponseAnswerResult getAnswerResult() {
		return answerResult;
	}

	public void setAnswerResult(ResponseAnswerResult answerResult) {
		this.answerResult = answerResult;
	}

	public List<ResponseTitleAnswer> getSimilarity() {
		return similarity;
	}

	public void setSimilarity(List<ResponseTitleAnswer> similarity) {
		this.similarity = similarity;
	}

   

}
