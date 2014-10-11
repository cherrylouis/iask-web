package com.downjoy.iask.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.downjoy.iask.domain.KeyWordRelation;
import com.downjoy.iask.model.RestResult;
import com.downjoy.iask.service.KeyWordRelationService;

/**
 * @Description: 关键词联想查询
 * @author jian.yang@downjoy.com
 * @date 2014年9月2日 上午9:45:32
 * @version 1.0
 */
@Controller
@RequestMapping(value = "keyword")
public class KeyWordRelationController
{
    @Autowired()
    @Qualifier("keyWordRelationService")
    private KeyWordRelationService keyWordRelationService;

    /**
     * @Description: 查询关键字接口一：没有游戏范围，优先查询传递的关键词匹配的游戏，然后再关联关联词。
     *               如果没有匹配的游戏，就作为关键词联想查询，传递上来的关键词去匹配关键词
     * @param request
     *            请求参数
     * @param keyword
     *            关键词
     * @return RestResult 返回类型
     * @throws
     */
    @RequestMapping(value = "game", method = RequestMethod.GET)
    public @ResponseBody
    RestResult gameKeyWords(HttpServletRequest request, String keyword)
    {
        // 需要返回的数据
        List<KeyWordRelation> keys = keyWordRelationService
                .getGameKeyWords(keyword);
        RestResult restResult = new RestResult();
        restResult.setData(keys);
        return restResult;
    }

    /**
     * @Description: 查询关键字接口一：限定游戏范围，传递的查询条件匹配该游戏内的关键词，然后联想相关的关键词。
     * @param request
     *            请求参数
     * @param game
     *            游戏ID
     * @param keyword
     *            关键词
     * @return RestResult 返回类型
     * @throws
     */
    @RequestMapping(value = "keyword", method = RequestMethod.GET)
    public @ResponseBody
    RestResult gameKeyWordKeyWords(HttpServletRequest request, String game,
            String keyword)
    {
        // 需要返回的数据
        List<KeyWordRelation> keys = keyWordRelationService.getKeyWordKeyWords(
                game, keyword);

        RestResult restResult = new RestResult();
        restResult.setData(keys);
        return restResult;
    }
}
