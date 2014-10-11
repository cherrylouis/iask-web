package com.downjoy.iask.util;

import java.util.ArrayList;
import java.util.List;
/** 
 * PaginationResult 分页参数类
 * @author jian.yang@downjoy.com
 * @version 1.0 
 */
public class PaginationResult<T> {
	// 当前页
	private int currentPage;
	// 总共记录条数
	private int totalSize;
	// 结果集
	private List<T> resultList = new ArrayList<T>();

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

}
