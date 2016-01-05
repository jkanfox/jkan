package com.meiyun.jkan.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.meiyun.jkan.model.base.JkanBase;

/**
 * 平台管理表
 * @author larry.qi
 */
@Entity
@Table(name = "t_platforms")
public class Platform extends JkanBase {

	private static final long serialVersionUID = -2506648035186466395L;

	public Platform() {
		super();
	}

	public Platform(Long id) {
		super(id);
	}

	public Platform(String name) {
		super(name);
	}

}
