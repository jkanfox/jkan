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
import com.meiyun.jkan.model.MResource;
import com.meiyun.jkan.model.Platform;
import com.meiyun.jkan.service.PlatformService;
import com.meiyun.jkan.service.ResourceService;

/**
 * 资源权限管理
 * @author larry.qi
 */
@Controller
@Scope(Constants.SCOPE)
@RequestMapping("/admin")
public class PermissionManager {
	
	private static Logger logger = LoggerFactory.getLogger(PermissionManager.class);

	@Autowired
	private ResourceService rs;

	@RequestMapping("/permissions")
	public String indexPage(Model model) {
		model.addAttribute("title", "平台管理");
		return "admin/permissions/index";
	}
	
	/**
	 * 查询所有类别数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/permissions/list")
	public @ResponseBody DataGrid<MResource> findAll(Model model,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows) {
		Page<MResource> pageInfo = rs.findAll(new PageRequest(page-1, rows));
		return new DataGrid<MResource>(pageInfo.getTotalPages(), pageInfo.getContent());
	}
	
}
