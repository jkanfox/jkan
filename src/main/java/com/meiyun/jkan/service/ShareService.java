package com.meiyun.jkan.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.meiyun.jkan.model.Share;

public interface ShareService {
	
	Page<Share> findAll(Pageable pageable);

}
