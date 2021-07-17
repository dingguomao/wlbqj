package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.security.auth.x500.X500Principal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bean.ipLocation;
import com.db.Idb;
import com.db.Impl.dbImpl;
import com.entity.student;


@WebServlet("/addStudentServlet")
public class addStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    //表单字段
    String sname ,sclass ,department ,ip ,picPath;
    Long sno ;
	
    public addStudentServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//文件上传
		// 检测是否为多媒体上传
	    if (!ServletFileUpload.isMultipartContent(request)) {
	        // 如果不是则停止
	        PrintWriter writer = response.getWriter();
	        writer.println("Error: 表单必须包含 enctype=multipart/form-data");
	        writer.flush();
	        return;
	    }

	    // 配置上传参数
	    DiskFileItemFactory factory = new DiskFileItemFactory();
	    // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
	    factory.setSizeThreshold(MEMORY_THRESHOLD);
	    // 设置临时存储目录
	    factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

	    ServletFileUpload upload = new ServletFileUpload(factory);
	     
	    // 设置最大文件上传值
	    upload.setFileSizeMax(MAX_FILE_SIZE);
	     
	    // 设置最大请求值 (包含文件和表单数据)
	    upload.setSizeMax(MAX_REQUEST_SIZE);

	    // 中文处理
	    upload.setHeaderEncoding("UTF-8"); 

	    // 构造临时路径来存储上传的文件
	    // 这个路径相对当前应用的目录
	    String uploadPath ="c:\\" + File.separator + UPLOAD_DIRECTORY;
	   
	     
	    // 如果目录不存在则创建
	    File uploadDir = new File(uploadPath);
	    if (!uploadDir.exists()) {
	        uploadDir.mkdir();
	    }

	    try {
	        // 解析请求的内容提取文件数据
	        @SuppressWarnings("unchecked")
	        List<FileItem> formItems = upload.parseRequest(request);
	        
	        if (formItems != null && formItems.size() > 0) {
	        	
	            // 迭代表单数据
	            for (FileItem item : formItems) {
	            	System.out.println(item.isFormField());
	                // 处理不在表单中的字段
	                if (!item.isFormField()) {
	                    String fileName = new File(item.getName()).getName();
	                    String filePath = uploadPath + File.separator + fileName;
	                    File storeFile = new File(filePath);
	                    // 在控制台输出文件的上传路径
	                    System.out.println(filePath);
	                    picPath = filePath;
	                    // 保存文件到硬盘
	                    item.write(storeFile);
	                    request.setAttribute("message",
	                        "文件上传成功!");
	                    String name = item.getFieldName();
	                    System.out.println(name);
	                }else  {
	                	String name = item.getFieldName();
	                    System.out.println(name);
	                    System.out.println("------------------------");
	                    String cString = "sclass";
//	                    sclass =item.getString("utf-8");
//                		System.out.println(sclass);
	                	if(name.equals("sclass")) {
	                		sclass =item.getString("utf-8");
	                		System.out.println(sclass);
	                	}else if (name.equals("sno")) {
	                		sno = Long.parseLong(item.getString("utf-8"));
						}else if (name.equals("name")) {
							sname = item.getString("utf-8");
						}else if (name.equals("department")) {
							department = item.getString("utf-8");
						}else if (name.equals("ip")) {
							ip = item.getString("utf-8");
						}
					}
	                
	                
	            }
	            System.out.println(ip);
		        ipLocation location = new ipLocation();
		    	
		    	String placeJson = location.getPlace(ip);
		    	
		    	String address = location.getAddress(placeJson);
		    	
		    	student student = new student(sno, sname, sclass, department, ip ,address, picPath);
		    	System.out.println(student);
		    	 Idb db = new dbImpl();
		    	 boolean exist = db.exist(sno);
		    	 if (exist==true) {
		    		request.setAttribute("exist", exist);
//		    		System.out.println(exist);
		    		request.getRequestDispatcher("./index.jsp").forward(request, response);
		    	}else {
		    		 boolean result = db.addStudent(student);
		    		 
		    		 if (result) {
		    			 request.setAttribute("result", "1");
		    			request.getRequestDispatcher("./index.jsp").forward(request, response);
		    		
		    		 }else {
		    			request.setAttribute("result", "2");
		    		}
		    		 
		    	}
	            
	        }
	        
	    } catch (Exception ex) {
	        request.setAttribute("message",
	                "错误信息: " + ex.getMessage());
	    }
//	request.setCharacterEncoding("utf-8");
//	response.setCharacterEncoding("utf-8");
//	response.setContentType("text/html;charset=utf-8");
//	String sname = request.getParameter("name");
//	String sclass = request.getParameter("sclass");
//	String sno1 = request.getParameter("sno");
//	System.out.println(sno1);
//	Long sno = Long.parseLong(request.getParameter("sno"));
//	String department = request.getParameter("department");
//	String ip = request.getParameter("ip");
//	
//	
//	
//	
//    
//    
//    
//    
//	ipLocation location = new ipLocation();
//	
//	String placeJson = location.getPlace(ip);
//	
//	String address = location.getAddress(placeJson);
//	
//	student student = new student(sno, sname, sclass, department, ip ,address);
//	System.out.println(student);
//	 Idb db = new dbImpl();
//	 boolean exist = db.exist(sno);
//	 if (exist==true) {
//		request.setAttribute("exist", exist);
////		System.out.println(exist);
//		request.getRequestDispatcher("./index.jsp").forward(request, response);
//	}else {
//		 boolean result = db.addStudent(student);
//		 
//		 if (result) {
//			 request.setAttribute("result", "1");
//			request.getRequestDispatcher("./index.jsp").forward(request, response);
//		
//		 }else {
//			request.setAttribute("result", "2");
//		}
//		 
//	}
		
	
	
	 
	
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
