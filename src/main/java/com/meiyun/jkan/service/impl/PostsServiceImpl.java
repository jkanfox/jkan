package com.meiyun.jkan.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.meiyun.jkan.model.PostsModel;
import com.meiyun.jkan.repository.PostsRespository;
import com.meiyun.jkan.service.PostsService;

@Service
public class PostsServiceImpl implements PostsService {
	
	@Resource
	private PostsRespository pr;

	@Override
	public Page<PostsModel> findPosts(PageRequest pageRequest) {
		return pr.findAll(pageRequest);
	}

	@Override
	public PostsModel findById(Integer id) {
		return pr.findOne(id);
	}

	@Override
	public boolean checkPost() {
		return false;
	}

	@Override
	public PostsModel addPosts(PostsModel posts) {
		return pr.save(posts);
	}

	@Override
	public PostsModel updatePosts(PostsModel posts) {
		return pr.save(posts);
	}

	@Override
	public void deletePost(Integer id) {
		pr.delete(id);
	}
	
}
