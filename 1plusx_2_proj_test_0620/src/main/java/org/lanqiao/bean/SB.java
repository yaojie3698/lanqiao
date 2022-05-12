package org.lanqiao.bean;

import java.util.Date;

/**
 * 借阅信息类
 */
public class SB {
	private int id;//自增序列号
	private String sname;//学生姓名
	private String bname;//书籍名称
	private Date beginTime;//借书时间
	private Date endTime;//还书时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public SB() {
	}

	public SB(int id, String sname, String bname, Date beginTime, Date endTime) {
		this.id = id;
		this.sname = sname;
		this.bname = bname;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}
}
