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
import com.meiyun.jkan.model.User;
import com.meiyun.jkan.service.UserService;

/**
 * 用户管理
 * @author larry.qi
 */
@Controller
@Scope(Constants.SCOPE)
@RequestMapping("/admin")
public class UserManager {
	
	private static Logger logger = LoggerFactory.getLogger(UserManager.class);
	
	@Autowired
	private UserService us;
	
	/**
	 * 用户管理
	 * @return
	 */
	@RequestMapping("/users")
	public String indexPage(Model model) {
		model.addAttribute("title", "用户管理");
		return "admin/users/index";
	}
	
	/**
	 * 查询所有用户数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/users/list")
	public @ResponseBody DataGrid<User> findAll(Model model,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows) {
		Page<User> pageInfo = us.findAll(new PageRequest(page-1, rows));
		return new DataGrid<User>(pageInfo.getTotalPages(), pageInfo.getContent());
	}

}
