package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.Idb;
import com.entity.student;
import com.db.Impl.dbImpl;


@WebServlet("/alertStudentServlet")
public class alertStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public alertStudentServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		Long sno = Long.parseLong( request.getParameter("sno"));
		String sname = request.getParameter("name");
		String sclass = request.getParameter("class");
		String department = request.getParameter("department");
		
		student student = new student(sno, sname, sclass, department);
		Idb dbImpl = new dbImpl();
		
		boolean res = dbImpl.updateStudentBySno(student);
		
		if (res) {
			request.setAttribute("update", "1");
			request.setAttribute("student", student);
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		}else {
			request.setAttribute("update","0");
			request.getRequestDispatcher("./alter.jsp").forward(request, response);
		}
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
