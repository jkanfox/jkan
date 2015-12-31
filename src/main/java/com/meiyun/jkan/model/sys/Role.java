package com.meiyun.jkan.model.sys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 系统角色
 * @author larry.qi
 */
@Entity
@Table(name = "sys_roles")
public class Role implements Serializable {
	
	private static final long serialVersionUID = -1991923584760619953L;

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "id", length = 11)
	private Integer id;
	
	/**
	 * 角色名称
	 */
	@Column(unique = true)
	private String role;
	
	/**
	 * 描述
	 */
	private String descritpion;
	
	/**
	 * 状态：0=不可用，1=可用（默认为：1）
	 */
	private Integer state;
	
	public Role(String role, String descritpion, Integer state) {
		this.role = role;
		this.descritpion = descritpion;
		this.state = state;
	}

	public Role(Integer id) {
		this.id = id;
	}

	public Role() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public String getDescritpion() {
		return descritpion;
	}

	public Integer getState() {
		return state;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
}
