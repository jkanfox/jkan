package com.meiyun.jkan.model.base;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.google.common.base.Preconditions;

/**
 * JkanID：统一管理表的ID
 * @author larry.qi
 */
@MappedSuperclass
public abstract class JkanID implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public JkanID(Long id) {
		Preconditions.checkNotNull(id);
		this.id = id;
	}

	public JkanID() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
