package com.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
/***
 * 	注册servlet
 * 	接收来自register.jsp页面的请求
 * 	用于处理用户在register页面的输入的登录信息
 * 	将用户信息存入对应的用户数据库中
 * 	完成用户信息注册的功能
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 	处理注册界面的用户提交注册信息的操作
	 */
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String path = req.getParameter("img");
		
		
		
		
			//在页面中打印信息   
			resp.setContentType("text/html;charset=UTF-8");
			resp.getWriter().println("这里是registerServlet界面!");
			resp.getWriter().println(path);
		}
	
	
	
	
	

}
