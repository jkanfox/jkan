package com.meiyun.jkan.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meiyun.jkan.model.PostsModel;
import com.meiyun.jkan.repository.PostsRespository;
import com.meiyun.jkan.service.PostsService;

@Service
public class PostsServiceImpl implements PostsService {
	
	@Resource
	private PostsRespository pr;

	@Override
	public PostsModel addPosts(PostsModel posts) throws Exception {
		return pr.save(posts);
	}

}
