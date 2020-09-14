package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.entity.Item;
import com.realize.UserRealize;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/itemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��servlet���б��봦����ֹ����
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				
				//�ж�ǰ̨��form�ж������������
				boolean isMultipart = ServletFileUpload.isMultipartContent(request);
				
				if(isMultipart) {//�ж�ǰ̨��form�Ƿ���multipart����
					
					//��ȡԪ�زֿ����
					FileItemFactory factory = new DiskFileItemFactory(); 
					//�õ��ļ��ϴ��Ķ����Ǹ�
					ServletFileUpload upload = new ServletFileUpload(factory);
					
					//������װ�����Ա���
					//�����Ѿ��ƶ��õĹ��췽����������Ӧ�����Ա���
					String item_name = null; 
					int itemClass_id = 0; 
					String item_img = null; 
					String item_describe = null; 
					String item_date = null;
					int user_id = 0; 
					String item_status = null;
					
					try {
						
						//ͨ��parseRequest����form�е������ֶΣ������浽items������
						List<FileItem> items = upload.parseRequest(request);
						//��������items
						Iterator<FileItem> iter = items.iterator();
						while(iter.hasNext()) {
							//������е������ֶ�
							FileItem item = iter.next();
							//��ȡ����Ӧ�ֶ��е�name���Ե�ֵ
							String itemName = item.getFieldName();
		 					//�ж��Ƿ�Ϊ���ֶ�,�����ļ��ֶ�
							if(item.isFormField()) {
								if(itemName.equals("name")) {
									//��ȡname="name"���ֶ��е�����
									item_name = item.getString("UTF-8");
									
								}else if(itemName.equals("ClassId")) {
									//��ȡname="ClassId"���ֶ��е�����
									//���õ����ַ���תΪ��Ӧ������
									itemClass_id = Integer.parseInt(item.getString("UTF-8"));
									
								}else if(itemName.equals("describe")) {
									//��ȡname="describe"���ֶ��е�����
									item_describe = item.getString("UTF-8");
									
								}else if(itemName.equals("date")) {
									//��ȡname="date"���ֶ��е�����
									item_date = item.getString("UTF-8");
									
								}else if(itemName.equals("userId")) {
									//��ȡname="userId"���ֶ��е�����
									//���õ����ַ���תΪ��Ӧ������
									user_id = Integer.parseInt(item.getString("UTF-8"));
									
								}else if(itemName.equals("status")) {
									//��ȡname="status"���ֶ��е�����
									item_status = item.getString("UTF-8");
									
								}
								else {
									System.out.println("�����ֶ�");
								}
							}else {//�ļ�����
								//�ļ��ϴ�
								//getFieldName �ǻ�ȡ��ͨ���ֶε� name ��ֵ
								//getName �ǻ�ȡ �ļ���
								//��ȡ�������Ƭ���ļ���
								item_img = item.getName();//��ȡ�ϴ����ļ����ļ�
								//��ȡ�ļ�������  ���ϴ�
								//�����ļ����ϴ�·��  ָ����·��(������·��)
								//path Ϊ��ȡ���ļ��ϴ���·��
								String path = request.getSession().getServletContext().getRealPath("images");
								
								//������Ҫ�ϴ����ļ�
								File file = new File(path,item_img);
								
								//��ʼ�ϴ��ļ�
								item.write(file);
							}
						}
						Item item = new Item(item_name, itemClass_id, item_img, 
								item_describe, item_date, user_id, item_status);
						//����һ���û������Ķ���
						UserRealize ur = new UserRealize();
						boolean flag= ur.addItem(item);
						//�ж���ӳɹ����
						if(flag) {
							//�����ɺ���ת����ҳ
							request.getRequestDispatcher("index.jsp").forward(request, response);
						}else {
							//���ʧ�ܺ���ת��������Ϣҳ��ҳ��  �������
							request.getRequestDispatcher("../additem.jsp").forward(request, response);
						}
						
					} catch (FileUploadException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
