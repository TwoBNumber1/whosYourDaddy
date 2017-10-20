package com.plugin.entity;

import java.util.Date;

public class User {

	
	private String userId;
	private String userName;
	private Date userBirthday;
	private double userSalary;
	
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userBirthday=" + userBirthday + ", salary="
				+ userSalary + "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public double getSalary() {
		return userSalary;
	}
	public void setSalary(double salary) {
		this.userSalary = salary;
	}
	
}
