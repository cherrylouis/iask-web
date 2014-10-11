package com.downjoy.push.controller;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.spring.SpringCreator;

/**
 * @Description:
 * @author jian.yang@downjoy.com
 * @date 2014年9月30日 下午2:16:53
 * @version 1.0
 */
@RemoteProxy(name = "messagePush", creator = SpringCreator.class)
public class MessagePush
{
    @RemoteMethod
    public void message(String userId)
    {
        ScriptSession scriptSession = WebContextFactory.get()
                .getScriptSession();

        scriptSession.setAttribute(userId, userId);

      
    }
}
