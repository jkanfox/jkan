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
@Table(name = "sys_resources")
public class Resource extends JkanID {
	private static final long serialVersionUID = 2988039422131137959L;
	
    private String name; //资源名称
    private ResourceType type = ResourceType.menu; //资源类型
    private String url; //资源路径
    private String permission; //权限字符串
    
    @Column(name = "parent_id")
    private Long parentId; //父编号
    
    @Column(name = "parent_ids")
    private String parentIds; //父编号列表
    private Boolean available = Boolean.FALSE;

    public static enum ResourceType {
        menu("菜单"), button("按钮");

        private final String info;
        private ResourceType(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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
