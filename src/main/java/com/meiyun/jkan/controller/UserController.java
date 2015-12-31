package com.meiyun.jkan.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Preconditions;
import com.meiyun.jkan.Constants;
import com.meiyun.jkan.Context;
import com.meiyun.jkan.model.sys.User;
import com.meiyun.jkan.service.UserService;

@Controller
@Scope(Constants.SCOPE)
@RequestMapping("/user/{id}")
public class UserController extends BaseController {
	
	static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private UserService us;
	
	/**
	 * 用户主页
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String dashboard() {
		return "user/index";
	}
	
	/**
	 * 用户设置
	 * @return
	 */
	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public String settings(@PathVariable Integer id, Model model) {
		Context c = new Context(us.findById(id));
		model.addAttribute("c", c);
		model.addAttribute("id", id);
		return "user/settings";
	}
	
	/**
	 * 用户设置
	 * @return
	 */
	@RequestMapping(value = "/settings", method = RequestMethod.POST)
	public @ResponseBody User settings(@PathVariable Integer id, User um) {
		Preconditions.checkArgument(id == um.getId());
		return us.updateUser(um);
	}

}
