package com.downjoy.iask.model;

/**
 * @author lxw
 * restful接口对外提供数据的model
 */
public class RestResult {
	private boolean flag = true;// 查询是否返回正常结果
	private String info;// 查询返回信息
	private Object data;// 真实数据

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
