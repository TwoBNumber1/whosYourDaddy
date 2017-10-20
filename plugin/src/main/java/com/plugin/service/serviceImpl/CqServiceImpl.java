package com.plugin.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plugin.dao.PrivateMessageDao;
import com.plugin.entity.PrivateMessage;
import com.plugin.service.CqService;
@Service
public class CqServiceImpl implements CqService{

	
	private PrivateMessageDao privateMessageDao;
	@Autowired
	public CqServiceImpl(PrivateMessageDao privateMessageDao) {
		// TODO Auto-generated constructor stub
		this.privateMessageDao = privateMessageDao;
		
	}
	
	@Override
	public void sendMsg() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int insertMessage(PrivateMessage message) {
		// TODO Auto-generated method stub
		return privateMessageDao.insertPrivateMessage(message);
	}

}
