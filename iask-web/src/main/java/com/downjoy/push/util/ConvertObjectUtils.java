package com.downjoy.push.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.downjoy.iask.domain.Answers;
import com.downjoy.iask.domain.Questions;
import com.downjoy.push.domain.PushMessageData;

/**
 * @Description:数据对象转换接口
 * @author jian.yang@downjoy.com
 * @date 2014年10月9日 下午3:07:42
 * @version 1.0
 */
public class ConvertObjectUtils
{

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    /**
     * @Description: 推送的数据转成提问的对象
     * @param pushMessageData
     * @return 设定文件
     * @return Questions 返回类型
     * @throws
     */
    public static Questions convertToQuestions(PushMessageData pushMessageData)
    {

        Questions questions = new Questions();

        questions.setGameId(Long.valueOf(pushMessageData.getGameId()));
        questions.setUserId(Long.valueOf(pushMessageData.getSenderId()));

        questions.setQuestionTitle(pushMessageData.getContext());
        questions.setQuestionRewardPoints(pushMessageData
                .getQuestionRewardPoints());
        questions.setQuestionCreateTime(simpleDateFormat.format(new Date()));

        return questions;
    }

    /**
     * @Description: 推送的数据转成答案的对象
     * @param pushMessageData
     * @return 设定文件
     * @return Answers 返回类型
     * @throws
     */
    public static Answers convertToAnswers(PushMessageData pushMessageData)
    {
        Answers answers = new Answers();
        answers.setUserId(pushMessageData.getReceiverId());
        answers.setAnswerContext(pushMessageData.getContext());
        answers.setAnswerBestMark("1");
        answers.setAnswerOppositionNum("0");
        answers.setAnswerPv("0");
        answers.setAnswerSupportNum("0");
        answers.setAnswerTime(simpleDateFormat.format(new Date()));
        answers.setQuestionId(pushMessageData.getQuestionId());
        return answers;
    }
}
