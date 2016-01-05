package com.meiyun.jkan;

/**
 * 系统常量设置
 * @author larry.qi
 */
public interface Constants {
	
	/**
	 * 设置Controller请求Scope
	 */
	public String SCOPE = "prototype";
	
	/**
	 * 系统字符集
	 */
	public String CHARSET = "UTF-8";
	
	/**
	 * FreeMarker模块路径
	 */
	public String FM_TEMPLATE_PATH = "/WEB-INF/templates/";
	
	/**
	 * 登录用户授权
	 */
	public String AUTH_USER = "authuser";
	
	/**
	 * 当前登录用户
	 */
	public String CURRENT_USER = "user";

}
