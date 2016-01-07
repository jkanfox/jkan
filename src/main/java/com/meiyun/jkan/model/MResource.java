package com.meiyun.jkan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.meiyun.jkan.model.base.JkanAudit;

/**
 * 资源管理表：使用MResource区分Resource注解
 * @author larry.qi
 *
 */
@Entity
@Table(name = "sys_resources")
public class MResource extends JkanAudit {
	private static final long serialVersionUID = 2988039422131137959L;
	
	/**
	 * 资源类型
	 */
	@Length(max = 64)
    private String type;
    
    /**
     * 资源链接[相对路径]
     */
	@Length(max = 1024)
    private String url;
    
    /**
     * 资源ID
     */
    /*@ManyToOne(fetch = FetchType.LAZY, targetEntity = MResource.class)
    private MResource parent;*/
	private Long parent;
    
    /**
     * 资源IDs
     */
    @Length(max = 1024)
    @Column(name = "parent_ids")
    private String parentIds;
    
    /**
     * 权限
     */
    @Length(max = 128)
    private String permission;
    
	public MResource() {
		super();
	}

	public MResource(Long id) {
		super(id);
	}

	public MResource(String name) {
		super(name);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
    
}
