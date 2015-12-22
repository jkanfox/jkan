package com.meiyun.jkan.controller;

import java.util.UUID;

/**
 * 所有Controller的基类
 * @author larry.qi
 */
public abstract class BaseController {
	
	/**
	 * 生成一个随机的UUID
	 * @return
	 */
	public String randomUUID() {
		return UUID.randomUUID().toString();
	}

}
