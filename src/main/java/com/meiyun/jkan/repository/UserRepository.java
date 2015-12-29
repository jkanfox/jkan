package com.meiyun.jkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.UserModel;

/**
 * 用户数据中心
 * @author larry.qi
 *
 */
public interface UserRepository extends JpaRepository<UserModel, Integer>  {

}
