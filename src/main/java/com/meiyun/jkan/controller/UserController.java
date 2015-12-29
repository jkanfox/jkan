package com.meiyun.jkan.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.meiyun.jkan.Constants;
import com.meiyun.jkan.model.UserModel;

@Controller
@Scope(Constants.SCOPE)
@RequestMapping("/user")
public class UserController extends BaseController {
	
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
	public String login(UserModel user) {
		return "user/login";
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
	public String regist(UserModel user) {
		return "user/regist";
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
	public String forgot(UserModel user) {
		return "user/forgot";
	}

}
