package com.downjoy.iask.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * DynamicSqlParameter 动态组装sql参数
 * 
 * @author jian.yang@downjoy.com
 * @since 0.1
 */
public class DynamicSqlParameter
{
    /**
     * 目前第几页
     */
    private Integer page;

    /**
     * 每页大小
     */
    private Integer size;

    /**
     * 参数集合
     */
    private Map<Object, Object> params = new HashMap<Object, Object>();

    private String orderColumn;

    private String orderTurn = "ASC";

    public String getOrderColumn()
    {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn)
    {
        this.orderColumn = orderColumn;
    }

    public String getOrderTurn()
    {
        return orderTurn;
    }

    public void setOrderTurn(String orderTurn)
    {
        this.orderTurn = orderTurn;
    }

    public Integer getPage()
    {
        return page;
    }

    public void setPage(Integer page)
    {
        this.page = page;
    }

    public Integer getSize()
    {
        return size;
    }

    public void setSize(Integer size)
    {
        this.size = size;
    }

    public Map<Object, Object> getParams()
    {
        return params;
    }

    public void setParams(Map<Object, Object> params)
    {
        this.params = params;
    }

}
