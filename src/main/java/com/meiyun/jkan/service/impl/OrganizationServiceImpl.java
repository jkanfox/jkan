package com.meiyun.jkan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.meiyun.jkan.model.Organization;
import com.meiyun.jkan.repository.OrganizationRepository;
import com.meiyun.jkan.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository or;
	
	@Override
	public Organization createOrganization(Organization organization) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Organization updateOrganization(Organization organization) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrganization(Long organizationId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Organization findOne(Long organizationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Organization> findAll(Pageable pageable) {
		return or.findAll(pageable);
	}

	@Override
	public Object findAllWithExclude(Organization excludeOraganization) {
		return null;
	}

	@Override
	public void move(Organization source, Organization target) {
		
	}

}
