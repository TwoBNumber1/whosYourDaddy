package com.plugin.entity;

import java.util.Date;

public class Appointment {

	

    private long bookId;// 图书ID

    private long studentId;// 学号

    private Date appointTime;// 预约时间

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public Date getAppointTime() {
		return appointTime;
	}

	public void setAppointTime(Date appointTime) {
		this.appointTime = appointTime;
	}

	@Override
	public String toString() {
		return "Appointment [bookId=" + bookId + ", studentId=" + studentId + ", appointTime=" + appointTime + "]";
	}
    
    
}
