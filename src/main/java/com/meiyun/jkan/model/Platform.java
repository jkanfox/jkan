package com.meiyun.jkan.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 平台管理表
 * @author larry.qi
 */
@Entity
@Table(name = "t_platforms")
public class Platform extends JkanObject {

	private static final long serialVersionUID = -2506648035186466395L;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 描述
	 */
	private String description;
	
	public Platform() {
		super();
	}

	public Platform(Integer id) {
		super(id);
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
