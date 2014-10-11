package com.downjoy.iask.exception;
/** 
 * BaseDaoException DAO层的基本异常类
 * @author jian.yang@downjoy.com
 * @since 0.1 
 */
@SuppressWarnings("serial")
public class BaseException extends Exception {
    /**
     * DAO层的异常类构造方法
     */
	public BaseException() {
		super();
	}
    /**
     * DAO层的异常类构造方法
     * @param message 
     * @param cause
     */
	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}
    /**
     *  DAO层的异常类构造方法
     * @param message
     */
	public BaseException(String message) {
		super(message);
	}

	/**
	 * DAO层的异常类构造方法
	 * @param cause
	 */
	public BaseException(Throwable cause) {
		super(cause);
	}

}
