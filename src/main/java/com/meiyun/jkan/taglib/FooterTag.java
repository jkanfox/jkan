package com.meiyun.jkan.taglib;

import java.util.Arrays;

import javax.servlet.jsp.JspException;

public class FooterTag extends AbstractTagSupport {

	private static final long serialVersionUID = 1L;
	
	private String scripts;

	@Override
	public int doStartTag() throws JspException {
		if (scripts != null) {
			addAttribute("scripts", Arrays.asList(scripts.split(";")));
		}
		
		super.render("footer.ftl");
		return super.doStartTag();
	}

	public String getScripts() {
		return scripts;
	}

	public void setScripts(String scripts) {
		this.scripts = scripts;
	}

}
