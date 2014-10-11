package com.downjoy.iask.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.downjoy.iask.dao.KeyWordRelationDao;
import com.downjoy.iask.dao.basedao.BaseDao;
import com.downjoy.iask.domain.KeyWordRelation;
import com.downjoy.iask.service.KeyWordRelationService;
import com.downjoy.iask.service.baseservice.BaseAbstractService;

/**
 * @author lxw KeyWordRelationService 的实现，
 */
@Service("keyWordRelationService")
public class KeyWordRelationServiceImpl extends
		BaseAbstractService<KeyWordRelation, Long> implements
		KeyWordRelationService {
	@Autowired
	private KeyWordRelationDao keyWordRelationDao;

	/**
	 * 获取关键词两项接口一：未指定游戏范围查询
	 * 
	 * @param game
	 * @return
	 */
	public List<KeyWordRelation> getGameKeyWords(String keyWord) {
		return keyWordRelationDao.getGameKeyWords(keyWord);
	}

	/**
	 * /** 获取关键词两项接口二：指定游戏范围查询
	 * 
	 * @param game
	 * @return
	 */
	public List<KeyWordRelation> getKeyWordKeyWords(String game, String keyWord) {
		if (StringUtils.isEmpty(game)) {
			return null;
		}
		List<KeyWordRelation> list = keyWordRelationDao.getKeyWordsByLog(game,
				keyWord);

		if (list == null || list.size() < 1) {
			list = keyWordRelationDao.getKeyWordsByFrequency(game, keyWord);
		}

		return list;
	}

	@Override
	public BaseDao<KeyWordRelation, Long> getDao() {
		return keyWordRelationDao;
	}
}
