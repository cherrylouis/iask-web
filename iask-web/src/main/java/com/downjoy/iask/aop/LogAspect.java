package com.downjoy.iask.aop;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.downjoy.iask.domain.KeyWordRelation;
import com.downjoy.iask.domain.Log;
import com.downjoy.iask.service.LogService;

/**
 * 日志记录拦截
 */
@Aspect
public class LogAspect {

	private static Set<Log> logs = new HashSet<Log>();

	private static int MAX_SIZE = 100;

	@Autowired
	private LogService logService;

	public static final String EDP = "execution(* com.downjoy.iask.service.impl.KeyWordRelationServiceImpl.*(..))";

	// 拦截用户调用搜索接口
	@SuppressWarnings("unchecked")
	@Around(EDP)
	public Object logAround(ProceedingJoinPoint joinPoint) {

		Object[] args = joinPoint.getArgs();
		Object obj = null;
		try {
			System.out.println(args[0]);
			obj = joinPoint.proceed(args);

			if (obj != null) {
				List<KeyWordRelation> list = (List<KeyWordRelation>) obj;

				Log log = new Log();

				if (args.length == 1) {

					String value = String.valueOf(args[0]);
					if (!isNumeric(value)) {
						log.setLogSearchKey(value);
					} else {
						log.setGameId(value);
					}

				} else if (args.length == 2) {

					String firstValue = String.valueOf(args[0]);
					String scValue = String.valueOf(args[1]);

					if (!isNumeric(firstValue)) {
						log.setLogSearchKey(firstValue);
					} else {
						log.setGameId(firstValue);
					}

					if (!isNumeric(scValue)) {
						log.setLogSearchKey(scValue);
					} else {
						log.setGameId(scValue);
					}
				}

				log.setLogCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:ss")
						.format(new Date()));
				log.setLogSearchResultNum(String.valueOf(list.size()));

				if (log.getLogSearchKey() != null)
					logs.add(log);

				if (logs.size() > MAX_SIZE) {
					Iterator<Log> iter = logs.iterator();
					while (iter.hasNext()) {
						logService.insert(iter.next());
					}
					logs.clear();
				}

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}

	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			int chr = str.charAt(i);
			if (chr < 48 || chr > 57)
				return false;
		}
		return true;
	}
}
