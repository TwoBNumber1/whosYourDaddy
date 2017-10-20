package com.plugin.dao;

import org.springframework.stereotype.Repository;

import com.plugin.entity.PrivateMessage;
@Repository
public interface PrivateMessageDao {

	/**
	 * 插入消息记录
	 * @param privateMesssage
	 * @return 插入的行数
	 */
	int insertPrivateMessage(PrivateMessage privateMesssage);
	
	
	
	
}
