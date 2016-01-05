package com.meiyun.jkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.Role;

/**
 * 角色数据中心
 * @author larry.qi
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
