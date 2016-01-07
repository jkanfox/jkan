package com.meiyun.jkan.admin;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.meiyun.jkan.model.Group;
import com.meiyun.jkan.model.User;
import com.meiyun.jkan.service.GroupService;

/**
 * 类别管理
 * @author larry.qi
 */
@Controller
@Scope(Constants.SCOPE)
@RequestMapping("/admin")
public class GroupManager {
	
	private static Logger logger = LoggerFactory.getLogger(GroupManager.class);
	
	@Resource
	private GroupService gs;

	@RequestMapping("/groups")
	public String indexPage(Model model) {
		model.addAttribute("title", "类别管理");
		return "admin/groups/index";
	}
	
	/**
	 * 查询所有类别数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/groups/list")
	public @ResponseBody DataGrid<Group> findAll(Model model,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows) {
		Page<Group> pageInfo = gs.findGroups(new PageRequest(page-1, rows));
		return new DataGrid<Group>(pageInfo.getTotalPages(), pageInfo.getContent());
	}
}
