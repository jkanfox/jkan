package com.meiyun.jkan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.meiyun.jkan.model.pk.RolePermissionPK;

/**
 * 角色-权限中间表
 * @author larry.qi
 */
@Entity
@IdClass(RolePermissionPK.class)
@Table(name = "sys_roles_permissions")
public class RolePermission implements Serializable {

	private static final long serialVersionUID = -3931241584678962936L;

	@Id
	@Column(name = "role_id")
	private Integer role;
	
	@Id
	@Column(name = "permission_id")
	private Integer permission;

	public Integer getRole() {
		return role;
	}

	public Integer getPermission() {
		return permission;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}

}
