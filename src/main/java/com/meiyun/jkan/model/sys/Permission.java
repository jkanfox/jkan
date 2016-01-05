package com.meiyun.jkan.model.sys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 系统权限表
 * @author larry.qi
 */
@Entity
@Table(name = "sys_permissions")
public class Permission implements Serializable {

	private static final long serialVersionUID = -4679084114692240390L;

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "id", length = 11)
	private Integer id;
	
	/**
	 * 权限名称
	 */
	@Column(unique = true)
	private String permission;
	
	/**
	 * 描述
	 */
	private String descritpion;
	
	/**
	 * 状态：0=不可用，1=可用（默认为：1）
	 */
	private Integer state;

	public Permission(String permission, String descritpion, Integer state) {
		this.permission = permission;
		this.descritpion = descritpion;
		this.state = state;
	}

	public Permission(Integer id) {
		this.id = id;
	}

	public Permission() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public String getPermission() {
		return permission;
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

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
}
