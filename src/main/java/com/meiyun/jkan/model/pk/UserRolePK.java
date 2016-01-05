package com.meiyun.jkan.model.pk;

import java.io.Serializable;

/**
 * 用户-角色表联合主键
 * @author larry.qi
 *
 */
public class UserRolePK implements Serializable {

	private static final long serialVersionUID = -8994913996902633201L;
	
	private Integer user;
	
	private Integer role;

	public Integer getUser() {
		return user;
	}

	public Integer getRole() {
		return role;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

}
