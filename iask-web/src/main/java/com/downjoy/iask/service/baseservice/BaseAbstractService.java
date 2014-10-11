package com.downjoy.iask.service.baseservice;

import java.io.Serializable;
import java.util.List;

import com.downjoy.iask.dao.basedao.BaseDao;
import com.downjoy.iask.domain.DynamicSqlParameter;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.util.PaginationResult;
/**
 * BaseAbstractService service层泛型抽象类，实现了基本的service功能
 * 
 * @author jian.yang@downjoy.com
 * @
 * @since 1.0
 * @param <T>
 *            实体类
 * @param <PK>
 *            主键类，必须实现Serializable接口
 */
public abstract class BaseAbstractService<T, ID extends Serializable> implements BaseService<T, ID>  {

	public abstract BaseDao<T, ID> getDao();

	@Override
	public int insert(T entity) throws BaseException {
	 return 	getDao().insert(entity);
		
	}

	@Override
	public int update(T entity) throws BaseException {
		
		return getDao().update(entity);
	}

	@Override
	public int update(DynamicSqlParameter param) throws BaseException {
		return getDao().update(param);
	}

	@Override
	public int delete(ID primaryKey) throws BaseException {
		
		return getDao().delete(primaryKey);
	}

	@Override
	public int delete(DynamicSqlParameter param) throws BaseException {
		return getDao().delete(param);
	}

	@Override
	public int truncate() throws BaseException {
		
		return getDao().truncate();
	}

	@Override
	public int count() throws BaseException {
		return getDao().count();
	}

	@Override
	public int count(Object param) throws BaseException {
		return getDao().count(param);
	}

	@Override
	public T get(ID primaryKey) throws BaseException {
		return getDao().get(primaryKey);
	}

	@Override
	public List<T> select() throws BaseException {
		
		return getDao().select();
	}

	@Override
	public List<T> select(DynamicSqlParameter param) throws BaseException {
		
		return getDao().select(param);
	}

	@Override
	public PaginationResult<T> selectPagination(DynamicSqlParameter param)
			throws BaseException {
		return getDao().selectPagination(param);
	}

	@Override
	public List<T> selectFk(DynamicSqlParameter param) throws BaseException {
		return getDao().selectFk(param);
	}

	@Override
	public PaginationResult<T> selectFkPagination(DynamicSqlParameter param)
			throws BaseException {
		return getDao().selectFkPagination(param);
	}

	@Override
	public void batchInsert(List<T> list) throws BaseException {
		 getDao().batchInsert(list);
	}

	@Override
	public void batchUpdate(List<T> list) throws BaseException {
		 getDao().batchUpdate(list);
	}

	@Override
	public void batchDelete(List<ID> list) throws BaseException {
		 getDao().batchDelete(list);
	}
	
	

}
