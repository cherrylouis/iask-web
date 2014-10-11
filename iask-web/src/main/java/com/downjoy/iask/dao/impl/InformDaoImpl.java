package com.downjoy.iask.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.downjoy.iask.dao.InformDao;
import com.downjoy.iask.dao.basedao.BaseMybatisDao;
import com.downjoy.iask.domain.DynamicSqlParameter;
import com.downjoy.iask.domain.Inform;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.util.PaginationResult;

@Repository("informDao")
public class InformDaoImpl extends BaseMybatisDao<Inform, Long> implements
		InformDao {

	@Override
	public Inform get(Long primaryKey) throws BaseException {
		super.setSqlmapNamespace(InformDao.class.getName());
		return getSqlSession().selectOne(getSqlmapNamespace() + ".get",
				primaryKey);
	}

	@Override
	public int insert(Inform entity) throws BaseException {
		super.setSqlmapNamespace(InformDao.class.getName());
		return getSqlSession().insert(getSqlmapNamespace() + ".insert", entity);
	}

	@Override
	public int update(Inform entity) throws BaseException {
		super.setSqlmapNamespace(InformDao.class.getName());
		return getSqlSession().update(getSqlmapNamespace() + ".update", entity);
	}

	@Override
	public List<Inform> selectFk(DynamicSqlParameter param)
			throws BaseException {
		return null;
	}

	@Override
	public PaginationResult<Inform> selectFkPagination(DynamicSqlParameter param)
			throws BaseException {
		return null;
	}

	@Override
	public void uploadInformInfo(Inform inform) {
		System.out.println("asassa");
		super.setSqlmapNamespace(InformDao.class.getName());
		System.out.println(getSqlmapNamespace());
		getSqlSession().update(getSqlmapNamespace() + ".updateInfo");
	}

}
