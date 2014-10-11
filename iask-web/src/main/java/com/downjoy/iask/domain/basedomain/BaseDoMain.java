package com.downjoy.iask.domain.basedomain;

import java.lang.reflect.Field;
import java.util.Date;

public abstract class BaseDoMain {

	/**
     * 排序 升 降
     */
    private String order;
    /**
     * 排序字段
     */
    private String orderBy;
    /**
     * 排序方式
     */
    private String orderType;
    /**
     * 分页用当前页号
     */
    private Integer page = 1;
    /**
     * 总的记录数
     */
    private Long totalNum;
    /**
     * 分页用记录开始位置
     */
    private Integer startPos;
    /**
     * 分页用页面大小
     */
    private Integer pageSize = 20;

    /**
     * 记录创建时间
     */
    private String createTime;
    /**
     * 记录最后一次修改时间
     */
    private Date updateTime;
    /**
     * 创建人ID
     */
    private Integer creatorID;
    /**
     * 创建人用户名
     */
    private String creatorUserName;
    /**
     * 创建人姓名
     */
    private String creatorName;

    
    
    

    public String getOrder() {
		return order;
	}



	public void setOrder(String order) {
		this.order = order;
	}



	public String getOrderBy() {
		return orderBy;
	}



	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}



	public String getOrderType() {
		return orderType;
	}



	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}



	public Integer getPage() {
		return page;
	}



	public void setPage(Integer page) {
		this.page = page;
	}

     

	public Long getTotalNum() {
		return totalNum;
	}



	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}



	public Integer getStartPos() {
		return startPos;
	}



	public void setStartPos(Integer startPos) {
		this.startPos = startPos;
	}



	public Integer getPageSize() {
		return pageSize;
	}



	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}



	public String getCreateTime() {
		return createTime;
	}



	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}



	public Date getUpdateTime() {
		return updateTime;
	}



	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}



	public Integer getCreatorID() {
		return creatorID;
	}



	public void setCreatorID(Integer creatorID) {
		this.creatorID = creatorID;
	}



	public String getCreatorUserName() {
		return creatorUserName;
	}



	public void setCreatorUserName(String creatorUserName) {
		this.creatorUserName = creatorUserName;
	}



	public String getCreatorName() {
		return creatorName;
	}



	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}



	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Field[] fields = this.getClass().getDeclaredFields();
        try {
            for (Field f : fields) {
                f.setAccessible(true);
                builder.append(f.getName()).append(f.get(this));
            }
        } catch (Exception e) { 
            builder.append("toString builder encounter an error");
        }
        return builder.toString();
    }

}
