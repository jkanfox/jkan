package com.meiyun.jkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.Share;

/**
 * 用户分享链接数据中心
 * @author larry.qi
 */
public interface ShareRepository extends JpaRepository<Share, Integer> {

}
