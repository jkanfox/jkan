package com.meiyun.jkan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
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
	public boolean checkPost(String title) {
		Preconditions.checkNotNull(title);
		List<PostsModel> list = pr.findByTitle(title);
		return list != null && !list.isEmpty();
	}

	@Override
	public PostsModel addPosts(PostsModel posts) {
		Preconditions.checkNotNull(posts);
		Preconditions.checkArgument(posts.getId() == null);
		return pr.save(posts);
	}

	@Override
	public PostsModel updatePosts(PostsModel posts) {
		Preconditions.checkNotNull(posts);
		Preconditions.checkArgument(posts.getId() != null);
		return pr.save(posts);
	}

	@Override
	public void deletePost(Integer id) {
		Preconditions.checkNotNull(id);
		pr.delete(id);
	}
	
}
