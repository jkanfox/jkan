package com.meiyun.jkan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meiyun.jkan.Constants;

/**
 * Home
 * @author larry.qi
 */
@Controller
@Scope(Constants.SCOPE)
public class HomeController extends BaseController {
	
	/**
	 * 首页
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/")
	public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/posts").forward(request, response);
	}
	
	/**
	 * 用户登录页
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/user/login").forward(request, response);
	}
	
	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/regist")
	public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/user/regist").forward(request, response);
	}

}
