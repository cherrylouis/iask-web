package com.downjoy.iask.domain;

import com.downjoy.iask.domain.basedomain.BaseDoMain;

/**
 * RequestSearch 封装查询参数类
 * 
 * @author jian.yang@downjoy.com
 * @since 0.1
 */
public class RequestSearch extends BaseDoMain {
    /**
     * 问题ID
     */
	private String q_id;
	/**
	 * 标题
	 */
	private String q_title;
	/**
	 * 答案内容
	 */
	private String content;
	/**
	 * 创建时间
	 */
	private String q_createtime;
	


	/**
	 * pv值
	 */
	private String q_pv;

	/**
	 * 关键词
	 */
	private String queryKey;
	/**
	 * 指定输出格式（xml、json、cvs）
	 */
	private String writeType;
	/**
	 * 过滤查询
	 */
	private String filterQuery;
	/**
	 * 返回的字段列表（多个字段用逗号分隔）
	 */
	private String fieldList;
	/**
	 * 默认的查询字段
	 */
	private String defualtSearchFiled;
	/**
	 * 返回结构是否缩进 用 indent=true|on 开启，一般调试json,php,phps,ruby输出才有必要用这个参数
	 */
	private String indent;

	
    
	
	public String getQ_id() {
		return q_id;
	}

	public void setQ_id(String q_id) {
		this.q_id = q_id;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	public String getQ_createtime() {
		return q_createtime;
	}

	public void setQ_createtime(String q_createtime) {
		this.q_createtime = q_createtime;
	}

	public String getQ_pv() {
		return q_pv;
	}

	public void setQ_pv(String q_pv) {
		this.q_pv = q_pv;
	}

	public String getQueryKey() {
		return queryKey;
	}

	public void setQueryKey(String queryKey) {
		this.queryKey = queryKey;
	}

	public String getWriteType() {
		return writeType;
	}

	public void setWriteType(String writeType) {
		this.writeType = writeType;
	}

	public String getFilterQuery() {
		return filterQuery;
	}

	public void setFilterQuery(String filterQuery) {
		this.filterQuery = filterQuery;
	}

	public String getFieldList() {
		return fieldList;
	}

	public void setFieldList(String fieldList) {
		this.fieldList = fieldList;
	}

	public String getDefualtSearchFiled() {
		return defualtSearchFiled;
	}

	public void setDefualtSearchFiled(String defualtSearchFiled) {
		this.defualtSearchFiled = defualtSearchFiled;
	}

	public String getIndent() {
		return indent;
	}

	public void setIndent(String indent) {
		this.indent = indent;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
