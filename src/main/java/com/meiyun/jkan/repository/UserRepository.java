package com.meiyun.jkan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.UserModel;

/**
 * 用户数据中心
 * @author larry.qi
 */
public interface UserRepository extends JpaRepository<UserModel, Integer>  {

	/**
	 * 根据名称或邮箱查询
	 * @param name
	 * @return
	 */
	List<UserModel> findByName(String name);
	
	/**
	 * 根据邮箱查询用户信息
	 */
	List<UserModel> findByEmail(String email);
	
}
