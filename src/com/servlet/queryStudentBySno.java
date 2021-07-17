package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.Idb;
import com.db.Impl.dbImpl;
import com.dbUtil.dbUtil;
import com.entity.student;


@WebServlet("/queryStudentBySno")
public class queryStudentBySno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public queryStudentBySno() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Long sno = Long.parseLong(request.getParameter("sno"));
		
		Idb dbImpl = new dbImpl();
		student student = dbImpl.queryStudentBySno(sno);
		
		if(student==null) {
			request.setAttribute("isExist", '0');
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		}else {
			request.setAttribute("info", student);
			request.getRequestDispatcher("./alter.jsp").forward(request, response);
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
