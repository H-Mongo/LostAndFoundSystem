package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;
import com.realize.UserRealize;

/***
 *	 处理登录页面 (login.jsp)中对应表单请求的操作，
 *	用来识别登录的用户信息 
 * @author lenovo
 *
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//序列化
	/***
	 * 	处理登录界面的用户提交登录信息的操作
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取配置中的参数getInitParameter("username");
		
		//创建一个session对象
		HttpSession session = req.getSession(); 
		
		
		//获取用户请求的用户名
		String username = req.getParameter("username");
		//获取用户请求的密码
		String password = req.getParameter("password");
		//获取用户的身份
		String identityId = req.getParameter("identify");
		//创建UserRealize对象
		UserRealize ur = new UserRealize();
		//创建一个用户对象，用于后面会话管理所用
		User user = new User();
		//利用输入的信息，在数据库中进行数据信息的匹配操作
		//并调用验证用户登录的方法
		//返回用户的身份
		user = ur.queryUser(username, password,identityId);
		
		//解决页面编码乱码的问题
		resp.setContentType("text/html;charset=UTF-8");
		//显示验证成功与否的信息
		switch(user.getIdentity_id()) {
			case 0:
				resp.getWriter().println("登录成功，欢迎您："+username+"(普通用户)");
				
				//为session对象添加当前登录的用户
				session.setAttribute("user", user);
				break;
			case 1:
				resp.getWriter().println("登录成功，欢迎您："+username+"(管理员)");
				break;
			default:
				resp.getWriter().println("登录失败，用户名或密码不对"+username+"请重新登录");
		
		}
		
		
		//获取初始化参数(姓名)
		//String initName = getServletContext().getInitParameter("name");
		
		/***
		 * 	继承  HttpServlet 的类里获取初始化参数的方式不同
		 * 1.
		 * 	web.xml 文件中用<context-param>标签定义的参数需要用 ServletContext 对象中的 getInitParameter() 获取
		 * 	注意：此处的参数属于整个应用程序，在任何 servlet 中都有效
		 * 2.
		 * 	web.xml 文件中用<init-param>标签定义的参数需要用 ServletConfig 对象中的 getInitParameter() 获取
		 * 	此处的参数属于在 <servlet> 标签中的 <servlet-class> 所拥有，只在当前的 servlet 中有效
		 */
		
		
		//获取初始化参数(密码)
		//String initPassword = this.getServletConfig().getServletContext().getInitParameter("mima");
		
		//解决编码问题
		resp.setContentType("text/html;charset=UTF-8");
		/*		
		//判断登录的用户名和密码是否正确
		if(username.equals(initName) && password.equals(initPassword)) {
			resp.getWriter().println("登录成功，欢迎您："+username);
		}else {
			resp.getWriter().println("登录失败，"+username+"请重新登录");
		}
		*/
	}

}
