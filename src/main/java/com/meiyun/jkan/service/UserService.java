package com.meiyun.jkan.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.meiyun.jkan.model.User;

/**
 * 用户 服务
 * 
 * @author larry.qi
 *
 */
@Transactional
public interface UserService {

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	User regist(User user);

	/**
	 * 用户登录
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	void login(String name, String password) throws Exception;

	/**
	 * 校验邮箱
	 * 
	 * @param email
	 * @return
	 */
	boolean checkEmail(String email);

	/**
	 * 根据ID找寻用户
	 * 
	 * @param id
	 * @return
	 */
	User findById(Long id);

	/**
	 * 更新用户
	 * 
	 * @param um
	 * @return
	 */
	User updateUser(User um);

	/**
	 * 查询用户
	 * 
	 * @param name
	 * @return
	 */
	User findByName(String name);

	/**
	 * 创建用户
	 * 
	 * @param user
	 */
	public User createUser(User user);

	public void deleteUser(Long userId);

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(Long userId, String newPassword);

	User findOne(Long userId);
	
	/**
	 * 查询所有用户
	 * @param pageable
	 * @return
	 */
	Page<User> findAll(Pageable pageable);

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);

	/**
	 * 根据用户名查找其角色
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findRoles(String username);

	/**
	 * 根据用户名查找其权限
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findPermissions(String username);

}
