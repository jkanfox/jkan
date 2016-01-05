package com.meiyun.jkan.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.meiyun.jkan.model.Group;
import com.meiyun.jkan.model.Post;
import com.meiyun.jkan.repository.GroupRepository;
import com.meiyun.jkan.repository.PostRespository;
import com.meiyun.jkan.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {
	
	static final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);
	
	private GroupRepository gr;
	private PostRespository pr;

	@Autowired
	public GroupServiceImpl(GroupRepository gr, PostRespository pr) {
		this.gr = gr;
		this.pr = pr;
	}

	@Override
	public Page<Group> findGroups(PageRequest pageRequest) {
		return gr.findAll(pageRequest);
	}

	@Override
	public Group findById(Integer id) {
		return gr.findOne(id);
	}

	@Override
	public Page<Post> findPostsByGroupId(Integer id, PageRequest pageRequest) {
		Preconditions.checkNotNull(id);
		return pr.findPostsByGroupId(id, pageRequest);
	}

	@Override
	public boolean checkGroup(String title) {
		Preconditions.checkNotNull(title);
		List<Group> list = gr.findByTitle(title);
		return list != null && !list.isEmpty();
	}

	@Override
	public Group addGroup(Group group) throws Exception {
		Preconditions.checkNotNull(group);
		Preconditions.checkArgument(group.getId() == null);
		return gr.save(group);
	}

	@Override
	public Group updateGroup(Group group) {
		Preconditions.checkNotNull(group);
		Preconditions.checkNotNull(group.getId());
		return gr.save(group);
	}

	@Override
	public void deleteGroup(Integer id) {
		gr.delete(id);
	}

}
