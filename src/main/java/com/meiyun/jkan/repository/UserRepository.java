package com.meiyun.jkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
