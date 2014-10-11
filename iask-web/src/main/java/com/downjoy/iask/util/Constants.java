package com.downjoy.iask.util;

/**
 * @Description: 常量类
 * @author jian.yang@downjoy.com
 * @date 2014年10月11日 下午4:07:02
 * @version 1.0
 */
public interface Constants
{

    /**
     * 每页的大小数据记录数
     */
    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 默认的当前页
     */
    public static final int DEFAULT_PAGE_NUM = 1;

    /**
     * 当前用户
     */
    public static final String CURRENT_SESSION_USER = "currentSessionUser";

    /**
     * 当前用户ID
     */
    public static final String CURRENT_USER_ID = "currentUserId";

    /**
     * dwr sessionID
     */
    public static final String SCRIPT_SESSION_ID = "DWR_ScriptSession_Id";

    /**
     * 推送问题
     */
    public static final String QUESTION_PUSH_TYPE = "q";

    /**
     * 推送答案
     */
    public static final String ANSWER_PUSH_TYPE = "a";

    /**
     * 向所有的用户推送信息
     */
    public static final String PUSH_ALL_USER = "1";

    /**
     * 向特定用户推送消息
     */
    public static final String PUSH_SPECIAL_USER = "2";
    
}
