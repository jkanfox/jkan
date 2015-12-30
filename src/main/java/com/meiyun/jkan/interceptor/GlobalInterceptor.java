package com.meiyun.jkan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.meiyun.jkan.prop.CacheManager;
import com.meiyun.jkan.utils.SessionUtils;

@Component
public class GlobalInterceptor implements HandlerInterceptor {
	
	Logger logger = LoggerFactory.getLogger(GlobalInterceptor.class);
	
	/**
	 * 需要当前对应的Interceptor 的preHandle 方法的返回值为true 时才会执行。
	 * 顾名思义，该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。
	 * 这个方法的主要作用是用于进行资源清理工作的。
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception e)
			throws Exception {

	}

	/**
	 * 只能是在当前所属的Interceptor 的preHandle 方法的返回值为true 时才能被调用。
	 * postHandle 方法，顾名思义就是在当前请求进行处理之后，
	 * 也就是Controller 方法调用之后执行，
	 * 但是它会在DispatcherServlet 进行视图返回渲染之前被调用，
	 * 所以我们可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model)
			throws Exception {
		request.setAttribute("jkan", CacheManager.get("jkan"));
	}

	/**
	 * 在请求处理之前进行调用
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		// 设置Session
		SessionUtils.set(request.getSession());
		return true;
	}

}
