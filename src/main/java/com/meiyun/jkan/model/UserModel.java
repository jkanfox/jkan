package com.meiyun.jkan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 用户对象
 * 
 * @author larry.qi
 *
 */
@Entity
@Table(name = "t_user")
public class UserModel extends JkanObject {

	private static final long serialVersionUID = 7115721912538842709L;

	/**
	 * 用户昵称
	 */
	@NotNull
	private String title;

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
	private String salt;

	/**
	 * 创建IP
	 */
	@Column(updatable = false, name = "create_ip")
	private String createIp;
	
	

	public UserModel() {
		super();
	}

	public UserModel(Integer id) {
		super(id);
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

}
