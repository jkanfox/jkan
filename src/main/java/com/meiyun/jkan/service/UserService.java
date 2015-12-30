package com.meiyun.jkan.service;

import javax.transaction.Transactional;

import com.meiyun.jkan.model.UserModel;

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
	UserModel regist(UserModel user);
	
	/**
	 * 用户登录
	 * @param name
	 * @param password
	 * @return
	 */
	UserModel login(String name, String password);
	
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
	UserModel findById(Integer id);
	
	/**
	 * 更新用户 
	 * @param um
	 * @return
	 */
	UserModel updateUser(UserModel um);

}
