package com.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
/***
 * 	ע��servlet
 * 	��������register.jspҳ�������
 * 	���ڴ����û���registerҳ�������ĵ�¼��Ϣ
 * 	���û���Ϣ�����Ӧ���û����ݿ���
 * 	����û���Ϣע��Ĺ���
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 	����ע�������û��ύע����Ϣ�Ĳ���
	 */
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String path = req.getParameter("img");
		
		
		
		
			//��ҳ���д�ӡ��Ϣ   
			resp.setContentType("text/html;charset=UTF-8");
			resp.getWriter().println("������registerServlet����!");
			resp.getWriter().println(path);
		}
	
	
	
	
	

}
