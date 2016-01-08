package com.meiyun.jkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meiyun.jkan.model.Track;

/**
 * 错误管理和追踪
 * @author larry.qi
 */
public interface TrackRepository extends JpaRepository<Track, Long> {

}
