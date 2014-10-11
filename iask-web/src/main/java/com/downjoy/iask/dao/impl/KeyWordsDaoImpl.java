package com.downjoy.iask.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.downjoy.iask.dao.KeyWordsDao;
import com.downjoy.iask.dao.basedao.BaseMybatisDao;
import com.downjoy.iask.domain.DynamicSqlParameter;
import com.downjoy.iask.domain.KeyWords;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.util.PaginationResult;

/**
 * @Description: 关键词Dao实现类
 * @author jian.yang@downjoy.com
 * @date 2014年9月2日 上午9:48:17
 * @version 1.0
 */
@Repository(value = "keyWordsDao")
public class KeyWordsDaoImpl extends BaseMybatisDao<KeyWords, Long> implements
        KeyWordsDao
{

    @Override
    public int update(KeyWords entity) throws BaseException
    {
        return super.update(entity);
    }

    @Override
    public List<KeyWords> select() throws BaseException
    {
        super.setSqlmapNamespace(KeyWordsDao.class.getName());
        return super.select();
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
    public List<KeyWords> selectFk(DynamicSqlParameter param)
            throws BaseException
    {
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
    public PaginationResult<KeyWords> selectFkPagination(
            DynamicSqlParameter param) throws BaseException
    {
        // TODO Auto-generated method stub
        return null;
    }

}
