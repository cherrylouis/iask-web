package com.downjoy.iask.dao;

import com.downjoy.iask.dao.basedao.BaseDao;
import com.downjoy.iask.domain.Questions;

/**
 * @Description: 游戏问题Dao
 * @author jian.yang@downjoy.com
 * @date 2014年9月9日 下午3:42:10
 * @version 1.0
 */
public interface GameQuestionDao extends BaseDao<Questions, Long>
{

    /**
     * @Description: 根据游戏ID获取是否存在问答的记录数
     * @param gameId  游戏ID
     * @return int 返回类型
     * @throws
     */
    public int searchQuestionByGameId(String gameId);
}
