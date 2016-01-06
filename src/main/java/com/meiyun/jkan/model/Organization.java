package com.meiyun.jkan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.meiyun.jkan.model.base.JkanAudit;

/**
 * 组织管理类
 * @author larry.qi
 */
@Entity
@Table(name = "sys_organizations")
public class Organization extends JkanAudit {

	private static final long serialVersionUID = -2093721689340681101L;

	/**
     * 资源ID
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    private Organization parent;
    
    /**
     * 资源IDs
     */
    @Length(max = 1024)
    @Column(name = "parent_ids")
    private String parentIds;

	public Organization() {
		super();
	}

	public Organization(Long id) {
		super(id);
	}

	public Organization(String name) {
		super(name);
	}

	public Organization getParent() {
		return parent;
	}

	public void setParent(Organization parent) {
		this.parent = parent;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

}