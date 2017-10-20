package com.plugin;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.plugin.dao.PrivateMessageDao;
import com.plugin.entity.CqMessage;
import com.plugin.entity.PrivateMessage;
import com.plugin.util.CqUtil;

public class MessageTest extends BaseTest{

	@Autowired
	private PrivateMessageDao privateMessageDao;
	
	  @Test
	  @Ignore
	    public void insertPrivateMessage() throws Exception {
	        PrivateMessage msg = new PrivateMessage();
	        msg.setSenderId("123456");
	        msg.setMessage("敲李吗！");
	        msg.setMessageFont(14);
	        msg.setMessageTime("2017.10.20");
	        int result = privateMessageDao.insertPrivateMessage(msg);
	        System.out.println(msg+" --插入行数:"+result);
	    }
	  
	  @Test
	  public void testCqUtil() {
		  CqUtil cqUtil = new CqUtil();
		  CqMessage message = new CqMessage();
		  message.setUserId("535848171");
		  message.setMessage("通过http请求返回的消息");
		  message.setMessageType("private");
		  System.out.println(cqUtil.sendMsgWithoutParam("getLoginInfo"));
	  }
}
