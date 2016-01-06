package com.meiyun.jkan.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.meiyun.jkan.model.MResource;
import com.meiyun.jkan.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

	@Override
	public MResource createResource(MResource resource) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MResource updateResource(MResource resource) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteResource(Long resourceId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MResource findOne(Long resourceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MResource> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> findPermissions(Set<Long> resourceIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MResource> findMenus(Set<String> permissions) {
		// TODO Auto-generated method stub
		return null;
	}

}
