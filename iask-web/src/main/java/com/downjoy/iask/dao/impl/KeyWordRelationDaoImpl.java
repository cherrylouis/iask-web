package com.downjoy.iask.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.downjoy.iask.dao.KeyWordRelationDao;
import com.downjoy.iask.dao.basedao.BaseMybatisDao;
import com.downjoy.iask.domain.DynamicSqlParameter;
import com.downjoy.iask.domain.KeyWordRelation;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.util.PaginationResult;

@Repository(value = "keyWordRelationDao")
public class KeyWordRelationDaoImpl extends
        BaseMybatisDao<KeyWordRelation, Long> implements KeyWordRelationDao
{

    @Override
    public String getSqlmapNamespace()
    {
        return KeyWordRelationDao.class.getName();
    }

    @Override
    public List<KeyWordRelation> getGameKeyWords(String keyWord)
    {
        return getSqlSession().selectList(
                getSqlmapNamespace() + ".getGameKeyWords", keyWord);
    }

    @Override
    public List<KeyWordRelation> getKeyWordsByLog(String game, String keyWord)
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("game", game);
        params.put("keyWord", keyWord);
        return getSqlSession().selectList(
                getSqlmapNamespace() + ".getKeyWordsByLog", params);
    }

    @Override
    public List<KeyWordRelation> getKeyWordsByFrequency(String game,
            String keyWord)
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("game", game);
        params.put("keyWord", keyWord);
        return getSqlSession().selectList(
                getSqlmapNamespace() + ".getKeyWordsByFrequency", params);
    }

    @Override
    public List<KeyWordRelation> selectFk(DynamicSqlParameter param)
            throws BaseException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PaginationResult<KeyWordRelation> selectFkPagination(
            DynamicSqlParameter param) throws BaseException
    {
        // TODO Auto-generated method stub
        return null;
    }
}
