package com.meiyun.jkan.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.meiyun.jkan.model.Label;

public interface LabelService {
	
	Page<Label> findLabels(Pageable pageable);

}
