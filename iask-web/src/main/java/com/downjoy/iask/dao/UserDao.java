package com.downjoy.iask.dao;

import java.util.List;

import com.downjoy.iask.dao.basedao.BaseDao;
import com.downjoy.iask.domain.User;
import com.downjoy.iask.exception.BaseException;

/**
 * @Description: 用户信息的Dao
 * @author jian.yang@downjoy.com
 * @date 2014年9月2日 上午9:53:47
 * @version 1.0
 */
public interface UserDao extends BaseDao<User, Long> {

	public User getUserInfo(long id);

	public int getUserCount(long id);

	List<User> getAnswerNumberList(String beginData, String endDate);

	List<User> getAdoptionList(String beginData, String endDate);

}
