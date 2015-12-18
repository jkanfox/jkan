package com.meiyun.jkan.prop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JkanProp {
	
	@Value("${jkan.base.url}") private String jkanBaseUrl;
	
	@Value("${jkan.assets.url}") private String jkanAssetsUrl;

	public String getJkanBaseUrl() {
		return jkanBaseUrl;
	}

	public void setJkanBaseUrl(String jkanBaseUrl) {
		this.jkanBaseUrl = jkanBaseUrl;
	}

	public String getJkanAssetsUrl() {
		return jkanAssetsUrl;
	}

	public void setJkanAssetsUrl(String jkanAssetsUrl) {
		this.jkanAssetsUrl = jkanAssetsUrl;
	}

}
