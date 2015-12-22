package com.meiyun.jkan.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 贴子
 * @author larry.qi
 */
@Entity
@Table(name = "t_posts")
public class PostsModel extends JkanObject {

	private static final long serialVersionUID = -8211070089673828572L;
	
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
	 * 标签
	 */
	private String tags;
	
	/**
	 * 链接
	 */
	private String url;
	
	/**
	 * 分组
	 */
	@ManyToOne
	@JoinColumn(name = "group_id")
	private GroupModel group;
	
	public PostsModel() {
		super();
	}

	public PostsModel(Integer id) {
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

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public GroupModel getGroup() {
		return group;
	}

	public void setGroup(GroupModel group) {
		this.group = group;
	}
	
	public void setGroup(Integer id) {
		this.group = new GroupModel(id);
	}
	
}