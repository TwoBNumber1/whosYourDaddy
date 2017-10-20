package com.plugin.entity;

import com.google.gson.annotations.SerializedName;

/**
 * 发送http请求后的返回体
 * @author LAO
 *
 */
public class CqResponse <T> {
	
	//状态 ok表示成功 failed表示操作失败
 	private String status;
 	//返回码=0表示成功 (不一定成功)
 	@SerializedName("retcode")
    private int retCode;
 	//返回的数据体
 	private T data;
 	

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRetCode() {
		return retCode;
	}
	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}
	@Override
	public String toString() {
		return "CqResponse [status=" + status + ", retCode=" + retCode + ", data=" + data + "]";
	}
	
	
}
