package com.meiyun.jkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.UserRole;
import com.meiyun.jkan.model.pk.UserRolePK;

/**
 * 用户-角色数据中心
 * @author larry.qi
 */
public interface UserRoleRepository extends JpaRepository<UserRole, UserRolePK> {

}
