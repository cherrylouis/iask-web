package com.downjoy.iask.dao;

import com.downjoy.iask.dao.basedao.BaseDao;
import com.downjoy.iask.domain.Answers;

/**
 * @Description: 答案业务逻辑DAO
 * @author jian.yang@downjoy.com
 * @date 2014年10月8日 下午5:43:38
 * @version 1.0
 */
public interface AnswerDao extends BaseDao<Answers, Long>
{
    /**
     * @Description: 保存答案
     * @param answers
     * @return 设定文件
     * @return int 返回类型
     * @throws
     */
    public int insertAnswer(Answers answers);
}
