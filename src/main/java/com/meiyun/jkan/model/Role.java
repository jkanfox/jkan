package com.meiyun.jkan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.meiyun.jkan.model.base.JkanID;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Entity
@Table(name = "sys_roles")
public class Role extends JkanID {
	private static final long serialVersionUID = -1987639821728908048L;
	
    private String role; //角色标识 程序中判断使用,如"admin"
    private String description; //角色描述,UI界面显示使用
    
    @Column(name = "resource_ids")
    private String resourceIds; //拥有的资源
    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户

    public Role() {
    }
    
    public Role(Long id) {
		super(id);
	}

    public Role(String role, String description, Boolean available) {
        this.role = role;
        this.description = description;
        this.available = available;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

}
