package com.meiyun.jkan.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.common.base.Preconditions;
import com.meiyun.jkan.model.base.JkanBase;

/**
 * 用户分享表
 * @author larry.qi
 */
@Entity
@Table(name = "t_shares")
public class Share extends JkanBase {

	private static final long serialVersionUID = -8211070089673828572L;
	
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
	private Group group;
	
	public Share() {
		super();
	}
	
	public Share(Long id) {
		super(id);
	}

	/**
	 * 创建一个Share对象
	 * @param url
	 * @param title
	 * @param description
	 * @param tags
	 * @param groupId
	 * @return
	 */
	public static Share create(String url, String title, String description, String tags, Long groupId) {
		Preconditions.checkNotNull(url);
		Preconditions.checkNotNull(title);
		Preconditions.checkNotNull(groupId);

		Share pm = new Share();
		pm.setDescription(description);
		pm.setGroup(1L);
		pm.setName(UUID.randomUUID().toString());
		pm.setState(1);
		pm.setTags(tags);
		pm.setTitle(title);
		pm.setUrl(url);
		pm.setGroup(groupId);
		return pm;
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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	public void setGroup(Long id) {
		this.group = new Group(id);
	}
	
}