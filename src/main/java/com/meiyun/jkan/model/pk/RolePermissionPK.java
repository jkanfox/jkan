package com.meiyun.jkan.model.pk;

import java.io.Serializable;

/**
 * 角色-权限表联合主键
 * @author larry.qi
 */
public class RolePermissionPK implements Serializable {

	private static final long serialVersionUID = 1380472599781703039L;
	
	private Integer role;
	
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
