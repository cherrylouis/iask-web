package com.downjoy.iask.service;

import com.downjoy.iask.domain.Answers;
import com.downjoy.iask.service.baseservice.BaseService;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jian.yang@downjoy.com
 * @date 2014年10月8日 下午5:59:01
 * @version 1.0
 */
public interface AnswerService extends BaseService<Answers, Long>
{
    /**
     * @Description: 保存答案
     * @param answers
     * @return 设定文件
     * @return int 返回类型
     * @throws
     */
    public int insertAnswer(Answers answers);
}
