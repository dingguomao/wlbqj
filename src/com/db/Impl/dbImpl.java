package com.db.Impl;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;

import com.db.Idb;
import com.dbUtil.dbUtil;
import com.entity.admin;
import com.entity.student;

public class dbImpl implements Idb{

	
	 dbUtil dbu = new dbUtil();
	@Override
	public boolean exist(Long sno) {
		
//		System.out.println(queryStudentBySno(sno).size()==0? false:true);
		return queryStudentBySno(sno)==null? false:true;
	}

	@Override
	public student queryStudentBySno(Long sno) {
			String sql = "select * from qj where sno=? ";
			Object[] obj = {
					sno
			};
			return dbu.queryStudentBySno(sql, obj);	
	}

	@Override
	public boolean addStudent(student student) {
		String sql = "insert into qj(sno,name,class,department,create_time,ip,address,picPath) values(?,?,?,?,NOW(),?,?,?)";
		Object[] obj = {
				student.getSno(),
				student.getSname(),
				student.getSclass(),
				student.getDepartment(),
				student.getIp(),
				student.getAddress(),
				student.getPicPath()
		};
		boolean res = dbu.Upload(sql, obj);
		
		
		return res;
	}

	@Override
	public boolean updateStudentBySno(student student) {
		String sql = "update qj set name=?,class=?,department=? where sno =?";
		Object[] obj = {
				student.getSname(),
				student.getSclass(),
				student.getDepartment(),
				student.getSno(),
		};
		boolean res = dbu.Upload(sql, obj);
		
		return res;
	}

	@Override
	public boolean deleteStudent(Long sno) {
		String sql ="delete from qj where sno=?";
		
		Object[] obj = {
				sno
		};
		boolean res = dbu.Upload(sql, obj);
		return res;
	}
	@Override
	public List<student> queryAllStudent(int page,int pagesize){
		

		
		String sql = "select*from qj limit "+(page*pagesize)+","+pagesize;
//		System.out.println(sql);
		Object[] obj = {};
		
		List<student> query = dbu.queryAll(sql, obj);
//		System.out.println(query);
		return query;
		
		
	}

	@Override
	public int getTotality() {
		String sql = "select count(1) from qj";
		Object[] obj = {};
		int count = dbu.getTotality(sql, obj);
//		System.out.println(count);
		
		return count;
	}

	@Override
	public boolean loginDao(admin admin) {
		String sql = "select*from admin where username=? and password=?";
		Object[] obj = {
				admin.getUsername(),
				admin.getPassword()
		};
		boolean login = dbu.login(sql, obj);
		return login;
	}
	
	

}
