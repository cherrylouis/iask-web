package com.downjoy.push.controller;

import java.util.Collection;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.spring.SpringCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.downjoy.iask.domain.Answers;
import com.downjoy.iask.domain.Questions;
import com.downjoy.iask.service.AnswerService;
import com.downjoy.iask.service.QuestionService;
import com.downjoy.iask.util.Constants;
import com.downjoy.push.domain.PushMessageData;
import com.downjoy.push.util.ConvertObjectUtils;

/**
 * @Description: 消息推送
 * @author jian.yang@downjoy.com
 * @date 2014年9月30日 上午9:53:41
 * @version 1.0
 */
@Controller
@RemoteProxy(name = "directorController", creator = SpringCreator.class)
public class DirectorController
{

    @Autowired
    @Qualifier("questionService")
    private QuestionService questionService;

    @Autowired
    @Qualifier("answerService")
    private AnswerService answerService;

    @RemoteMethod
    public void message(String userId)
    {
        ScriptSession scriptSession = WebContextFactory.get()
                .getScriptSession();

        scriptSession.setAttribute(Constants.CURRENT_USER_ID, userId);

        System.out.println(userId + "=================" + scriptSession);

        DwrScriptSessionManagerUtil.sessionMap.put(userId, scriptSession);
    }

    @RemoteMethod
    public void sendMessageAuto(PushMessageData pushMessageData)
    {
        final String userId = pushMessageData.getSenderId();

        final String autoMessage = pushMessageData.getContext();
        //
        if (pushMessageData.getPushType() == null
                || "".equals(pushMessageData.getPushType()))
        {
            return;
        }

        // 1代表问题
        if (pushMessageData.getPushType().equalsIgnoreCase(
                Constants.QUESTION_PUSH_TYPE))
        {
            Questions questions = ConvertObjectUtils
                    .convertToQuestions(pushMessageData);
            questionService.insertQuestion(questions);
        }
        // 2代表回答的答案
        else if (pushMessageData.getPushType().equalsIgnoreCase(
                Constants.ANSWER_PUSH_TYPE))
        {
            Answers answers = ConvertObjectUtils
                    .convertToAnswers(pushMessageData);
            answerService.insertAnswer(answers);
        }

        if (Constants.PUSH_ALL_USER.equals(pushMessageData.getPushUserType()))
        {
            // 发送所有的对象
            Browser.withAllSessions(new Runnable()
            {

                private ScriptBuffer script = new ScriptBuffer();

                public void run()
                {

                    script.appendCall("showMessage", autoMessage);

                    Collection<ScriptSession> sessions = Browser

                    .getTargetSessions();

                    for (ScriptSession scriptSession : sessions)
                    {
                        System.out.println("发送的对象是======" + scriptSession);
                        scriptSession.addScript(script);

                    }

                }

            });
        }
        else if (Constants.PUSH_SPECIAL_USER.equals(pushMessageData
                .getPushUserType()))
        {
            Browser.withAllSessionsFiltered(new ScriptSessionFilter()
            {

                public boolean match(ScriptSession session)
                {

                    if (session.getAttribute(Constants.CURRENT_USER_ID) == null){
                        
                        return false;
                    }
                    else{
                        System.out.println( (session.getAttribute(Constants.CURRENT_USER_ID))
                                .equals(userId));
                        return (session.getAttribute(Constants.CURRENT_USER_ID))
                                .equals(userId);
                    }
                }

            }, new Runnable()
            {

                private ScriptBuffer script = new ScriptBuffer();

                public void run()
                {

                    script.appendCall("showMessage", autoMessage);

                    Collection<ScriptSession> sessions = Browser

                    .getTargetSessions();

                    for (ScriptSession scriptSession : sessions)
                    {
                        scriptSession.addScript(script);
                        System.out.println("发送的对象是======" + scriptSession);

                    }

                }

            });
        }

    }
}
