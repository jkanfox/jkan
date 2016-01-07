package com.meiyun.jkan.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meiyun.jkan.Constants;
import com.meiyun.jkan.admin.vo.DataGrid;
import com.meiyun.jkan.model.Label;
import com.meiyun.jkan.service.LabelService;

/**
 * 标签管理
 * @author larry.qi
 */
@Controller
@Scope(Constants.SCOPE)
@RequestMapping("/admin")
public class LabelManager {
	
	private static Logger logger = LoggerFactory.getLogger(LabelManager.class);
	
	@Autowired
	private LabelService ls;

	@RequestMapping("/labels")
	public String indexPage(Model model) {
		model.addAttribute("title", "标签管理");
		return "admin/labels/index";
	}
	
	/**
	 * 查询所有类别数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/labels/list")
	public @ResponseBody DataGrid<Label> findAll(Model model,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows) {
		Page<Label> pageInfo = ls.findLabels(new PageRequest(page-1, rows));
		return new DataGrid<Label>(pageInfo.getTotalPages(), pageInfo.getContent());
	}
}
