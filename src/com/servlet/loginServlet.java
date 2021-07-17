package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.Idb;
import com.db.Impl.dbImpl;
import com.entity.admin;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public loginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("user_name");
		String password = request.getParameter("psd");
		admin admin = new admin(username, password);
		PrintWriter out = response.getWriter();
		
		Idb db = new dbImpl();
		boolean loginDao = db.loginDao(admin);
//		System.out.println(loginDao);
		if (loginDao) {
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(300);
			response.addCookie(cookie);
			response.sendRedirect("./queryAllStudent");
		}else {
			out.print("<html>"
                    + "<head><script type='text/javascript'> alert('用户名或密码错误!');location='login.jsp';</script></head>"
                    + "<body></body></html>");
			
		}
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
