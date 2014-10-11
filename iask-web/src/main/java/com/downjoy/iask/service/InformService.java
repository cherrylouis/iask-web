package com.downjoy.iask.service;

import com.downjoy.iask.domain.Inform;
import com.downjoy.iask.service.baseservice.BaseService;

public interface InformService extends BaseService<Inform, Long> {

	public void uploadInformInfo(Inform inform);

}
