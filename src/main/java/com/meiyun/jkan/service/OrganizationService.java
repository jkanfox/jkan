package com.meiyun.jkan.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.meiyun.jkan.model.Organization;

public interface OrganizationService {
	
	 public Organization createOrganization(Organization organization);

	public Organization updateOrganization(Organization organization);

	public void deleteOrganization(Long organizationId);

	Organization findOne(Long organizationId);

	Page<Organization> findAll(Pageable pageable);

	Object findAllWithExclude(Organization excludeOraganization);

	void move(Organization source, Organization target);

}
