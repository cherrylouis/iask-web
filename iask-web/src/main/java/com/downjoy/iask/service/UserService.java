package com.downjoy.iask.service;

import java.util.List;

import com.downjoy.iask.domain.User;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.service.baseservice.BaseService;

/**
 * @Description: 用户信息service层泛型接口，定义基本的service功能
 * @author jian.yang@downjoy.com
 * @date 2014年9月2日 上午9:01:32
 * @version 1.0
 */
public interface UserService extends BaseService<User, Long> {
	public int insertUser(User entity) throws BaseException;

	public User getUserInfo(int id) throws BaseException;

	public int getUserCount(long id) throws BaseException;

	List<User> getAnswerNumberList(String beginData, String endDate)
			throws BaseException;

	List<User> getAdoptionList(String beginData, String endDate)
			throws BaseException;

}
