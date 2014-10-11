package com.downjoy.iask.model;

import java.util.List;

/**
 * @author lxw
 * solr上question信息对应的model
 */
public class Question {
	private String id;
	private String title;
//	private String title_bak;
	private String description;
	private String createtime;
	private long pv;
	private String username;
	private List<Answer> answers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
//
//	public String getTitle_bak() {
//		return title_bak;
//	}
//
//	public void setTitle_bak(String title_bak) {
//		this.title_bak = title_bak;
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
