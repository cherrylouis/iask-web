package com.downjoy.iask.model;

import java.util.List;

/**
 * @author lxw
 *
 * @param <T>
 * 
 * 系统通用分页model
 */
public class Page<T> {
	// 当前第几页
	private int pageNum;
	// 每页显示多少条记录
	private int pageSize = 10;
	// 共有多少条记录
	private long totalItemNumber;
	// 当前页的 List
	private List<T> list;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalItemNumber() {
		return totalItemNumber;
	}

	public void setTotalItemNumber(long totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
