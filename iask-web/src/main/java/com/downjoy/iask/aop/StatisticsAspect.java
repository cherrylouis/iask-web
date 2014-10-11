package com.downjoy.iask.aop;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.downjoy.iask.domain.Questions;
import com.downjoy.iask.service.QuestionService;

/**
 * 页面点击拦截器
 */
@Aspect
public class StatisticsAspect {

	private static final int MAX_SIZE = 10;

	@Autowired
	private QuestionService questionService;

	private static Map<String, Integer> map = new ConcurrentHashMap<String, Integer>();

	public static final String EDP = "execution(* com.downjoy.iask.service.impl.DownjoySolrServiceImpl.*(..))";

	@Around(EDP)
	public Object logAround(ProceedingJoinPoint joinPoint) {

		Object[] args = joinPoint.getArgs();
		Object obj = null;
		try {
			obj = joinPoint.proceed(args);

			if (args.length == 1) {
				String questionId = (String) args[0];
				if (!map.containsKey(questionId)) {
					map.put(questionId, 1);
				} else {
					int num = map.get(questionId);
					map.put(questionId, num + 1);

					// 当满足条件才进行进行数据插入
					if (num > MAX_SIZE) {

						Questions questions = new Questions();
						questions.setId(Long.valueOf(questionId));

						int queryNum = questionService
								.queryBrowseNum(questions);

						int countNum = map.get(questionId);

						int browseNum = (int) (countNum + Long
								.valueOf(queryNum));

						questions.setQuestionBrowseNum(String
								.valueOf(browseNum));

						questionService.update(questions);

						map.put(questionId, 0);
					}
				}

			}

		} catch (Throwable e) {
			e.printStackTrace();
		}

		return obj;
	}

}
