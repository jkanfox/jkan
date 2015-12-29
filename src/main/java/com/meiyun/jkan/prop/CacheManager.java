package com.meiyun.jkan.prop;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

/**
 * 缓存管理
 * @author larry.qi
 *
 */
@Component
public class CacheManager {
	
	private static Logger logger = LoggerFactory.getLogger(CacheManager.class);
	
	@Resource
	private Jkan jkan;
	
	private static Map<String, Object> _cacheMap = new HashMap<>();
	
	public static Object get(String key) {
		return _cacheMap.get(key);
	}
	
	public static Object get(String key, Object defaultValue) {
		return _cacheMap.getOrDefault(key, defaultValue);
	}

	public static void add(String key, Object value) {
		_cacheMap.put(key, value);
	}
	
	@PostConstruct
	public void init() {
		logger.info("初始化系统配置: {}", JSON.toJSONString(jkan));
		CacheManager.add("jkan", jkan);
	}

}
