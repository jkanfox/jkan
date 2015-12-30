package com.meiyun.jkan.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meiyun.jkan.Constants;
import com.meiyun.jkan.Context;
import com.meiyun.jkan.model.UserModel;
import com.meiyun.jkan.service.UserService;

/**
 * 用户相关的操作：登录，注册，找回密码
 * @author larry.qi
 */
@Controller
@Scope(Constants.SCOPE)
@RequestMapping("/user")
public class UserRelationController extends BaseController {
	
	static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private UserService us;

	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody UserModel login(
			@RequestParam String name, 
			@RequestParam String password) {
		return us.login(name, password);
	}
	
	/**
	 * 用户注册
	 * @return
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String regist() {
		return "user/regist";
	}
	
	/**
	 * 用户注册
	 * @return
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public @ResponseBody UserModel regist(HttpServletRequest request,
			@RequestParam String name, 
			@RequestParam String email, 
			@RequestParam String password) {
		return us.regist(UserModel.create(name, email, password, request));
	}
	
	/**
	 * 忘记密码
	 * @return
	 */
	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public String forgot() {
		return "user/forgot";
	}
	
	/**
	 * 忘记密码
	 * @return
	 */
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public @ResponseBody Context forgot(@RequestParam String email) {
		Context c = new Context();
		if (us.checkEmail(email)) {
			c.setResult("邮件已发送");
		} else {
			c.setError("邮箱不存在");
		}
		return c;
	}
	
}
