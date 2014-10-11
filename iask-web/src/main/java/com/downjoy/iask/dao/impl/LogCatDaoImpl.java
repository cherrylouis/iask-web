package com.downjoy.iask.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.downjoy.iask.dao.LogCatDao;
import com.downjoy.iask.dao.basedao.BaseMybatisDao;
import com.downjoy.iask.domain.DynamicSqlParameter;
import com.downjoy.iask.domain.Log;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.util.PaginationResult;

@Repository("logCatDao")
public class LogCatDaoImpl extends BaseMybatisDao<Log, Long> implements
		LogCatDao {

	@Override
	public void setSqlmapNamespace(String sqlmapNamespace) {
		super.setSqlmapNamespace(LogCatDao.class.getName());
	}

	@Override
	public int insert(Log entity) throws BaseException {
		super.setSqlmapNamespace(LogCatDao.class.getName());
		return super.insert(entity);
	}

	@Override
	public List<Log> selectFk(DynamicSqlParameter param) throws BaseException {
		return null;
	}

	@Override
	public PaginationResult<Log> selectFkPagination(DynamicSqlParameter param)
			throws BaseException {
		return null;
	}

}
