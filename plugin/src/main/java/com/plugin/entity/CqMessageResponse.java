package com.plugin.entity;

import com.google.gson.annotations.SerializedName;

/**
 * 响应上报消息的响应消息体
 * @author LAO
 *
 */
public class CqMessageResponse {

	//要回复的内容
	private String reply;
	//是否在回复开头@发送者，默认为true，发送者匿名时无效
	@SerializedName("at_sender")
	private boolean atSender;
	//将发送者踢出群组！！！不拒绝此人后续加群请求 默认false 匿名无效
	private boolean kick;
	//发送者禁言30分钟
	private boolean ban;
	//是否同意好友请求
	private boolean approve;
	//添加后的好友备注
	private String remark;
	//拒绝加群的理由
	private String reason;
	
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public boolean isAtSender() {
		return atSender;
	}
	public void setAtSender(boolean atSender) {
		this.atSender = atSender;
	}
	public boolean isKick() {
		return kick;
	}
	public void setKick(boolean kick) {
		this.kick = kick;
	}
	public boolean isBan() {
		return ban;
	}
	public void setBan(boolean ban) {
		this.ban = ban;
	}
	public boolean isApprove() {
		return approve;
	}
	public void setApprove(boolean approve) {
		this.approve = approve;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//构建器部分 暂不使用
	/*private ResponseData(Builder builder) {
		reply = builder.reply;
		atSender = builder.atSender;
		kick = builder.kick;
		ban =  builder.ban;
		approve = builder.approve;
		remark = builder.remark;
		reason = builder.reason;
	}
	*/
	/*//静态内部类
	  public static class Builder() {
		
		//全部都为可选属性
		//要回复的内容
		private final String reply;
		//是否在回复开头@发送者，默认为true，发送者匿名时无效
		@SerializedName("at_sender")
		private final String atSender;
		//将发送者踢出群组！！！不拒绝此人后续加群请求 默认false 匿名无效
		private final String kick;
		//发送者禁言30分钟
		private final String ban;
		//是否同意好友请求
		private final String approve;
		//添加后的好友备注
		private final String remark;
		//拒绝加群的理由
		private final String reason;
		
		public Builder() {
			
		}
		
		public Builder reply(String data) {
			reply = data;
			return(this);
		}
		public Builder atSender(String data) {
			atSender = data;
			return(this);
		}
		public Builder kick(String data) {
			kick = data;
			return(this);
		}
		public Builder ban(String data) {
			ban = data;
			return(this);
		}
		public Builder approve(String data) {
			approve = data;
			return(this);
		}
		public Builder remark(String data) {
			remark = data;
			return(this);
		}
		public Builder reason(String data) {
			reason = data;
			return(this);
		}
		
		public ResponseData build() {
			return new ResponseData(this);
		}
	}*/
}
	

