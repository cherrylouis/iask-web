package com.downjoy.iask.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.downjoy.iask.dao.GameDetailInfoDao;
import com.downjoy.iask.dao.basedao.BaseDao;
import com.downjoy.iask.domain.DynamicSqlParameter;
import com.downjoy.iask.domain.GameDetailInfo;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.service.GameDetailInfoService;
import com.downjoy.iask.service.baseservice.BaseAbstractService;
import com.downjoy.iask.util.PaginationResult;
/**
 * GameDetailInfoServiceImpl 游戏详情业务逻辑类
 * 
 * @author jian.yang@downjoy.com
 * 
 */
@Service("gameDetailInfoService")
public class GameDetailInfoServiceImpl extends
		BaseAbstractService<GameDetailInfo, Long> implements GameDetailInfoService {
	
	@Autowired
	private GameDetailInfoDao gameDetailInfoDao;

	@Override
	public int insert(GameDetailInfo entity) throws BaseException {
      return 0;
	}

	@Override
	public int update(GameDetailInfo entity) throws BaseException {
		return 0;
	}

	@Override
	public int update(DynamicSqlParameter param) throws BaseException {
		return 0;
	}

	@Override
	public int delete(Long primaryKey) throws BaseException {
		return 0;
	}

	@Override
	public int delete(DynamicSqlParameter param) throws BaseException {
		return 0;
	}

	@Override
	public int truncate() throws BaseException {
		return 0;
	}

	@Override
	public int count() throws BaseException {
		return 0;
	}

	@Override
	public int count(Object param) throws BaseException {
		return 0;
	}

	@Override
	public GameDetailInfo get(Long primaryKey) throws BaseException {
		return null;
	}

	@Override
	public List<GameDetailInfo> select() throws BaseException {
		
		return gameDetailInfoDao.select();
	}

	@Override
	public List<GameDetailInfo> select(DynamicSqlParameter param)
			throws BaseException {
		return null;
	}

	@Override
	public PaginationResult<GameDetailInfo> selectPagination(
			DynamicSqlParameter param) throws BaseException {
		return null;
	}

	@Override
	public List<GameDetailInfo> selectFk(DynamicSqlParameter param)
			throws BaseException {
		return null;
	}

	@Override
	public PaginationResult<GameDetailInfo> selectFkPagination(
			DynamicSqlParameter param) throws BaseException {
		return null;
	}

	@Override
	public void batchInsert(List<GameDetailInfo> list) throws BaseException {

	}

	@Override
	public void batchUpdate(List<GameDetailInfo> list) throws BaseException {

	}

	@Override
	public void batchDelete(List<Long> list) throws BaseException {

	
	}


	@Override
	public BaseDao<GameDetailInfo, Long> getDao() {
		return gameDetailInfoDao;
	}

}
