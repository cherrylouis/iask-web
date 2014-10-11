package com.downjoy.iask.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.downjoy.iask.dao.QuestionDao;
import com.downjoy.iask.dao.basedao.BaseMybatisDao;
import com.downjoy.iask.domain.DynamicSqlParameter;
import com.downjoy.iask.domain.Questions;
import com.downjoy.iask.domain.RequestAdopt;
import com.downjoy.iask.domain.RequestRecommendation;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.util.PaginationResult;

@Repository("questionDao")
public class QuestionDaoImpl extends BaseMybatisDao<Questions, Long> implements
        QuestionDao
{

    @Override
    public int update(Questions entity) throws BaseException
    {
        super.setSqlmapNamespace(QuestionDao.class.getName());
        return super.update(entity);
    }

    @Override
    public int queryBrowseNum(Questions questions)
    {
        super.setSqlmapNamespace(QuestionDao.class.getName());
        return getSqlSession().selectOne(
                getSqlmapNamespace() + ".queryBrowseNum", questions);
    }

    @Override
    public List<Questions> selectFk(DynamicSqlParameter param)
            throws BaseException
    {
        return null;
    }

    @Override
    public PaginationResult<Questions> selectFkPagination(
            DynamicSqlParameter param) throws BaseException
    {
        return null;
    }

    /**
     * <p>
     * Description: 查询未采纳的问题
     * </p>
     * 
     * @param requestAdopt
     *            请求参数实体
     * @return 返回未采纳的问题
     */
    @Override
    public List<Questions> queryIsNotAdopt(RequestAdopt requestAdopt)
    {
        super.setSqlmapNamespace(QuestionDao.class.getName());
        return getSqlSession().selectOne(getSqlmapNamespace() + ".isNotAdopt",
                requestAdopt);
    }

    /**
     * <p>
     * Description: 保存用户提交的问题
     * </p>
     * 
     * @param questions
     *            问题实体
     * @return 返回保存成功的数量
     */
    @Override
    public int insertQuestion(Questions questions)
    {
        super.setSqlmapNamespace(QuestionDao.class.getName());
        try
        {
            return super.insert(questions);
        }
        catch(BaseException e)
        {
            e.printStackTrace();
            return 0;
        }
    }


	@Override
	public List<RequestRecommendation> getRecommendationContent() {
		super.setSqlmapNamespace(QuestionDao.class.getName());
		return getSqlSession().selectList(
				getSqlmapNamespace() + ".getRecommendationContent");
	}

}
