package com.meiyun.jkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.Organization;

/**
 * 组织机构数据中心
 * @author larry.qi
 *
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
