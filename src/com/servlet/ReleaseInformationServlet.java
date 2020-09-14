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
		
		//对响应的页面进行编码，防止页面乱码
		resp.setContentType("text/html;charset=UTF-8");
		
		//获取上传的图片的路径
		String imgPath = req.getParameter("img");
		
		//获取“\”最后一次出现后的字符串内容
		String []paths = imgPath.split("\\\\");
		
		//取出图片的文件名
		String tempPath = paths[paths.length-1];
		
		//创建项目中的图片文件夹(images)
		String path = req.getServletContext().getRealPath("/images")+tempPath;
		
		//源文件
		File imgFile = new File(imgPath);
		
		//目标文件
		File topath = new File(path);
		
		//获取输入输出缓冲流
		InputStream is = req.getInputStream();
		is =new FileInputStream(imgFile);//"源文件路径"
		OutputStream os = resp.getOutputStream();
		os =new FileOutputStream(topath);//"目标文件路径"
		//定义缓冲数组
		byte[] buffer=new byte[1024];
		//缓冲数组的索引下标
		int len=0;
		//遍历缓冲数组中的数据
		while((len=is.read(buffer))!=-1){
			//将源文件读入目标文件的路中
			os.write(buffer, 0, len);
		}
		os.flush();
		//关闭流
		os.close();
		is.close(); 
		
		
	/*	
		
		PrintWriter out = resp.getWriter();
		out.close();
		
		out.println("这里是registerServlet界面!");
		
		//打印上传的图片的路径
		out.println(tempPath);
		out.println("<br>");
		out.println(path);
		
		 */
		
	}
}
