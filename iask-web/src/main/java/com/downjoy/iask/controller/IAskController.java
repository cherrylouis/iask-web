package com.downjoy.iask.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.downjoy.iask.model.Page;
import com.downjoy.iask.model.Question;
import com.downjoy.iask.model.RestResult;
import com.downjoy.iask.service.DownjoySolrService;
import com.downjoy.iask.util.Constants;
import com.downjoy.iask.util.SolrContents;

/**
 * @author lxw 查询问答列表的接口，通过传递一个查询语句，去搜索引擎上查询
 */
@Controller
public class IAskController {
	@Autowired()
	@Qualifier("downjoySolrService")
	private DownjoySolrService downjoySolrService;

	/**
	 * 查询列表接口，传递查询条件q和分页信息，以及反向排序的字段名称，查询返回分页信息
	 * 
	 * @param request
	 * @param q
	 * @param pageNum
	 * @param pageSize
	 * @param sort
	 * @return
	 */
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public @ResponseBody
	RestResult search(HttpServletRequest request, String q, Integer pageNum,
			Integer pageSize, String sort) {
		// 处理几个查询参数
		pageNum = pageNum == null ? Constants.DEFAULT_PAGE_NUM : pageNum;
		pageSize = pageSize == null ? Constants.DEFAULT_PAGE_SIZE : pageSize;
		if (!(StringUtils.isNotEmpty(sort) && (sort
				.equals(SolrContents.Index_Fields.Q_TITLE) || sort
				.equals(SolrContents.Index_Fields.Q_DESCRIPTION)))) {
			sort = SolrContents.Index_Fields.Q_PV;
		}

		if (StringUtils.isNotEmpty(q)) {
			q = q.trim();
		}

		Page<Question> page = downjoySolrService.queryQuestion(q, null,
				pageNum, pageSize, sort);

		RestResult restResult = new RestResult();
		restResult.setData(page);
		return restResult;
	}

}
