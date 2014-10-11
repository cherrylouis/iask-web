package com.downjoy.iask.domain;

/**
 * @Description: 返回客服端的关键词类
 * @author jian.yang@downjoy.com
 * @date 2014年9月3日 上午10:32:35
 * @version 1.0
 */
public class ResponseKeyWord
{
    /**
     * 关键词的Id
     */
    private String keyWordId;

    /**
     * 关键词
     */
    private String keyWord;

    /**
     * 关键词的使用频率
     */
    private String frequency;

    public String getKeyWordId()
    {
        return keyWordId;
    }

    public void setKeyWordId(String keyWordId)
    {
        this.keyWordId = keyWordId;
    }

    public String getKeyWord()
    {
        return keyWord;
    }

    public void setKeyWord(String keyWord)
    {
        this.keyWord = keyWord;
    }

    public String getFrequency()
    {
        return frequency;
    }

    public void setFrequency(String frequency)
    {
        this.frequency = frequency;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((frequency == null) ? 0 : frequency.hashCode());
        result = prime * result + ((keyWord == null) ? 0 : keyWord.hashCode());
        result = prime * result
                + ((keyWordId == null) ? 0 : keyWordId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ResponseKeyWord other = (ResponseKeyWord) obj;
        if (frequency == null)
        {
            if (other.frequency != null)
                return false;
        }
        else if (!frequency.equals(other.frequency))
            return false;
        if (keyWord == null)
        {
            if (other.keyWord != null)
                return false;
        }
        else if (!keyWord.equals(other.keyWord))
            return false;
        if (keyWordId == null)
        {
            if (other.keyWordId != null)
                return false;
        }
        else if (!keyWordId.equals(other.keyWordId))
            return false;
        return true;
    }

    
}
