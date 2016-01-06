package com.meiyun.jkan.model.base;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * 所有Model的基类
 * @author larry.qi
 */
@MappedSuperclass
public abstract class JkanBase extends JkanID {

	private static final long serialVersionUID = -6958384507352480877L;
	
	/**
	 * 名称
	 */
	@NotNull()
	@Length(max = 64)
	@Column(unique = true)
	private String name;
	
	/**
	 * 标题
	 */
	@NotNull
	@Length(max = 128)
	private String title;
	
	/**
	 * 描述
	 */
	@Length(max = 1024)
	private String description;
	
	/**
	 * 状态：不同的表状态值不一样
	 */
	private Integer state;
	
	/**
	 * 创建时间：由数据库管理
	 */
	@Column(updatable = false, insertable = false)
	private Timestamp created;
	
	/**
	 * 最近更新时间：由数据库管理
	 */
	@Column(name = "last_modified", updatable = false, insertable = false)
	private Timestamp lastModified;
	
	public JkanBase(String name) {
		this.name = name;
	}

	public JkanBase(Long id) {
		super(id);
	}

	public JkanBase() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public String getTitle() {
		return title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

}
