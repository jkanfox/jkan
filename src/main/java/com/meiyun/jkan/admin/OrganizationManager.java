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
import com.meiyun.jkan.model.Organization;
import com.meiyun.jkan.service.OrganizationService;

/**
 * 组织机构管理
 * @author larry.qi
 */
@Controller
@Scope(Constants.SCOPE)
@RequestMapping("/admin")
public class OrganizationManager {
	
	private static Logger logger = LoggerFactory.getLogger(OrganizationManager.class);
	
	@Autowired
	private OrganizationService os;

	@RequestMapping("/organizations")
	public String indexPage(Model model) {
		model.addAttribute("title", "组织机构管理");
		return "admin/organizations/index";
	}
	
	/**
	 * 查询所有组织机构数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/organizations/list")
	public @ResponseBody DataGrid<Organization> findAll(Model model,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows) {
		Page<Organization> pageInfo = os.findAll(new PageRequest(page-1, rows));
		return new DataGrid<Organization>(pageInfo.getTotalPages(), pageInfo.getContent());
	}
	
}
