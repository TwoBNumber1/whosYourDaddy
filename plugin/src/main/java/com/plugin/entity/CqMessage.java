package com.plugin.entity;

import com.google.gson.annotations.SerializedName;

/**
 * coolq通过http API 上报消息的消息体
 * 包含所有可能字段 根据post_type判断消息类型
 * @author LAO
 *
 */
public class CqMessage {

	
	//暂时只有私聊消息部分
	//post_type	 message_type	sub_type	user_id		message
	
	//指示上报类型 "message":收到的消息  "event":群、讨论组变动等非消息类型 "request":好友请求/加群请求or邀请
	@SerializedName("post_type")
	private String postType;
	//消息类型
	@SerializedName("message_type")
	private String messageType;
	@SerializedName("sub_type")
	//消息子类型 "friend":好友消息  "group":群消息  "discuss":讨论组消息 "other"
	private String subType;
	@SerializedName("user_id")
	//私聊消息  -->  发送消息的qq号
	private String userId;
	//消息内容 （该属性与上报消息字段相同 不使用gson注解）
	private String message;
	//时间戳
	private String time;
	
	//--->其他属性
	//上报请求消息的消息子类型
	@SerializedName("request_type")
	private String requestType;
	//请求flag
	private String flag;
	//加群请求的群号
	@SerializedName("group_id")
	private String groupId;

    private String event;
    @SerializedName("operator_id")
    private Long operatorId;
    private Integer duration;
    @SerializedName("discuss_id")
    private Long discussId;
    private String type;
    private boolean approve;
    private String reason;

	
	
	
	
	
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public Long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Long getDiscussId() {
		return discussId;
	}
	public void setDiscussId(Long discussId) {
		this.discussId = discussId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isApprove() {
		return approve;
	}
	public void setApprove(boolean approve) {
		this.approve = approve;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
}
