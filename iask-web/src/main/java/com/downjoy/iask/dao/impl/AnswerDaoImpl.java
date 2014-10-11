package com.downjoy.iask.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.downjoy.iask.dao.AnswerDao;
import com.downjoy.iask.dao.basedao.BaseMybatisDao;
import com.downjoy.iask.domain.Answers;
import com.downjoy.iask.domain.DynamicSqlParameter;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.util.PaginationResult;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jian.yang@downjoy.com
 * @date 2014年10月8日 下午5:51:20
 * @version 1.0
 */
@Repository("answerDao")
public class AnswerDaoImpl extends BaseMybatisDao<Answers, Long> implements
        AnswerDao
{

    private static final Logger logger = Logger.getLogger(AnswerDaoImpl.class);

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
    public List<Answers> selectFk(DynamicSqlParameter param)
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
    public PaginationResult<Answers> selectFkPagination(
            DynamicSqlParameter param) throws BaseException
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * <p>
     * Description:
     * </p>
     * 
     * @param answers
     * @return
     */
    @Override
    public int insertAnswer(Answers answers)
    {
        super.setSqlmapNamespace(AnswerDao.class.getName());
        try
        {
            return super.insert(answers);
        }
        catch(BaseException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

}
