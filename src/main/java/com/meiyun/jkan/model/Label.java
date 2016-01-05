package com.meiyun.jkan.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.meiyun.jkan.model.base.JkanBase;

/**
 * 标签管理表
 * @author larry.qi
 */
@Entity
@Table(name = "t_labels")
public class Label extends JkanBase {

	private static final long serialVersionUID = -2506648035186466395L;

	public Label() {
		super();
	}

	public Label(Long id) {
		super(id);
	}

	public Label(String name) {
		super(name);
	}

}
