package com.downjoy.iask.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.downjoy.iask.dao.QuestionDao;
import com.downjoy.iask.dao.basedao.BaseDao;
import com.downjoy.iask.domain.Questions;
import com.downjoy.iask.domain.RequestAdopt;
import com.downjoy.iask.domain.RequestRecommendation;
import com.downjoy.iask.domain.ResponseQuestion;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.service.QuestionService;
import com.downjoy.iask.service.baseservice.BaseAbstractService;

@Service("questionService")
public class QuestionServiceImpl extends BaseAbstractService<Questions, Long>
        implements QuestionService
{

    @Autowired
    @Qualifier("questionDao")
    private QuestionDao questionDao;

    @Override
    public int queryBrowseNum(Questions questions)
    {
        return questionDao.queryBrowseNum(questions);
    }

    @Override
    public BaseDao<Questions, Long> getDao()
    {
        return questionDao;
    }

    /**
     * <p>
     * Description:
     * </p>
     * 
     * @param requestAdopt
     * @return
     */
    @Override
    public List<ResponseQuestion> getIsNotAdoptQuestions(
            RequestAdopt requestAdopt)
    {
        List<Questions> list = questionDao.queryIsNotAdopt(requestAdopt);

        List<ResponseQuestion> responseQuestions = null;

        if (list != null && !list.isEmpty())
        {
            responseQuestions = new ArrayList<ResponseQuestion>();
            for (Questions questions : list)
            {
                ResponseQuestion responseQuestion = new ResponseQuestion();
                responseQuestion.setQuestionTitle(questions.getQuestionTitle());
                responseQuestion.setQuestionCreateTime(questions
                        .getQuestionCreateTime());
                responseQuestion.setQuestionRewardPoints(questions
                        .getQuestionRewardPoints());
                responseQuestions.add(responseQuestion);
            }
        }
        return responseQuestions;
    }

    /**
     * <p>
     * Description:保存提交的问题
     * </p>
     * 
     * @param questions
     * @return
     */
    @Override
    public int insertQuestion(Questions questions)
    {
        return questionDao.insertQuestion(questions);
    }

	@Override
	public List<RequestRecommendation> getRecommendationContent()
			throws BaseException {
		return questionDao.getRecommendationContent();
	}

}
