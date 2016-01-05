package com.meiyun.jkan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.jkanfox.jkan.boot.security.SecurityUtils;
import com.meiyun.jkan.utils.RequestUtils;

/**
 * 用户表
 * @author larry.qi
 */
@Entity
@Table(name = "sys_users")
public class User extends JkanObject {

	private static final long serialVersionUID = 7115721912538842709L;

	/**
	 * 用户昵称
	 */
	@NotNull
	private String title;
	
	/**
	 * 邮箱
	 */
	@Email
	private String email;
	
	/**
	 * 邮箱是否验证：0=未验证，1=通过验证
	 */
	@Column(name = "is_email_set")
	private Integer isEmailSet;

	/**
	 * 用户描述
	 */
	private String description;

	/**
	 * 用户密码
	 */
	@NotNull
	private String password;

	/**
	 * 盐：密码盐
	 */
	@NotNull
	@Column(updatable = false)
	private String salt;

	/**
	 * 创建IP
	 */
	@Column(updatable = false, name = "create_ip")
	private String createIp;

	public User() {
		super();
	}

	public User(Integer id) {
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
		um.setCreateIp(RequestUtils.getIpAddr(request));
		um.setName(name);
		um.setSalt(SecurityUtils.randomSalt());
		um.setPassword(SecurityUtils.encryptPassword(um.getSalt(), password));
		um.setState(1); 
		um.setTitle(name);
		um.setEmail(email);
		um.setIsEmailSet(0);
		return um;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCreateIp() {
		return createIp;
	}

	public void setCreateIp(String createIp) {
		this.createIp = createIp;
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
	
	public String getCredentialsSalt() {
        return super.getName() + salt;
    }

}
