package com.downjoy.iask.model;

/**
 * @author lxw
 * solr上answer信息对应的model
 */
public class Answer {
	private String id;
	private String qid;
	private String context;
	private String createtime;
	private long pv;
	private String username;
	private boolean bestmark;

	public String getQid() {
		return qid;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public long getPv() {
		return pv;
	}

	public void setPv(long pv) {
		this.pv = pv;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isBestmark() {
		return bestmark;
	}

	public void setBestmark(boolean bestmark) {
		this.bestmark = bestmark;
	}


}
