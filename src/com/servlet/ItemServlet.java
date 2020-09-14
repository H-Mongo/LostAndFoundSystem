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
		
		//对servlet进行编码处理，防止乱码
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				
				//判断前台的form中定义的数据属性
				boolean isMultipart = ServletFileUpload.isMultipartContent(request);
				
				if(isMultipart) {//判断前台的form是否有multipart属性
					
					//获取元素仓库对象
					FileItemFactory factory = new DiskFileItemFactory(); 
					//得到文件上传的对象那个
					ServletFileUpload upload = new ServletFileUpload(factory);
					
					//声明封装的属性变量
					//依据已经制定好的构造方法来声明对应的属性变量
					String item_name = null; 
					int itemClass_id = 0; 
					String item_img = null; 
					String item_describe = null; 
					String item_date = null;
					int user_id = 0; 
					String item_status = null;
					
					try {
						
						//通过parseRequest解析form中的请求字段，并保存到items集合中
						List<FileItem> items = upload.parseRequest(request);
						//遍历集合items
						Iterator<FileItem> iter = items.iterator();
						while(iter.hasNext()) {
							//获得其中的请求字段
							FileItem item = iter.next();
							//获取表单对应字段中的name属性的值
							String itemName = item.getFieldName();
		 					//判断是否为表单字段,还是文件字段
							if(item.isFormField()) {
								if(itemName.equals("name")) {
									//获取name="name"的字段中的数据
									item_name = item.getString("UTF-8");
									
								}else if(itemName.equals("ClassId")) {
									//获取name="ClassId"的字段中的数据
									//将得到的字符串转为对应的整数
									itemClass_id = Integer.parseInt(item.getString("UTF-8"));
									
								}else if(itemName.equals("describe")) {
									//获取name="describe"的字段中的数据
									item_describe = item.getString("UTF-8");
									
								}else if(itemName.equals("date")) {
									//获取name="date"的字段中的数据
									item_date = item.getString("UTF-8");
									
								}else if(itemName.equals("userId")) {
									//获取name="userId"的字段中的数据
									//将得到的字符串转为对应的整数
									user_id = Integer.parseInt(item.getString("UTF-8"));
									
								}else if(itemName.equals("status")) {
									//获取name="status"的字段中的数据
									item_status = item.getString("UTF-8");
									
								}
								else {
									System.out.println("其他字段");
								}
							}else {//文件类型
								//文件上传
								//getFieldName 是获取普通表单字段的 name 的值
								//getName 是获取 文件名
								//获取传入的照片的文件名
								item_img = item.getName();//获取上传的文件的文件
								//获取文件的内容  并上传
								//定义文件的上传路径  指定的路径(服务器路径)
								//path 为获取的文件上传的路径
								String path = request.getSession().getServletContext().getRealPath("images");
								
								//创建需要上传的文件
								File file = new File(path,item_img);
								
								//开始上传文件
								item.write(file);
							}
						}
						Item item = new Item(item_name, itemClass_id, item_img, 
								item_describe, item_date, user_id, item_status);
						//创建一个用户操作的对象
						UserRealize ur = new UserRealize();
						boolean flag= ur.addItem(item);
						//判断添加成功与否
						if(flag) {
							//添加完成后跳转到主页
							request.getRequestDispatcher("index.jsp").forward(request, response);
						}else {
							//添加失败后跳转到发布信息页的页面  重新添加
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
