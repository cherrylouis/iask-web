package com.downjoy.iask.service;

import com.downjoy.iask.domain.Questions;
import com.downjoy.iask.service.baseservice.BaseService;

/** 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author jian.yang@downjoy.com
 * @date 2014年9月9日 下午4:03:13 
 * @version 1.0 
 */
public interface GameQuestionService extends BaseService<Questions, Long>
{
    public int searchQuestionByGameId(String gameId);
}
