package com.servlet;

import java.awt.TexturePaint;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.Idb;
import com.db.Impl.dbImpl;
import com.entity.Page;
import com.entity.student;


@WebServlet("/queryAllStudent")
public class queryAllStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public queryAllStudent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html ;charset=utf-8");
		String page = request.getParameter("page");
		
		PrintWriter out = response.getWriter();
		boolean flag=false;
		String ip01 = request.getRemoteAddr();
		System.out.println(ip01);
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for(Cookie cookie:cookies) {
//            System.out.println(URLDecoder.decode(cookie.getName(), "utf-8"));
            if (URLDecoder.decode(cookie.getName(),"utf-8").equals("username")) {
            	flag=true;
			}
			}if (flag) {
				//当前页数
        		int n =0;
        		if (page==null) {
        			n=0;
        		}else {
        			n=Integer.valueOf(page);
        		}
        		//页面大小
        		int pageSize=5;
//        		System.out.println(page);
        		Idb dbimpl = new dbImpl();
        		//数据总数
        		int totality = dbimpl.getTotality();
        		//总页数
        		int pages = totality%pageSize == 0? totality/pageSize:totality/pageSize+1;
        		Page page2 = new Page(n, pageSize, totality, pages);
        		List<student> students = dbimpl.queryAllStudent(n,pageSize);
        		request.setAttribute("students", students);
        		request.setAttribute("page", page2);
        		System.out.println(students);
        		request.getRequestDispatcher("./admin.jsp").forward(request, response);
        	
				
			}else {
				out.print("<html>"
	                    + "<head><script type='text/javascript'> alert('没有登陆过或登录超时，请重新登录!');location='login.jsp';</script></head>"
	                    + "<body></body></html>");
			}
		}
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
