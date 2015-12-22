package com.meiyun.jkan.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 分组
 * @author larry.qi
 */
@Entity
@Table(name = "t_group")
public class GroupModel extends JkanObject {

	private static final long serialVersionUID = -6791897986703261072L;
	
	/**
	 * 标题
	 */
	@NotNull
	private String title;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 排序位置
	 */
	private Integer position;

	public GroupModel() {
		super();
	}

	public GroupModel(Integer id) {
		super(id);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
	
}
