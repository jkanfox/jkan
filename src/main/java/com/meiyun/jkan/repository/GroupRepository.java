package com.meiyun.jkan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.Group;

/**
 * 类别数据中心
 * @author larry.qi
 */
public interface GroupRepository extends JpaRepository<Group, Long> {

	/**
	 * 根据Title查询
	 * @param title
	 * @return
	 */
	List<Group> findByTitle(String title);
}
