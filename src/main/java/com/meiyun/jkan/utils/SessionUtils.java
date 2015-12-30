package com.meiyun.jkan.utils;

import javax.servlet.http.HttpSession;

/**
 * SessionUtils：工具类
 * @author larry.qi
 */
public class SessionUtils {
	
	private static ThreadLocal<HttpSession> _theadLocal = new ThreadLocal<>();
	
	private SessionUtils() {}

	/**
	 * 获取Session
	 * @return
	 */
	public static HttpSession get() {
		return _theadLocal.get();
	}
	
	/**
	 * 获取Session并设置有效期
	 * @param interval ms
	 * @return
	 */
	public static HttpSession get(int interval) {
		HttpSession session = _theadLocal.get();
		session.setMaxInactiveInterval(interval);
		return session;
	}
	
	/**
	 * 获取对象
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		return get().getAttribute(key);
	}

	public static void set(HttpSession session) {
		_theadLocal.set(session);
	}
	
	/**
	 * 添加Session
	 * @param key
	 * @param value
	 */
	public static void add(String key, Object value) {
		get().setAttribute(key, value);
	}
	
	/**
	 * 添加Session
	 * @param key
	 * @param value
	 * @param interval
	 */
	public static void add(String key, Object value, int interval) {
		get(interval).setAttribute(key, value);
	}
	
	/**
	 * 移除Session
	 * @param key
	 */
	public static void remove(String key) {
		get().removeAttribute(key);
	}

}
