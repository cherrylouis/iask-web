package com.downjoy.iask.aop;

import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.downjoy.iask.domain.KeyWords;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.service.KeyWordsRateService;
import com.downjoy.iask.util.IKAnalzyerUtil;

/**
 * @Description: 用户查询，更新关键词列表的频度
 * @author jian.yang@downjoy.com
 * @date 2014年9月1日 下午6:00:02
 * @version 1.0
 */
@Aspect
public class RequestSearchInterceptor
{

    Logger logger = Logger.getLogger(RequestSearchInterceptor.class);

    @Autowired
    @Qualifier("keyWordsRateService")
    private KeyWordsRateService keyWordsRateService;

    /**
     * @Description: 定义切入点
     * @return void 返回类型
     * @throws
     */
    @Pointcut("execution(* com.downjoy.iask.service.impl.RequestSolrSearchServiceImpl.searchResult(..))")
    private void anyMethod()
    {
    }// 定义一个切入点

    /**
     * @Description: 前置通知方法
     * @param joinPoint
     *            设定文件
     * @return void 返回类型
     * @throws
     */
    @Before("anyMethod()")
    public void addKeyWordsRate(ProceedingJoinPoint joinPoint)
    {
        Object[] args = joinPoint.getArgs();// 2.传参
        String param = (String) args[0];
        // TODO 分词算法
        List<KeyWords> list = IKAnalzyerUtil.getTerm(param);
        if (list != null && !list.isEmpty())
        {
            for (KeyWords keyWord : list)
            {
                KeyWords keyWords = new KeyWords();
                keyWords.setKeyWords(keyWord.getKeyWords());
                try
                {
                    keyWordsRateService.update(keyWords);
                }
                catch(BaseException e)
                {
                    logger.error("用户查询，更新关键词列表的频度错误 " + e.getMessage());
                }
            }
        }
    }

}
