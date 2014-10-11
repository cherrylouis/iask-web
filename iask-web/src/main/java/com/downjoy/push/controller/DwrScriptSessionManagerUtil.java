package com.downjoy.push.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;

import com.downjoy.iask.domain.User;
import com.downjoy.iask.util.Constants;

/**
 * @Description: scriptSession管理类
 * @author jian.yang@downjoy.com
 * @date 2014年10月9日 下午1:23:26
 * @version 1.0
 */
public class DwrScriptSessionManagerUtil implements ScriptSessionListener
{
    public static Map<String, ScriptSession> sessionMap = new HashMap<String, ScriptSession>();

    @Override
    public void sessionDestroyed(ScriptSessionEvent paramScriptSessionEvent)
    {
        HttpSession httpSession = WebContextFactory.get().getSession();
        String ssId = (String) httpSession
                .getAttribute(Constants.SCRIPT_SESSION_ID);
        invalidate(ssId);
    }

    @Override
    public void sessionCreated(ScriptSessionEvent paramScriptSessionEvent)
    {
        // 获取创建的scriptSession
        ScriptSession scriptSession = paramScriptSessionEvent.getSession();
        // 得到产生的httpSession
        HttpSession httpSession = WebContextFactory.get().getSession();
        // 得到当前用户
        User user = (User) httpSession
                .getAttribute(Constants.CURRENT_SESSION_USER);
        String userId = (String) httpSession
                .getAttribute(Constants.CURRENT_USER_ID);
        // 如果当前用户已经退出系统，然后销毁这个scriptsession

        if (user == null)
        {
            scriptSession.invalidate();
            httpSession.invalidate();
            return;
        }
        String ssId = (String) scriptSession
                .getAttribute(Constants.CURRENT_USER_ID);
        if (ssId != null)
        {
            // 说明已经存在旧的scriptSession.注销这个旧的scriptSession
            ScriptSession oldScriptSession = sessionMap.get(ssId);
            if (oldScriptSession != null)
            {
                invalidate(oldScriptSession.getId());
            }
        }
        httpSession.setAttribute(Constants.SCRIPT_SESSION_ID,
                scriptSession.getId());
        // 绑定用户ID到ScriptSession上
        scriptSession.setAttribute(Constants.CURRENT_USER_ID, userId);
    }

    public void invalidate(String ssId)
    {
        Browser.withSession(ssId, new Runnable()
        {

            public void run()
            {
                Collection<ScriptSession> sessions = Browser
                        .getTargetSessions();
                for (ScriptSession session : sessions)
                {
                    session.invalidate();
                }
            }
        });
    }

}
