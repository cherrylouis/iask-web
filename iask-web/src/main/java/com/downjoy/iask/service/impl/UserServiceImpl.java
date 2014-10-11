package com.downjoy.iask.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.downjoy.iask.dao.UserDao;
import com.downjoy.iask.dao.basedao.BaseDao;
import com.downjoy.iask.dao.impl.UserDaoImpl;
import com.downjoy.iask.domain.User;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.service.UserService;
import com.downjoy.iask.service.baseservice.BaseAbstractService;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jian.yang@downjoy.com
 * @date 2014年9月5日 下午5:19:57
 * @version 1.0
 */
@Service("userService")
public class UserServiceImpl extends BaseAbstractService<User, Long> implements
		UserService {
	/**
	 * 用户Dao
	 */
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

	@Override
	public BaseDao<User, Long> getDao() {
		return userDao;
	}

	@Override
	public int insertUser(User entity) throws BaseException {
		return userDao.insert(entity);
	}

	@Override
	public User getUserInfo(int id) throws BaseException {
		return userDao.getUserInfo(id);
	}

	@Override
	public int getUserCount(long id) throws BaseException {
		return userDao.getUserCount(id);
	}

	@Override
	public List<User> getAnswerNumberList(String beginData, String endDate)
			throws BaseException {
		return userDao.getAnswerNumberList(beginData, endDate);
	}

	@Override
	public List<User> getAdoptionList(String beginData, String endDate)
			throws BaseException {
		return userDao.getAdoptionList(beginData, endDate);
	}
}
