package com.meiyun.jkan.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.meiyun.jkan.model.Label;
import com.meiyun.jkan.repository.LabelRepository;
import com.meiyun.jkan.service.LabelService;

@Service
public class LabelServiceImpl implements LabelService {
	
	@Resource
	private LabelRepository lr;

	@Override
	public Page<Label> findLabels(Pageable pageable) {
		return lr.findAll(pageable);
	}

}
