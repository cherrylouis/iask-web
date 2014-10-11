package com.downjoy.iask.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.downjoy.iask.dao.GameQuestionDao;
import com.downjoy.iask.dao.basedao.BaseMybatisDao;
import com.downjoy.iask.domain.DynamicSqlParameter;
import com.downjoy.iask.domain.Questions;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.util.PaginationResult;

/**
 * @Description: 游戏问题的DAO实现类
 * @author jian.yang@downjoy.com
 * @date 2014年9月9日 下午3:48:03
 * @version 1.0
 */
@Repository
public class GameQuestionDaoImpl extends BaseMybatisDao<Questions, Long>
        implements GameQuestionDao
{

    private static final Logger logger = Logger
            .getLogger(GameDetailInfoDaoImpl.class);

    /**
     * <p>
     * Description:
     * </p>
     * 
     * @param gameId
     * @return
     */
    @Override
    public int searchQuestionByGameId(String gameId)
    {
        try
        {
            super.setSqlmapNamespace(GameQuestionDao.class.getName());
            Map<String,String> map = new HashMap<String, String>();
            map.put("gameId", gameId);
            return super.count(map);
        }
        catch(BaseException e)
        {
            logger.info("通过游戏查询问题出现异常：" + e.getMessage());
            return 0;
        }
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
    public List<Questions> selectFk(DynamicSqlParameter param)
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
    public PaginationResult<Questions> selectFkPagination(
            DynamicSqlParameter param) throws BaseException
    {
        // TODO Auto-generated method stub
        return null;
    }

}
