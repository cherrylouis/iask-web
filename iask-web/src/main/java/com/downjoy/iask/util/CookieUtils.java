package com.downjoy.iask.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.downjoy.iask.domain.User;

public class CookieUtils {

	public static void main(String[] args) {
		String s="liuming511%28132010057%29";
		System.out.println(s.length());
	}

	/**
	 * 通过cookie获取用户信息
	 * 
	 * @param request
	 *            请求参数
	 * @return 用户信息
	 */
	public static User getUserInfo(HttpServletRequest request) {
		User user = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			String name = c.getName();

			if (name.contains("DJ_MEMBER_INFO")) {
				user = new User();
				String userId = c.getValue();

				// 如果长度大于25，需要通过解码的方式取得用户名
				if (userId.length() > 25) {
					String userName = userId.substring(0,
							userId.lastIndexOf("%"));
					userName = userName.substring(0, userName.lastIndexOf("%"));
					URLDecoder urlDecoder = new URLDecoder();
					try {
						String decode = urlDecoder.decode(userName, "utf-8");
						decode = urlDecoder.decode(decode, "utf-8");
						user.setUserNickName(decode);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} else {
					String userName = userId.substring(0, userId.indexOf("%"));
					user.setUserNickName(userName);
				}

				userId = userId.substring(0, userId.lastIndexOf("%"));
				userId = userId.substring(userId.lastIndexOf("%") + 1,
						userId.length());
				user.setId(Long.valueOf(userId.substring(2, userId.length())));
				user.setUserLevel("1");
			}
		}
		return user;
	}
}
