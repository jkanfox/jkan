package com.meiyun.jkan.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.meiyun.jkan.model.GroupModel;
import com.meiyun.jkan.model.PostsModel;
import com.meiyun.jkan.repository.GroupRepository;
import com.meiyun.jkan.repository.PostsRespository;
import com.meiyun.jkan.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {
	
	static final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);
	
	private GroupRepository gr;
	private PostsRespository pr;

	@Autowired
	public GroupServiceImpl(GroupRepository gr, PostsRespository pr) {
		this.gr = gr;
		this.pr = pr;
	}

	@Override
	public Page<GroupModel> findGroups(PageRequest pageRequest) {
		return gr.findAll(pageRequest);
	}

	@Override
	public GroupModel findById(Integer id) {
		return gr.findOne(id);
	}

	@Override
	public Page<PostsModel> findPostsByGroupId(Integer id, PageRequest pageRequest) {
		Preconditions.checkNotNull(id);
		return pr.findPostsByGroupId(id, pageRequest);
	}

	@Override
	public boolean checkGroup(String title) {
		Preconditions.checkNotNull(title);
		List<GroupModel> list = gr.findByTitle(title);
		return list != null && !list.isEmpty();
	}

	@Override
	public GroupModel addGroup(GroupModel group) throws Exception {
		Preconditions.checkNotNull(group);
		Preconditions.checkArgument(group.getId() == null);
		return gr.save(group);
	}

	@Override
	public GroupModel updateGroup(GroupModel group) {
		Preconditions.checkNotNull(group);
		Preconditions.checkNotNull(group.getId());
		return gr.save(group);
	}

	@Override
	public void deleteGroup(Integer id) {
		gr.delete(id);
	}

}
