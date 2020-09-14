package com.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ReleaseInformationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//����Ӧ��ҳ����б��룬��ֹҳ������
		resp.setContentType("text/html;charset=UTF-8");
		
		//��ȡ�ϴ���ͼƬ��·��
		String imgPath = req.getParameter("img");
		
		//��ȡ��\�����һ�γ��ֺ���ַ�������
		String []paths = imgPath.split("\\\\");
		
		//ȡ��ͼƬ���ļ���
		String tempPath = paths[paths.length-1];
		
		//������Ŀ�е�ͼƬ�ļ���(images)
		String path = req.getServletContext().getRealPath("/images")+tempPath;
		
		//Դ�ļ�
		File imgFile = new File(imgPath);
		
		//Ŀ���ļ�
		File topath = new File(path);
		
		//��ȡ�������������
		InputStream is = req.getInputStream();
		is =new FileInputStream(imgFile);//"Դ�ļ�·��"
		OutputStream os = resp.getOutputStream();
		os =new FileOutputStream(topath);//"Ŀ���ļ�·��"
		//���建������
		byte[] buffer=new byte[1024];
		//��������������±�
		int len=0;
		//�������������е�����
		while((len=is.read(buffer))!=-1){
			//��Դ�ļ�����Ŀ���ļ���·��
			os.write(buffer, 0, len);
		}
		os.flush();
		//�ر���
		os.close();
		is.close(); 
		
		
	/*	
		
		PrintWriter out = resp.getWriter();
		out.close();
		
		out.println("������registerServlet����!");
		
		//��ӡ�ϴ���ͼƬ��·��
		out.println(tempPath);
		out.println("<br>");
		out.println(path);
		
		 */
		
	}
}
