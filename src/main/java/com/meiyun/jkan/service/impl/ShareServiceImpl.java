package com.meiyun.jkan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.meiyun.jkan.model.Share;
import com.meiyun.jkan.repository.ShareRepository;
import com.meiyun.jkan.service.ShareService;

@Service
public class ShareServiceImpl implements ShareService {

	@Autowired
	private ShareRepository sr;
	
	@Override
	public Page<Share> findAll(Pageable pageable) {
		return sr.findAll(pageable);
	}

}
