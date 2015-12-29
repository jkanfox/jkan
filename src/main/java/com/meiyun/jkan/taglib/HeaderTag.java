package com.meiyun.jkan.taglib;

import javax.servlet.jsp.JspException;

/**
 * 头信息模板
 * @author larry.qi
 */
public class HeaderTag extends AbstractTagSupport {

	private static final long serialVersionUID = 4136719896030975233L;

	private String title;  // 页面标题
	private String description = ""; // 页面描述内容
	private String tags = ""; // 页面标签
	
	@Override
	public int doStartTag() throws JspException {
		addAttribute("title", title);
		addAttribute("description", description);
		addAttribute("tags", tags);
		super.render("header.ftl");
		return super.doStartTag();
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

}
