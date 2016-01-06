package com.meiyun.jkan.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.meiyun.jkan.model.base.JkanAudit;

/**
 * 用户分享表
 * @author larry.qi
 */
@Entity
@Table(name = "t_shares")
public class Share extends JkanAudit {

	private static final long serialVersionUID = -8211070089673828572L;
	private static Logger logger = LoggerFactory.getLogger(Share.class);
	
	/**
	 * 关键词
	 */
	@Length(max = 256)
	private String keywords;
	
	/**
	 * 域名
	 */
	@Length(max = 128)
	private String domain;
	
	/**
	 * 链接
	 */
	@NotNull
	@URL
	@Length(max = 1024)
	private String url;
	
	/**
	 * 分组
	 */
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Group.class)
	@JoinColumn(name = "group_id")
	private Group group;
	
	/**
	 * 平台列表
	 */
	@Length(max = 1024)
	private String platforms;
	
	/**
	 * 拆分平台类型
	 */
	@Transient
	private List<Long> platformIds;
	
	public Share() {
		platformIds = new ArrayList<>();
	}

	public Share(Long id) {
		super(id);
	}

	public Share(String name) {
		super(name);
	}

	public String getKeywords() {
		return keywords;
	}

	public String getDomain() {
		return domain;
	}

	public String getUrl() {
		return url;
	}

	public Group getGroup() {
		return group;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getPlatforms() {
		return platforms;
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