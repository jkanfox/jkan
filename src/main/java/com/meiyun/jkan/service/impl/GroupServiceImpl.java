package com.meiyun.jkan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.meiyun.jkan.model.GroupModel;
import com.meiyun.jkan.model.PostsModel;
import com.meiyun.jkan.repository.GroupRepository;
import com.meiyun.jkan.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {
	
	@Resource
	private GroupRepository gr;

	@Override
	public Page<GroupModel> findGroups(PageRequest pageRequest) {
		return gr.findAll(pageRequest);
	}

	@Override
	public GroupModel findById(Integer id) {
		return gr.findOne(id);
	}

	@Override
	public List<PostsModel> findPostsByGroupId(Integer id) {
		return null;
	}

	@Override
	public boolean checkGroup(String title) {
		return false;
	}

	@Override
	public GroupModel addGroup(GroupModel group) throws Exception {
		group.setId(null);
		return gr.save(group);
	}

	@Override
	public GroupModel updateGroup(GroupModel group) {
		return gr.save(group);
	}

	@Override
	public void deleteGroup(Integer id) {
		gr.delete(id);
	}

}
