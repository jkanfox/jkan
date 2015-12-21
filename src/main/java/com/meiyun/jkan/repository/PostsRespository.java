package com.meiyun.jkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.PostsModel;

/**
 * 帖子仓库
 * @author larry.qi
 */
public interface PostsRespository extends JpaRepository<PostsModel, Integer> {

}
