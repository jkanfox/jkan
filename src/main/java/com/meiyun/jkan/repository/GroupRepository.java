package com.meiyun.jkan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.GroupModel;

/**
 * 分组仓库
 * @author larry.qi
 */
public interface GroupRepository extends JpaRepository<GroupModel, Integer> {

	/**
	 * 根据Title查询
	 * @param title
	 * @return
	 */
	List<GroupModel> findByTitle(String title);
}
