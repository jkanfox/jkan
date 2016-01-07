package com.meiyun.jkan.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.meiyun.jkan.model.Role;
import com.meiyun.jkan.repository.RoleRepository;
import com.meiyun.jkan.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository rr;
	
	@Override
	public Role createRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role updateRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRole(Long roleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role findOne(Long roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Role> findAll(Pageable pageable) {
		return rr.findAll(pageable);
	}

	@Override
	public Set<String> findRoles(Long... roleIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> findPermissions(Long[] roleIds) {
		// TODO Auto-generated method stub
		return null;
	}

}
