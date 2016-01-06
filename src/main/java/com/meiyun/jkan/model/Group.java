package com.meiyun.jkan.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.google.common.base.Preconditions;
import com.meiyun.jkan.model.base.JkanAudit;

/**
 * 分组
 * @author larry.qi
 */
@Entity
@Table(name = "t_groups")
public class Group extends JkanAudit {

	private static final long serialVersionUID = -6791897986703261072L;
	
	/**
	 * 星标记 [用户关注数]
	 */
	private Integer stars;
	
	/**
	 * 统计Posts数量
	 */
	private Integer count;
	
	/**
	 * 父ID
	 */
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Group.class)
	@JoinColumn(name = "parent")
	private Group parent;
	
	/**
	 * 父IDs
	 */
	@Length(max = 1024)
	@Column(name = "parent_ids")
	private String parentIds;
	
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
		gm.setTitle(title);
		gm.setState(1); // 设置状态的默认值为：1
		gm.setName(UUID.randomUUID().toString());
		return gm;
	}

	public Integer getStars() {
		return stars;
	}

	public Integer getCount() {
		return count;
	}

	public Group getParent() {
		return parent;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setParent(Group parent) {
		this.parent = parent;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

}
