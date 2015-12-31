package com.meiyun.jkan.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.google.common.base.Preconditions;

/**
 * 分组
 * @author larry.qi
 */
@Entity
@Table(name = "t_group")
public class Group extends JkanObject {

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

	public Group() {
		super();
	}

	public Group(Integer id) {
		super(id);
	}
	
	/**
	 * 创建分组
	 * @param title not null
	 * @param description
	 * @return
	 */
	public static Group create(String title, String description) {
		Preconditions.checkNotNull(title, "分组名称{title}不能为空。");
		Group gm = new Group();
		gm.setDescription(description);
		gm.setPosition(0);
		gm.setTitle(title);
		gm.setState(1); // 设置状态的默认值为：1
		gm.setName(UUID.randomUUID().toString());
		return gm;
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
