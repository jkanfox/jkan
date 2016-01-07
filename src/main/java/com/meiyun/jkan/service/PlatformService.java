package com.meiyun.jkan.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.meiyun.jkan.model.Platform;

/**
 * 平台服务接口
 * @author larry.qi
 */
public interface PlatformService {
	
	Page<Platform> findAll(Pageable pageable);

}
