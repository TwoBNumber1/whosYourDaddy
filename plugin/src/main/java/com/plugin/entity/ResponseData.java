package com.plugin.entity;

import com.google.gson.annotations.SerializedName;

/**
 * 调用API发送消息后的响应体data部分
 * @author LAO
 *
 */
public class ResponseData {
	 //API消息中的返回消息体，目前没有作用
	
	@SerializedName("user_id")
    private int id;

    private String nickname;

    
    
    
    
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public String getNickname(){
        return this.nickname;
    }
}
