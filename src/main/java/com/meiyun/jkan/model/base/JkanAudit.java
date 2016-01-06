package com.meiyun.jkan.model.base;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.Length;

import com.meiyun.jkan.model.User;

/**
 * 审核信息基类
 * @author larry.qi
 */
@MappedSuperclass
public class JkanAudit extends JkanBase {

	private static final long serialVersionUID = 957990300053759337L;
	
	/**
	 * 创建用户
	 */
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
	@JoinColumn(name = "create_by")
	private User createBy;
	
	/**
	 * 审核用户ID
	 */
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
	@JoinColumn(name = "audit_by")
	private User auditBy;
	
	/**
	 * 审核说明
	 */
	@Length(max = 256)
	@Column(name = "audit_remark")
	private String auditRemark;
	
	public JkanAudit() {
		super();
	}

	public JkanAudit(Long id) {
		super(id);
	}

	public JkanAudit(String name) {
		super(name);
	}

	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

	public User getAuditBy() {
		return auditBy;
	}

	public void setAuditBy(User auditBy) {
		this.auditBy = auditBy;
	}

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

}
