package com.downjoy.iask.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/** 
 * ParsePropertiesUtils 解析Properties文件工具类
 * @author jian.yang@downjoy.com
 * @since 0.1 
 */
public class ParsePropertiesUtils {
	
	Logger logger = Logger.getLogger(ParsePropertiesUtils.class);
	
	private static  Properties  properties = null;
	
	private ParsePropertiesUtils(){}
	
	private static class CreateInstance{
		private static ParsePropertiesUtils instance = new ParsePropertiesUtils();
	}

	public static ParsePropertiesUtils getInstance() {
		return  CreateInstance.instance;
	}
	
	/**
	 * 根据文件名解析配置文件
	 * @param fileName 属性文件名
	 */
	public void parse(String fileName) {
		
		properties = new Properties();
		
		InputStream inStream  = this.getClass().getClassLoader().getResourceAsStream(fileName);
		
		try {
			properties.load(inStream);
		} catch (IOException e) {
			logger.error("error is ocurr : "+ e.getMessage());
		}finally{
			if(inStream != null){
				try {
					inStream.close();
				} catch (IOException e) {
					logger.error("error is ocurr ,when read properties config file : "+e.getMessage()   );
				}
			}
		}
	}
	
	/**
	 * 根据属性key获取相应的value
	 * @param key 属性文件的key
	 * @return 返回key 所对应的value
	 */
	public String getValue(String key){
		if(properties == null) {
			logger.info("please invoke parse method  to load properties config file ");
			throw new NullPointerException();
		}
		return properties.getProperty(key);
	}
	
}
