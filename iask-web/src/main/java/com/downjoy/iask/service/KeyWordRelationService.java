package com.downjoy.iask.service;

import java.util.List;

import com.downjoy.iask.domain.KeyWordRelation;
import com.downjoy.iask.service.baseservice.BaseService;

/**
 * @Description: 关键词查询接口（数据源是数据库而非solr索引库）
 * @author jian.yang@downjoy.com
 * @date 2014年9月2日 上午8:57:55
 * @version 1.0
 */
public interface KeyWordRelationService extends
        BaseService<KeyWordRelation, Long>
{

    /**
     * @Description: 获取关键词两项接口一：未指定游戏范围查询
     * @param keyword
     *            关键词
     * @return List<KeyWordRelation> 返回类型
     * @throws
     */
    public List<KeyWordRelation> getGameKeyWords(String keyword);

    /**
     * @Description: 获取关键词两项接口二：指定游戏范围查询
     * @param gameId
     *            游戏ID
     * @param keyword
     *            关键词
     * @return List<KeyWordRelation> 返回类型
     * @throws
     */
    public List<KeyWordRelation> getKeyWordKeyWords(String gameId,
            String keyword);
}
