package com.meiyun.jkan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.meiyun.jkan.model.Post;
import com.meiyun.jkan.repository.PostRespository;
import com.meiyun.jkan.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Resource
	private PostRespository pr;

	@Override
	public Page<Post> findPosts(PageRequest pageRequest) {
		return pr.findAll(pageRequest);
	}

	@Override
	public Post findById(Long id) {
		return pr.findOne(id);
	}

	@Override
	public boolean checkPost(String title) {
		Preconditions.checkNotNull(title);
		List<Post> list = pr.findByTitle(title);
		return list != null && !list.isEmpty();
	}

	@Override
	public Post addPosts(Post posts) {
		Preconditions.checkNotNull(posts);
		Preconditions.checkArgument(posts.getId() == null);
		return pr.save(posts);
	}

	@Override
	public Post updatePosts(Post posts) {
		Preconditions.checkNotNull(posts);
		Preconditions.checkArgument(posts.getId() != null);
		return pr.save(posts);
	}

	@Override
	public void deletePost(Long id) {
		Preconditions.checkNotNull(id);
		pr.delete(id);
	}
	
}
