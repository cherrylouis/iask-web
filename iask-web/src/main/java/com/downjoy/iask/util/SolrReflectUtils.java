package com.downjoy.iask.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

/**
 * 传人参数工具类
 * 
 * @author jian.yang@downjoy.com
 * @version 1.0
 */
public class SolrReflectUtils {

	public static Map<String, String> getSearchProperty(Object model)
			throws NoSuchMethodException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Map<String, String> resultMap = new TreeMap<String, String>();

		Field[] field = model.getClass().getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			String name = field[i].getName();
			String type = field[i].getGenericType().toString();
			if (type.equals("class java.lang.String")) {
				Method m = model.getClass().getMethod(
						"get" + UpperCaseField(name));
				String value = (String) m.invoke(model);
				if (value != null) {
					resultMap.put(name, value);
				}

			}
		}
		return resultMap;
	}

	private static String UpperCaseField(String fieldName) {
		fieldName = fieldName.replaceFirst(fieldName.substring(0, 1), fieldName
				.substring(0, 1).toUpperCase());
		return fieldName;
	}

}
