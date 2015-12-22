package com.meiyun.jkan.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.meiyun.jkan.model.GroupModel;

/**
 * 分组
 * @author larry.qi
 */
public interface GroupService {
	
	@Transactional(value = TxType.REQUIRED)
	GroupModel addGroup(GroupModel group) throws Exception;

}
