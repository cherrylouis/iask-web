package com.downjoy.iask.dao;

import com.downjoy.iask.dao.basedao.BaseDao;
import com.downjoy.iask.domain.Inform;

/**
 * 举报信息接口
 */
public interface InformDao extends BaseDao<Inform, Long> {

	public void uploadInformInfo(Inform inform);
	

}
