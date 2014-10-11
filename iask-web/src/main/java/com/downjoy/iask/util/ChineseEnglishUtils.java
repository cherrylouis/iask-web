package com.downjoy.iask.util;

import org.apache.log4j.Logger;

/**
 * @Description: 判断判断字符串是否为纯英文
 * @author jian.yang@downjoy.com
 * @date 2014年9月3日 下午5:06:06
 * @version 1.0
 */
public class ChineseEnglishUtils
{

    private ChineseEnglishUtils()
    {

    }

    private static class CreateInstance
    {
        private static ChineseEnglishUtils instance = new ChineseEnglishUtils();
    }

    /**
     * @Description: 创建实例方法
     * @return ChineseEnglishUtils 返回类型
     * @throws
     */
    public static ChineseEnglishUtils getInstance()
    {
        return CreateInstance.instance;
    }

    /**
     * @Description: 字符串是否为纯英文（这里不考虑特殊字符）
     * @param str
     * @return Boolean 返回类型
     * @throws
     */
    public Boolean isEnglish(String str)
    {
        Boolean flag = true;
        char[] array = str.toCharArray();
        int chineseCount = 0;
        for (int i = 0; i < array.length; i++)
        {
            if ((char) (byte) array[i] != array[i])
            {
                chineseCount++;
            }

        }

        if (chineseCount != 0)
        {
            flag = false;
        }

        return flag;
    }
}
