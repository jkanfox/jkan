package com.meiyun.jkan.model;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.meiyun.jkan.model.base.JkanAudit;

/**
 * 贴子
 * @author larry.qi
 */
@Entity
@Table(name = "t_posts")
public class Post extends JkanAudit {

	private static final long serialVersionUID = -8211070089673828572L;
	private static Logger logger = LoggerFactory.getLogger(Post.class);
	
	/**
	 * 标签
	 */
	private String tags;
	
	/**
	 * 域名
	 */
	private String domain;
	
	/**
	 * 链接
	 */
	@NotNull
	@URL
	private String url;
	
	/**
	 * 点击率
	 */
	private Integer hit;
	
	/**
	 * 星标记[用户关注数]
	 */
	private Integer stars;
	
	/**
	 * 分组
	 */
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Group.class)
	@JoinColumn(name = "group_id")
	private Group group;
	
	/**
	 * 平台列表
	 */
	private String platforms;
	
	/**
	 * 拆分平台类型
	 */
	@Transient
	private List<Long> platformIds;
	
	public Post(String name) {
		super(name);
	}

	public Post() {
		super();
	}

	public Post(Long id) {
		super(id);
	}

	/**
	 * 创建一个Posts对象
	 * @param url
	 * @param title
	 * @param description
	 * @param tags
	 * @param groupId
	 * @return
	 */
	public static Post create(String url, String title, String description, String tags, Long groupId) {
		Preconditions.checkNotNull(url);
		Preconditions.checkNotNull(title);
		Preconditions.checkNotNull(groupId);

		Post pm = new Post();
		pm.setDescription(description);
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

	public String getDomain() {
		return domain;
	}

	public String getUrl() {
		return url;
	}

	public Integer getHit() {
		return hit;
	}

	public Integer getStars() {
		return stars;
	}

	public Group getGroup() {
		return group;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setHit(Integer hit) {
		this.hit = hit;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	public void setGroup(Long groupId) {
		this.group = new Group(groupId);
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}
	
	public List<Long> getPlatformIds() {
		try {
			if (StringUtils.isNoneBlank(platforms)) {
				String[] arr = platforms.split(",");
				Arrays.asList(arr).forEach((String s) -> 
					this.setPlatformIds(Long.valueOf(s)));
			}
		} catch (NumberFormatException e) {
			logger.warn("platformIds类型转换时报错：{}", Throwables.getStackTraceAsString(e));
		}
		return platformIds;
	}

	public void setPlatformIds(List<Long> platformIds) {
		Preconditions.checkNotNull(platformIds);
		this.platformIds = platformIds;
	}
	
	public void setPlatformIds(Long platformId) {
		Preconditions.checkNotNull(platformId);
		this.platformIds.add(platformId);
	}
	
}