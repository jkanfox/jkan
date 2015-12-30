package com.meiyun.jkan.controller;

import java.util.Enumeration;

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

import com.alibaba.fastjson.JSON;
import com.meiyun.jkan.Constants;
import com.meiyun.jkan.Context;
import com.meiyun.jkan.model.UserModel;
import com.meiyun.jkan.service.UserService;
import com.meiyun.jkan.utils.SessionUtils;

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
	public String loginPage() {
		return "user/login";
	}
	
	/**
	 * 用户登录
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Context login(
			@RequestParam String name, 
			@RequestParam String password) throws Exception {
		us.login(name, password);
		return new Context("登录成功");
	}
	
	/**
	 * 用户注册
	 * @return
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String registPage() {
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
	public String forgotPage() {
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
	
	@RequestMapping("/sessions")
	public void sessions() {
		Enumeration<String> es = SessionUtils.get().getAttributeNames();
		while (es.hasMoreElements()) {
			String string = es.nextElement();
			Object value = SessionUtils.get().getAttribute(string);
			logger.info("{}, is: {}", string, JSON.toJSONString(value) );
		}
	}
	
}
