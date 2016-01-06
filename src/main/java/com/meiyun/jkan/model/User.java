package com.meiyun.jkan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import com.jkanfox.jkan.boot.security.SecurityUtils;
import com.meiyun.jkan.model.base.JkanBase;

/**
 * 用户表
 * @author larry.qi
 */
@Entity
@Table(name = "sys_users")
public class User extends JkanBase {

	private static final long serialVersionUID = 7115721912538842709L;
	
	/**
	 * 用户密码
	 */
	@NotNull
	@Length(max = 64)
	private String password;

	/**
	 * 访问控制
	 */
	@NotNull
	@Length(max = 64)
	@Column(name = "access_key", updatable = false)
	private String accessKey;
	
	/**
	 * 邮箱
	 */
	@Email
	@Length(max = 64)
	private String email;
	
	/**
	 * 邮箱是否验证：0=未验证，1=通过验证
	 */
	@Column(name = "is_email_set")
	private Integer isEmailSet;

	public User() {
		super();
	}
	
	public User(Long id) {
		super(id);
	}

	/**
	 * 用户注册 构建
	 * @param name
	 * @param email
	 * @param password
	 * @param request
	 * @return
	 */
	public static User create(String name, String email, String password, HttpServletRequest request) {
		User um = new User();
		um.setName(name);
		um.setAccessKey(SecurityUtils.randomSalt());
		um.setPassword(SecurityUtils.encryptPassword(um.getAccessKey(), password));
		um.setState(1); 
		um.setTitle(name);
		um.setEmail(email);
		um.setIsEmailSet(0);
		return um;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsEmailSet() {
		return isEmailSet;
	}

	public void setIsEmailSet(Integer isEmailSet) {
		this.isEmailSet = isEmailSet;
	}
	
	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

}
