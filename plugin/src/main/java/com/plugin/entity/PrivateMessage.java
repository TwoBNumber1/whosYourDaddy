package com.plugin.entity;
/**
 * QQ私聊消息实体类
 * @author LAO
 *
 */
public class PrivateMessage {

	//发送的消息内容
	private String message;
	//发送者ID
	private String senderId;
	//消息使用的字体
	private Integer messageFont;
	//发送时间
	private String messageTime;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public Integer getMessageFont() {
		return messageFont;
	}
	public void setMessageFont(Integer messageFont) {
		this.messageFont = messageFont;
	}
	public String getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}
	@Override
	public String toString() {
		return "PrivateMessage [message=" + message + ", senderId=" + senderId + ", font=" + messageFont + ", time=" + messageTime
				+ "]";
	}
	
	
}
