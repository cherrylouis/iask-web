package com.downjoy.iask.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.downjoy.iask.dao.GameQuestionDao;
import com.downjoy.iask.dao.basedao.BaseDao;
import com.downjoy.iask.domain.DynamicSqlParameter;
import com.downjoy.iask.domain.Questions;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.service.GameQuestionService;
import com.downjoy.iask.service.baseservice.BaseAbstractService;
import com.downjoy.iask.util.PaginationResult;

/** 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author jian.yang@downjoy.com
 * @date 2014年9月9日 下午4:05:05 
 * @version 1.0 
 */
@Service("gameQuestionService")
public class GameQuestionServiceImpl extends BaseAbstractService<Questions, Long>
        implements GameQuestionService
{

  @Autowired
  private GameQuestionDao gameQuestionDao;
    /**
     * <p>Description: </p> 
     * @param gameId
     * @return 
     */
    @Override
    public int searchQuestionByGameId(String gameId)
    {
        return gameQuestionDao.searchQuestionByGameId(gameId);
    }

    /**
     * <p>Description: </p> 
     * @return 
     */
    @Override
    public BaseDao<Questions, Long> getDao()
    {
        return gameQuestionDao;
    }

  

}
