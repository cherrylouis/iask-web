package com.downjoy.iask.exception;
/** 
 * BaseDaoException 参数异常类
 * @author jian.yang@downjoy.com
 * @since 0.1 
 */
@SuppressWarnings("serial")
public class ParameterException extends RuntimeException {
	/**
     * 参数异常类构造方法
     */
	public ParameterException() {
		super();
	}
    /**
     * 参数异常类构造方法
     * @param arg0
     * @param arg1
     */
	public ParameterException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	/**
     * 参数异常类构造方法
     * @param arg0
     */
	public ParameterException(String arg0) {
		super(arg0);
	}
	/**
     * 参数异常类构造方法
     * @param arg0
     */
	public ParameterException(Throwable arg0) {
		super(arg0);
	}
  
}
