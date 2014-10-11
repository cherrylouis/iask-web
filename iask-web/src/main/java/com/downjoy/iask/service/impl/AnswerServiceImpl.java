package com.downjoy.iask.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.downjoy.iask.dao.AnswerDao;
import com.downjoy.iask.dao.basedao.BaseDao;
import com.downjoy.iask.domain.Answers;
import com.downjoy.iask.domain.DynamicSqlParameter;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.service.AnswerService;
import com.downjoy.iask.service.baseservice.BaseAbstractService;
import com.downjoy.iask.util.PaginationResult;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jian.yang@downjoy.com
 * @date 2014年10月8日 下午6:00:41
 * @version 1.0
 */
@Service("answerService")
public class AnswerServiceImpl extends BaseAbstractService<Answers, Long>
        implements AnswerService
{

    @Autowired
    @Qualifier("answerDao")
    private AnswerDao answerDao;

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
        return answerDao.insertAnswer(answers);
    }

    /**
     * <p>
     * Description:
     * </p>
     * 
     * @return
     */
    @Override
    public BaseDao<Answers, Long> getDao()
    {
        return answerDao;
    }

}
