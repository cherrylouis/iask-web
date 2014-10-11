package com.downjoy.iask.domain;

import com.downjoy.iask.domain.basedomain.BaseDoMain;

/**
 * User　用户实体类
 * 
 * @author jian.yang@downjoy.com
 * @since 1.0
 * 
 */
public class User extends BaseDoMain {
	/**
	 * 用户ID
	 */
	private Long id;

	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户昵称
	 */
	private String userNickName;
	/**
	 * 用户等级
	 */
	private String userLevel;
	/**
	 * 用户回答问题采纳率
	 */
	private String userAnswerAdoptionRate;
	/**
	 * 用户头像
	 */
	private String userAvatar;
	/**
	 * 用户的地址
	 */
	private String userAdrress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserAnswerAdoptionRate() {
		return userAnswerAdoptionRate;
	}

	public void setUserAnswerAdoptionRate(String userAnswerAdoptionRate) {
		this.userAnswerAdoptionRate = userAnswerAdoptionRate;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public String getUserAdrress() {
		return userAdrress;
	}

	public void setUserAdrress(String userAdrress) {
		this.userAdrress = userAdrress;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userNickName="
				+ userNickName + ", userLevel=" + userLevel
				+ ", userAnswerAdoptionRate=" + userAnswerAdoptionRate
				+ ", userAvatar=" + userAvatar + ", userAdrress=" + userAdrress
				+ "]";
	}

}
