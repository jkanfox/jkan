package com.meiyun.jkan.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.meiyun.jkan.model.Permission;
import com.meiyun.jkan.repository.PermissionRepository;
import com.meiyun.jkan.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionRepository rr;
	
	@Override
	public Permission createResource(Permission resource) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Permission updateResource(Permission resource) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteResource(Long resourceId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Permission findOne(Long resourceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Permission> findAll(Pageable pageable) {
		return rr.findAll(pageable);
	}

	@Override
	public Set<String> findPermissions(Set<Long> resourceIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permission> findMenus(Set<String> permissions) {
		// TODO Auto-generated method stub
		return null;
	}

}
