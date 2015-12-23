package com.meiyun.jkan.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.meiyun.jkan.model.GroupModel;
import com.meiyun.jkan.model.PostsModel;

/**
 * 分组
 * @author larry.qi
 */
@Transactional
public interface GroupService {
	
	/**
	 * 查询Groups
	 * @return
	 */
	Page<GroupModel> findGroups(PageRequest pageRequest);
	
	/**
	 * 根据ID查询Group
	 * @param id
	 * @return
	 */
	GroupModel findById(Integer id);
	
	/**
	 * 根据ID查询所有Posts
	 * @param id
	 * @return
	 */
	Page<PostsModel> findPostsByGroupId(Integer id, PageRequest pageRequest);
	
	/**
	 * 检测名称是否可用
	 * @param title
	 * @return
	 */
	boolean checkGroup(String title);
	
	/**
	 * 添加分组
	 * @param group
	 * @return
	 * @throws Exception
	 */
	GroupModel addGroup(GroupModel group) throws Exception;
	
	/**
	 * 更新Group
	 * @param group
	 * @return
	 */
	GroupModel updateGroup(GroupModel group);
	
	/**
	 * 删除Group
	 * @param id
	 */
	void deleteGroup(Integer id);

}
