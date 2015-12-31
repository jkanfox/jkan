package com.meiyun.jkan.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.meiyun.jkan.model.Post;

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
	Page<Post> findPosts(PageRequest pageRequest);
	
	/**
	 * 根据ID查询Posts
	 * @param id
	 * @return
	 */
	Post findById(Integer id);
	
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
	Post addPosts(Post posts);
	
	/**
	 * 更新Posts
	 * @param posts
	 * @return
	 */
	Post updatePosts(Post posts);
	
	/**
	 * 删除Posts
	 * @param id
	 */
	void deletePost(Integer id);

}
