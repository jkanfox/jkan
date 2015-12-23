package com.meiyun.jkan.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.meiyun.jkan.model.PostsModel;

/**
 * 帖子
 * @author larry.qi
 */
@Transactional
public interface PostsService {
	
	/**
	 * 查询Posts
	 * @return
	 */
	Page<PostsModel> findPosts(PageRequest pageRequest);
	
	/**
	 * 根据ID查询Posts
	 * @param id
	 * @return
	 */
	PostsModel findById(Integer id);
	
	/**
	 * 检验Posts
	 * @return
	 */
	boolean checkPost(String title);
	
	/**
	 * 添加Posts
	 * @param posts
	 * @return
	 */
	PostsModel addPosts(PostsModel posts);
	
	/**
	 * 更新Posts
	 * @param posts
	 * @return
	 */
	PostsModel updatePosts(PostsModel posts);
	
	/**
	 * 删除Posts
	 * @param id
	 */
	void deletePost(Integer id);

}
