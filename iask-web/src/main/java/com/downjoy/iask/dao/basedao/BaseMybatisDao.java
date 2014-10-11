package com.downjoy.iask.dao.basedao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.datasource.DataSourceException;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.downjoy.iask.domain.DynamicSqlParameter;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.exception.ParameterException;
import com.downjoy.iask.util.PaginationResult;

/**
 * mybatis DAO层泛型基类，实现了基本的DAO功能
 * 
 * @author jian.yang@downjoy.com
 * @since 1.0
 * @param <T>
 *            实体类
 * @param <PK>
 *            主键类，必须实现Serializable接口
 */
public abstract class BaseMybatisDao<T, PK extends Serializable> extends
		SqlSessionDaoSupport implements BaseDao<T, PK> {

	// sqlmap.xml定义文件中对应的sqlid
	public static final String SQLID_INSERT = "insert";
	public static final String SQLID_INSERT_BATCH = "insertBatch";
	public static final String SQLID_UPDATE = "update";
	public static final String SQLID_UPDATE_BATCH = "updateBatch";
	public static final String SQLID_UPDATE_PARAM = "updateParam";
	public static final String SQLID_DELETE = "delete";
	public static final String SQLID_DELETE_BATCH = "deleteBatch";
	public static final String SQLID_DELETE_PARAM = "deleteParam";
	public static final String SQLID_TRUNCATE = "truncate";
	public static final String SQLID_SELECT = "select";
	public static final String SQLID_SELECT_PK = "selectPk";
	public static final String SQLID_SELECT_PARAM = "selectParam";
	public static final String SQLID_SELECT_FK = "selectFk";
	public static final String SQLID_COUNT = "count";
	public static final String SQLID_COUNT_PARAM = "countParam";

	private String sqlmapNamespace = "";

	
	@Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
	/**
	 * sqlmapNamespace，对应sqlmap.xml中的命名空间
	 * 
	 * @return
	 */
	public String getSqlmapNamespace() {
		return sqlmapNamespace;
	}

	/**
	 * sqlmapNamespace的设置方法，可以用于spring注入
	 * 
	 * @param sqlmapNamespace
	 */
	public void setSqlmapNamespace(String sqlmapNamespace) {
		this.sqlmapNamespace = sqlmapNamespace;
	}

	/**
	 * 数据库方言，缺省为MYSQL
	 */
	private String dbDialect = "MYSQL";

	/**
	 * 数据库方言dbDialect的get方法
	 * 
	 * @return
	 */
	public String getDbDialect() {
		return dbDialect;
	}

	/**
	 * 数据库方言dbDialect的set方法
	 * 
	 * @return
	 */
	public void setDbDialect(String dbDialect) {
		if (dbDialect == null
				|| (!dbDialect.equals("MYSQL") && !dbDialect.equals("ORACLE")))
			throw new DataSourceException("错误的数据库方言设置：本系统只支持MYSQL和ORACLE");
		this.dbDialect = dbDialect;
	}

	@Override
	public int count() throws BaseException {
		Integer count = (Integer) getSqlSession().selectOne(
				sqlmapNamespace + "." + SQLID_COUNT);
		return count.intValue();
	}

	@Override
	public int count(Object param) throws BaseException {
		Integer count = (Integer) getSqlSession().selectOne(
				sqlmapNamespace + "." + SQLID_COUNT_PARAM, param);
		return count.intValue();
	}

	@Override
	public int delete(PK primaryKey) throws BaseException {
		int rows = getSqlSession().delete(sqlmapNamespace + "." + SQLID_DELETE,
				primaryKey);
		return rows;
	}

	public int delete(DynamicSqlParameter param) throws BaseException {
		int rows = getSqlSession().delete(
				sqlmapNamespace + "." + SQLID_DELETE_PARAM, param);
		return rows;
	}

	public int truncate() throws BaseException {
		int rows = getSqlSession().delete(
				sqlmapNamespace + "." + SQLID_TRUNCATE);
		return rows;
	}

	@SuppressWarnings("unchecked")
	public T get(PK primaryKey) throws BaseException {
		return (T) getSqlSession().selectOne(
				sqlmapNamespace + "." + SQLID_SELECT_PK, primaryKey);
	}

	public int insert(T entity) throws BaseException {
		int num = getSqlSession().insert(sqlmapNamespace + "." + SQLID_INSERT, entity);
		return num;
	}

	public List<T> select() throws BaseException {
		return getSqlSession().selectList(sqlmapNamespace + "." + SQLID_SELECT);
	}

	public List<T> select(DynamicSqlParameter param) throws BaseException {
		return getSqlSession().selectList(
				sqlmapNamespace + "." + SQLID_SELECT_PARAM, param.getParams());
	}

	public PaginationResult<T> selectPagination(DynamicSqlParameter param)
			throws BaseException {
		int page = param.getPage() == null || "".equals(param.getPage()) ? 1
				: param.getPage(); // 默认为第一页
		int size = param.getSize() == null || "".equals(param.getSize()) ? 15
				: param.getSize();
		; // 默认每页15个
		RowBounds rowBounds = new RowBounds((page - 1) * size, size);

		Map<Object, Object> paramMap = param.getParams();
		if (paramMap != null) {
			paramMap.put("orderColumn", param.getOrderColumn());
			paramMap.put("orderTurn", param.getOrderTurn());
		} else {
			paramMap = new HashMap<Object, Object>();
			paramMap.put("orderColumn", param.getOrderColumn());
			paramMap.put("orderTurn", param.getOrderTurn());
		}

		List<T> resultList = getSqlSession().selectList(
				sqlmapNamespace + "." + SQLID_SELECT_PARAM, param, rowBounds);
		int totalSize = count(param.getParams());

		PaginationResult<T> pagingResult = new PaginationResult<T>();
		pagingResult.setCurrentPage(page);
		pagingResult.setTotalSize(totalSize);
		pagingResult.setResultList(resultList);
		return pagingResult;
	}

	public int update(T entity) throws BaseException {
		return getSqlSession().update(sqlmapNamespace + "." + SQLID_UPDATE,
				entity);
	}

	public int update(DynamicSqlParameter param) throws BaseException {
		if (param == null)
			throw new ParameterException(
					"设定update的column!");

		return getSqlSession().update(
				sqlmapNamespace + "." + SQLID_UPDATE_PARAM, param);
	}

	public void batchInsert(final List<T> list) throws BaseException {

		getSqlSession().insert(sqlmapNamespace + "." + SQLID_INSERT, list);
	}

	public void batchUpdate(final List<T> list) throws BaseException {
		int rows = 0;
		for (T t : list) {
			rows = rows
					+ getSqlSession().update(
							sqlmapNamespace + "." + SQLID_UPDATE, t);
		}
	}

	public void batchDelete(final List<PK> list) throws BaseException {
		getSqlSession()
				.delete(sqlmapNamespace + "." + SQLID_DELETE_BATCH, list);
	}
}
