package com.meiyun.jkan.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

/**
 * 所有Model的基类
 * @author larry.qi
 */
@MappedSuperclass
public class JkanObject implements Serializable {

	private static final long serialVersionUID = -6958384507352480877L;
	
	/**
	 * ID
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "id", length = 11)
	private Integer id;
	
	/**
	 * 名称
	 */
	@NotNull
	private String name;
	
	/**
	 * 状态 [默认 1=可用，0=不可用]
	 */
	private Integer state;
	
	/**
	 * 创建时间
	 */
	@Column(updatable = false)
	private Timestamp created;
	
	/**
	 * 最近更新时间
	 */
	@Column(name = "last_modified", updatable = false)
	private Timestamp lastModified;
	
	public JkanObject(Integer id) {
		this();
		this.id = id;
	}

	public JkanObject() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
