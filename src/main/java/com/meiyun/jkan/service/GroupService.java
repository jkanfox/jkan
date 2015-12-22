package com.meiyun.jkan.service;

import java.util.List;

import javax.transaction.Transactional;

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
	List<GroupModel> findGroups();
	
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
	List<PostsModel> findPostsByGroupId(Integer id);
	
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
