package com.meiyun.jkan.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.meiyun.jkan.model.base.JkanAudit;

/**
 * 角色表
 * 
 * @author larry.qi
 */
@Entity
@Table(name = "sys_roles")
public class Role extends JkanAudit {

	private static final long serialVersionUID = -1987639821728908048L;

	/**
	 * 权限列表
	 */
	@Length(max = 1024)
	private String permissions;

	public Role() {
		super();
	}

	public Role(Long id) {
		super(id);
	}

	public Role(String name) {
		super(name);
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

}
