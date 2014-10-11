package com.downjoy.iask.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.downjoy.iask.dao.GameDetailInfoDao;
import com.downjoy.iask.dao.basedao.BaseMybatisDao;
import com.downjoy.iask.domain.DynamicSqlParameter;
import com.downjoy.iask.domain.GameDetailInfo;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.util.PaginationResult;
/**
 *  GameDetailInfoDaoImpl 游戏详情Dao实现类
 * 
 * @author jian.yang@downjoy.com
 * @version 1.0
 * @param GameDetailInfo
 *            游戏详情实体类
 * @param <PK>
 *            主键类
 */
@Repository
public class GameDetailInfoDaoImpl extends BaseMybatisDao<GameDetailInfo, Long>
		implements GameDetailInfoDao {

	@Override
	public int insert(GameDetailInfo entity) throws BaseException {
		// TODO Auto-generated method stub
	    return  0;

	}

	@Override
	public int update(GameDetailInfo entity) throws BaseException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(DynamicSqlParameter param) throws BaseException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long primaryKey) throws BaseException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(DynamicSqlParameter param) throws BaseException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int truncate() throws BaseException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int count() throws BaseException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int count(Object param) throws BaseException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GameDetailInfo get(Long primaryKey) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GameDetailInfo> select() throws BaseException {
	    super.setSqlmapNamespace(GameDetailInfoDao.class.getName());
		return super.select();
	}

	@Override
	public List<GameDetailInfo> select(DynamicSqlParameter param)
			throws BaseException {
		return super.select(param);
	}

	@Override
	public PaginationResult<GameDetailInfo> selectPagination(
			DynamicSqlParameter param) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GameDetailInfo> selectFk(DynamicSqlParameter param)
			throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaginationResult<GameDetailInfo> selectFkPagination(
			DynamicSqlParameter param) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void batchInsert(List<GameDetailInfo> list) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void batchUpdate(List<GameDetailInfo> list) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void batchDelete(List<Long> list) throws BaseException {
		// TODO Auto-generated method stub

	}

}
