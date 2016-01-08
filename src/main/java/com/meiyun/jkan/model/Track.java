package com.meiyun.jkan.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.meiyun.jkan.model.base.JkanID;

/**
 * 系统错误汇总与追踪
 * @author larry.qi
 */
@Entity
@Table(name = "sys_tracks")
public class Track extends JkanID {

	private static final long serialVersionUID = 4966003963028912216L;

	/**
	 * 异常类型
	 */
	private String exception;
	
	/**
	 * 异常对象[JSON]
	 */
	private String object;
	
	/**
	 * 发生时间：由数据库创建
	 */
	@Column(updatable = false, insertable = false)
	private Timestamp created;

	public Track() {
		super();
	}

	public Track(Long id) {
		super(id);
	}

	public Track(String exception, String object) {
		this.exception = exception;
		this.object = object;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

}
