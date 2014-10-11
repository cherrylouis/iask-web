package com.downjoy.iask.domain;

import com.downjoy.iask.domain.basedomain.BaseDoMain;

/**
 * KeyWords 关键词类
 * 
 * @author jian.yang@downjoy.com
 * 
 */
public class KeyWords extends BaseDoMain {
	/**
	 * 主键ID
	 */
	private Long id;
	/**
	 * 关键词
	 */
	private String keyWords;
	/**
	 * 拼音的首字母
	 */
	private String pininInitCode;
	/**
	 * 拼音的全字母
	 */
	private String pininAllCode;
	/**
	 * 关键词使用频率
	 */
	private Long frequency;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getPininInitCode() {
		return pininInitCode;
	}

	public void setPininInitCode(String pininInitCode) {
		this.pininInitCode = pininInitCode;
	}

	public String getPininAllCode() {
		return pininAllCode;
	}

	public void setPininAllCode(String pininAllCode) {
		this.pininAllCode = pininAllCode;
	}

	public Long getFrequency() {
		return frequency;
	}

	public void setFrequency(Long frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
