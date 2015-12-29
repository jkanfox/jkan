package com.meiyun.jkan.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.PostsModel;

/**
 * 帖子数据中心
 * @author larry.qi
 */
public interface PostsRespository extends JpaRepository<PostsModel, Integer> {

	/**
	 * 根据Title查询
	 * @param title
	 * @return
	 */
	List<PostsModel> findByTitle(String title);
	
	/**
	 * 根据GroupId查询Posts
	 * @param groupId
	 * @return
	 */
	Page<PostsModel> findPostsByGroupId(Integer groupId, Pageable pageable);
}
