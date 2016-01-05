package com.meiyun.jkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.RolePermission;
import com.meiyun.jkan.model.pk.RolePermissionPK;

/**
 * 角色-权限数据中心
 * @author larry.qi
 */
public interface RolePermissionRepository extends JpaRepository<RolePermission, RolePermissionPK> {

}
