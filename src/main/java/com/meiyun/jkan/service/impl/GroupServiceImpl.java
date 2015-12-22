package com.meiyun.jkan.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meiyun.jkan.model.GroupModel;
import com.meiyun.jkan.repository.GroupRepository;
import com.meiyun.jkan.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {
	
	@Resource
	private GroupRepository gr;

	@Override
	public GroupModel addGroup(GroupModel group) throws Exception {
		return gr.save(group);
	}

}
