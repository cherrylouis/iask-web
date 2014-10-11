package com.downjoy.iask.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.downjoy.iask.dao.KeyWordsDao;
import com.downjoy.iask.dao.basedao.BaseDao;
import com.downjoy.iask.domain.DynamicSqlParameter;
import com.downjoy.iask.domain.KeyWords;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.service.KeyWordsRateService;
import com.downjoy.iask.service.baseservice.BaseAbstractService;
import com.downjoy.iask.util.PaginationResult;

/**
 * @Description: 关键词业务逻辑类
 * @author jian.yang@downjoy.com
 * @date 2014年9月2日 上午9:42:13
 * @version 1.0
 */
@Service("keyWordsRateService")
public class KeyWordsRateServiceImpl extends
        BaseAbstractService<KeyWords, Long> implements KeyWordsRateService
{

    Logger logger = Logger.getLogger(KeyWordsRateServiceImpl.class);

    @Autowired
    @Qualifier("keyWordsDao")
    private KeyWordsDao keyWordsDao;

    @Override
    public int insert(KeyWords entity) throws BaseException
    {
        return 0;

    }

    @Override
    public int update(KeyWords entity) throws BaseException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(DynamicSqlParameter param) throws BaseException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Long primaryKey) throws BaseException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(DynamicSqlParameter param) throws BaseException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int truncate() throws BaseException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int count() throws BaseException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int count(Object param) throws BaseException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public KeyWords get(Long primaryKey) throws BaseException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<KeyWords> select() throws BaseException
    {
        // TODO Auto-generated method stub
        return keyWordsDao.select();
    }

    @Override
    public List<KeyWords> select(DynamicSqlParameter param)
            throws BaseException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PaginationResult<KeyWords> selectPagination(DynamicSqlParameter param)
            throws BaseException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<KeyWords> selectFk(DynamicSqlParameter param)
            throws BaseException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PaginationResult<KeyWords> selectFkPagination(
            DynamicSqlParameter param) throws BaseException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void batchInsert(List<KeyWords> list) throws BaseException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void batchUpdate(List<KeyWords> list) throws BaseException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void batchDelete(List<Long> list) throws BaseException
    {
        // TODO Auto-generated method stub

    }

    public BaseDao<KeyWords, Long> getDao()
    {
        return keyWordsDao;
    }

}
