package com.meiyun.jkan.prop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ${jkan.properties}属性文件：系统配置
 * @author larry.qi
 */
@Component
public class Jkan {
	
	@Value("${jkan.base.url}") private String baseUrl;
	
	@Value("${jkan.assets.url}") private String assetsUrl;

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getAssetsUrl() {
		return assetsUrl;
	}

	public void setAssetsUrl(String assetsUrl) {
		this.assetsUrl = assetsUrl;
	}

}
