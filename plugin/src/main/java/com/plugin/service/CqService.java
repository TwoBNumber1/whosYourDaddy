package com.plugin.service;

import com.plugin.entity.PrivateMessage;

/**
 * 
 * @author LAO
 *
 */
public interface CqService {

	
	void sendMsg();
	int insertMessage(PrivateMessage message);
}
