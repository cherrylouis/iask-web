package com.downjoy.iask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.downjoy.iask.dao.InformDao;
import com.downjoy.iask.dao.basedao.BaseDao;
import com.downjoy.iask.domain.Inform;
import com.downjoy.iask.service.InformService;
import com.downjoy.iask.service.baseservice.BaseAbstractService;

@Service("informService")
public class InformServiceImpl extends BaseAbstractService<Inform, Long>
		implements InformService {

	@Autowired
	private InformDao informDao;

	@Override
	public void uploadInformInfo(Inform inform) {
		informDao.uploadInformInfo(inform);
	}

	@Override
	public BaseDao<Inform, Long> getDao() {
		return informDao;
	}

}
