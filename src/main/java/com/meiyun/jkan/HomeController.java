package com.meiyun.jkan;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.meiyun.jkan.client.Client;
import com.meiyun.jkan.model.User;
import com.meiyun.jkan.prop.JkanProp;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private JkanProp prop;
	
	@Autowired
	private Client client;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, @RequestParam String name) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		System.out.println("====================" + prop.getJkanBaseUrl());
		
		model.addAttribute("serverTime", formattedDate );
		
		// 添加用户
		User u = new User();
		u.setAddress("jkan");
		u.setCreateTime(new Date(System.currentTimeMillis()));
		u.setId(4);
		u.setPassword("jkan");
		u.setPhoneNumber("186665");
		u.setUpdateTime(new Date(System.currentTimeMillis()));
		u.setUserName(name);
		client.testAdd(u);
		
		return "home";
	}
	
}
