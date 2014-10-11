package com.downjoy.iask.util;

/**
 * @Description: 提供和solr功能相关的一些字段
 * @author jian.yang@downjoy.com
 * @date 2014年9月3日 上午10:41:57
 * @version 1.0
 */
public interface SolrContents
{
    /**
     * solr查询的分隔标识（该字段与iask-data-config.xml查询的字段别名相对应）
     */
    public static String DOUBLE_MARKS = ":";

    public interface Index_Fields
    {
        /**
         * 问题ID
         */
        public static String Q_ID = "q_id";

        /**
         * 问题标题 （已经对问题分词)
         */
        public static String Q_TITLE = "q_title";

        /**
         * 问题标题（为对标题分词）
         */
        public static String Q_TITLE_BAK = "q_title_bak";

        /**
         * 问题的描述
         */
        public static String Q_DESCRIPTION = "q_description";

        /**
         * 问题创建的日期
         */
        public static String Q_CREATETIME = "q_createtime";

        /**
         * 答案的内容
         */
        public static String A_CONTEXT = "a_context";

        /**
         * 问题的pv值
         */
        public static String Q_PV = "q_pv";

        /**
         * 游戏的ID
         */
        public static String Q_GAMEID = "q_gameid";

        /**
         * 游戏的ID
         */
        public static String R_GAMEID = "r_gameid";

        /**
         * 游戏关键词
         */
        public static String M_KEYWORD = "m_keyword";

        /**
         * 关键词的Id
         */
        public static String R_KEYWORDID = "r_keywordid";

        /**
         * 关键词的频率
         */
        public static String R_QUENCY = "r_quency";
        
        
        public static String SUGGEST_WORD="suggest_word";
    }
}
