package com.meiyun.jkan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.meiyun.jkan.model.Track;
import com.meiyun.jkan.repository.TrackRepository;
import com.meiyun.jkan.service.TrackService;

@Service
public class TrackServiceImpl implements TrackService {

	@Autowired
	private TrackRepository tr;

	@Override
	public Page<Track> findAll(Pageable pageable) {
		return tr.findAll(pageable);
	}

	@Override
	public void addTrack(Track track) {
		tr.saveAndFlush(track);
	}
	
}
