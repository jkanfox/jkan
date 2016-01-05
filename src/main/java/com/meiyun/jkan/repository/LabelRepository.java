package com.meiyun.jkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.Label;

/**
 * 标签数据中心
 * @author larry.qi
 */
public interface LabelRepository extends JpaRepository<Label, Integer> {

}
