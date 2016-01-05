package com.meiyun.jkan.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.common.base.Preconditions;
import com.meiyun.jkan.model.base.JkanBase;

/**
 * 分组
 * @author larry.qi
 */
@Entity
@Table(name = "t_groups")
public class Group extends JkanBase {

	private static final long serialVersionUID = -6791897986703261072L;
	
	/**
	 * 排序位置
	 */
	private Integer position;

	public Group() {
		super();
	}
	
	public Group(String name) {
		super(name);
	}

	public Group(Long id) {
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

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
	
}
