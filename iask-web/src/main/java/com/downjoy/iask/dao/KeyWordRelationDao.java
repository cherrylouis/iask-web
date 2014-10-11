package com.downjoy.iask.dao;

import java.util.List;

import com.downjoy.iask.dao.basedao.BaseDao;
import com.downjoy.iask.domain.KeyWordRelation;

/**
 * @Description: 提供关键词联想查询的数据库支持
 * @author jian.yang@downjoy.com
 * @date 2014年9月2日 上午9:50:16
 * @version 1.0
 */
public interface KeyWordRelationDao extends BaseDao<KeyWordRelation, Long>
{

    /**
     * @Description: 根据关键词查询关联的关键词
     * @param keyWord
     *            关键词
     * @return List<KeyWordRelation> 返回类型
     * @throws
     */
    public List<KeyWordRelation> getGameKeyWords(String keyWord);

    /**
     * @Description: 根据游戏获取与该游戏有关的关键词
     * @param game
     *            游戏Id
     * @param keyWord
     *            关键词
     * @return List<KeyWordRelation> 返回类型
     * @throws
     */
    public List<KeyWordRelation> getKeyWordsByLog(String game, String keyWord);

    /**
     * @Description: 根据频率获取关键词
     * @param game
     *            游戏Id
     * @param keyWord
     *            关键词
     * @return List<KeyWordRelation> 返回类型
     * @throws
     */
    public List<KeyWordRelation> getKeyWordsByFrequency(String game,
            String keyWord);

}
