package com.meiyun.jkan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.meiyun.jkan.model.Platform;
import com.meiyun.jkan.repository.PlatformRepository;
import com.meiyun.jkan.service.PlatformService;

@Service
public class PlatformServiceImpl implements PlatformService {

	@Autowired
	private PlatformRepository pr;
	
	@Override
	public Page<Platform> findAll(Pageable pageable) {
		return pr.findAll(pageable);
	}

}
