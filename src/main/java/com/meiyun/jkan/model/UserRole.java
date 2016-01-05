package com.meiyun.jkan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.meiyun.jkan.model.pk.UserRolePK;

/**
 * 用户-角色中间表
 * @author larry.qi
 */
@Entity
@IdClass(UserRolePK.class)
@Table(name = "sys_users_roles")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 4456986520332766408L;

	@Id
	@Column(name = "user_id")
	private Integer user;
	
	@Id
	@Column(name = "role_id")
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
