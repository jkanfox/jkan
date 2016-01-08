package com.meiyun.jkan.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.meiyun.jkan.model.Track;

/**
 * 错误管理与追踪
 * @author larry.qi
 */
@Transactional
public interface TrackService {
	
	public Page<Track> findAll(Pageable pageable);
	
	public void addTrack(Track track);

}
