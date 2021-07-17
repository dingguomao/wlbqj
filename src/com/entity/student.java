package com.entity;

import java.sql.Date;
import java.sql.Timestamp;

import org.omg.CORBA.PUBLIC_MEMBER;

public class student {

	private Long sno;
	private String sname ;
	private String sclass;
	private String department;
	private String ip;
	private String address;
	private Date create_time;
	private Timestamp update_time;
	private String picPath; 
	
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	public student(Long sno, String sname, String sclass, String department, String ip, String address,
			Date create_time, Timestamp update_time) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sclass = sclass;
		this.department = department;
		this.ip = ip;
		this.address = address;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public student(Long sno, String sname, String sclass, String department, String ip, String address) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sclass = sclass;
		this.department = department;
		this.ip = ip;
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public student(Long sno, String sname, String sclass, String department, String ip) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sclass = sclass;
		this.department = department;
		this.ip = ip;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Long getSno() {
		return sno;
	}
	public void setSno(Long sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "student [sno=" + sno + ", sname=" + sname + ", sclass=" + sclass + ", department=" + department + "]";
	}
	public student(Long sno, String sname, String sclass, String department) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sclass = sclass;
		this.department = department;
	}
	public student(Long sno, String sname, String sclass, String department, String ip, String address,
			Date create_time, Timestamp update_time, String picPath) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sclass = sclass;
		this.department = department;
		this.ip = ip;
		this.address = address;
		this.create_time = create_time;
		this.update_time = update_time;
		this.picPath = picPath;
	}
	public student(Long sno, String sname, String sclass, String department, String ip, String address,
			String picPath) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sclass = sclass;
		this.department = department;
		this.ip = ip;
		this.address = address;
		this.picPath = picPath;
	}
	
	
	
	
}
