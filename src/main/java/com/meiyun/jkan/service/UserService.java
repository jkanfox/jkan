package com.meiyun.jkan.service;

import javax.transaction.Transactional;

import com.meiyun.jkan.model.sys.User;

/**
 * 用户 服务
 * @author larry.qi
 *
 */
@Transactional
public interface UserService {
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	User regist(User user);
	
	/**
	 * 用户登录
	 * @param name
	 * @param password
	 * @return
	 */
	void login(String name, String password) throws Exception;
	
	/**
	 * 校验邮箱
	 * @param email
	 * @return
	 */
	boolean checkEmail(String email);
	
	/**
	 * 根据ID找寻用户
	 * @param id
	 * @return
	 */
	User findById(Integer id);
	
	/**
	 * 更新用户 
	 * @param um
	 * @return
	 */
	User updateUser(User um);
	
	/**
	 * 查询用户 
	 * @param name
	 * @return
	 */
	User findByName(String name);

}
