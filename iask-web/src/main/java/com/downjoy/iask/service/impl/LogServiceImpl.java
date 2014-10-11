package com.downjoy.iask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.downjoy.iask.dao.LogCatDao;
import com.downjoy.iask.dao.basedao.BaseDao;
import com.downjoy.iask.domain.Log;
import com.downjoy.iask.service.LogService;
import com.downjoy.iask.service.baseservice.BaseAbstractService;

@Service("logService")
public class LogServiceImpl extends BaseAbstractService<Log, Long>
		implements LogService {

	@Autowired
	@Qualifier("logCatDao")
	private LogCatDao logCatDao;

	@Override
	public BaseDao<Log, Long> getDao() {
		return logCatDao;
	}

}
