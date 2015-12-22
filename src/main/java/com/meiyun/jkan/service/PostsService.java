package com.meiyun.jkan.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.meiyun.jkan.model.PostsModel;

/**
 * 帖子
 * @author larry.qi
 */
public interface PostsService {
	
	@Transactional(value = TxType.REQUIRED)
	PostsModel addPosts(PostsModel posts) throws Exception;

}
