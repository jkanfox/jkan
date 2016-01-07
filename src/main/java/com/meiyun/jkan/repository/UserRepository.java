package com.meiyun.jkan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.User;

/**
 * 用户数据中心
 * @author larry.qi
 */
public interface UserRepository extends JpaRepository<User, Long>  {

	/**
	 * 根据名称或邮箱查询
	 * @param name
	 * @return
	 */
	List<User> findByName(String name);
	
	/**
	 * 根据邮箱查询用户信息
	 */
	List<User> findByEmail(String email);
	
}
