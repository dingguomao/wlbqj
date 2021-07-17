package com.db;

import java.util.List;

import com.entity.admin;
import com.entity.student;

public interface Idb {
	//查询是否存在
	public boolean exist(Long sno);
	//根据学号查询学生信息 
	public student queryStudentBySno(Long sno);
	//增加信息
	public boolean addStudent(student student);
	//修改信息
	public boolean updateStudentBySno(student student);
	//删除信息
	public boolean deleteStudent(Long sno);
	//查询全部学生信息
	public List<student> queryAllStudent(int page,int pagesize);
	//查询数据总数
	public int getTotality();
	//登录后台管理页面 
	public boolean loginDao(admin admin);
	
	
	
}
