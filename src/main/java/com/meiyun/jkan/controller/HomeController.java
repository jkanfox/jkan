package com.meiyun.jkan.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meiyun.jkan.Constants;
import com.meiyun.jkan.model.Permission;
import com.meiyun.jkan.model.User;
import com.meiyun.jkan.security.CurrentUser;
import com.meiyun.jkan.service.PermissionService;
import com.meiyun.jkan.service.UserService;

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
		request.getRequestDispatcher("/users/login").forward(request, response);
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
		request.getRequestDispatcher("/users/regist").forward(request, response);
	}
	
	@Autowired  
    private PermissionService resourceService;  
    @Autowired  
    private UserService userService; 
    
    @RequestMapping("/about")  
    public String about(@CurrentUser User loginUser, Model model) {  
        Set<String> permissions = userService.findPermissions(loginUser.getName());  
        List<Permission> menus = resourceService.findMenus(permissions);  
        model.addAttribute("menus", menus);  
        return "views/about/index";  
    }  

}
