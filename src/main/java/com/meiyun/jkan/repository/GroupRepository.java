package com.meiyun.jkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.GroupModel;

/**
 * 分组仓库
 * @author larry.qi
 */
public interface GroupRepository extends JpaRepository<GroupModel, Integer> {

}
