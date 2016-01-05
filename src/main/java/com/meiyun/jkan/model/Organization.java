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
@Table(name = "sys_organizations")
public class Organization extends JkanID {

	private static final long serialVersionUID = -2093721689340681101L;
    private String name; //组织机构名称
    
    @Column(name = "parent_id")
    private Long parentId; //父编号
    
    @Column(name = "parent_ids")
    private String parentIds; //父编号列表，如1/2/
    private Boolean available = Boolean.FALSE;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public boolean isRootNode() {
        return parentId == 0;
    }

    public String makeSelfAsParentIds() {
        return getParentIds() + getId() + "/";
    }

}