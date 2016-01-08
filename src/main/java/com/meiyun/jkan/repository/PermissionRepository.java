package com.meiyun.jkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.Permission;

/**
 * 权限管理数据中心
 * @author larry.qi
 *
 */
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
