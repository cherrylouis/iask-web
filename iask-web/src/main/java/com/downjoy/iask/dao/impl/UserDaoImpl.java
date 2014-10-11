package com.downjoy.iask.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.downjoy.iask.dao.UserDao;
import com.downjoy.iask.dao.basedao.BaseMybatisDao;
import com.downjoy.iask.domain.DynamicSqlParameter;
import com.downjoy.iask.domain.RequestUser;
import com.downjoy.iask.domain.User;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.util.PaginationResult;

/**
 * @Description: 用户信息的Dao实现类
 * @author jian.yang@downjoy.com
 * @date 2014年9月2日 上午9:48:57
 * @version 1.0
 */
@Repository(value = "userDao")
public class UserDaoImpl extends BaseMybatisDao<User, Long> implements UserDao {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param param
	 * @return
	 * @throws BaseException
	 */
	@Override
	public List<User> selectFk(DynamicSqlParameter param) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param param
	 * @return
	 * @throws BaseException
	 */
	@Override
	public PaginationResult<User> selectFkPagination(DynamicSqlParameter param)
			throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(User entity) throws BaseException {
		super.setSqlmapNamespace(UserDao.class.getName());
		System.out.println("update");
		return super.update(entity);
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @throws BaseException
	 */
	@Override
	public int insert(User entity) throws BaseException {
		super.setSqlmapNamespace(UserDao.class.getName());
		System.out
				.println("==================================super========================");
		return super.insert(entity);
		// return getSqlSession().insert("com.downjoy.iask.dao.userDao.insert",
		// entity);
	}

	@Override
	public User getUserInfo(long id) {
		super.setSqlmapNamespace(UserDao.class.getName());
		return getSqlSession().selectOne("getUserInfo");
	}

	@Override
	public int getUserCount(long id) {
		super.setSqlmapNamespace(UserDao.class.getName());
		return getSqlSession().selectOne("getUserCount", id);
	}

	@Override
	public List<User> getAnswerNumberList(String beginData, String endDate) {
		super.setSqlmapNamespace(UserDao.class.getName());
		RequestUser requestUser = new RequestUser();
		requestUser.setBeginData(beginData);
		requestUser.setEndDate(endDate);
		return getSqlSession().selectList("getAnswerNumberList", requestUser);
	}

	@Override
	public List<User> getAdoptionList(String beginData, String endDate) {
		super.setSqlmapNamespace(UserDao.class.getName());
		RequestUser requestUser = new RequestUser();
		requestUser.setBeginData(beginData);
		requestUser.setEndDate(endDate);
		return getSqlSession().selectList("getAdoptionList", requestUser);
	}

}
