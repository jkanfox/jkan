package com.meiyun.jkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.Resource;

/**
 * 资源管理数据中心
 * @author larry.qi
 *
 */
public interface ResourceRepository extends JpaRepository<Resource, Long> {

}
