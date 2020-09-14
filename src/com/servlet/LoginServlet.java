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
 *	 �����¼ҳ�� (login.jsp)�ж�Ӧ������Ĳ�����
 *	����ʶ���¼���û���Ϣ 
 * @author lenovo
 *
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//���л�
	/***
	 * 	�����¼������û��ύ��¼��Ϣ�Ĳ���
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//��ȡ�����еĲ���getInitParameter("username");
		
		//����һ��session����
		HttpSession session = req.getSession(); 
		
		
		//��ȡ�û�������û���
		String username = req.getParameter("username");
		//��ȡ�û����������
		String password = req.getParameter("password");
		//��ȡ�û������
		String identityId = req.getParameter("identify");
		//����UserRealize����
		UserRealize ur = new UserRealize();
		//����һ���û��������ں���Ự��������
		User user = new User();
		//�����������Ϣ�������ݿ��н���������Ϣ��ƥ�����
		//��������֤�û���¼�ķ���
		//�����û������
		user = ur.queryUser(username, password,identityId);
		
		//���ҳ��������������
		resp.setContentType("text/html;charset=UTF-8");
		//��ʾ��֤�ɹ�������Ϣ
		switch(user.getIdentity_id()) {
			case 0:
				resp.getWriter().println("��¼�ɹ�����ӭ����"+username+"(��ͨ�û�)");
				
				//Ϊsession������ӵ�ǰ��¼���û�
				session.setAttribute("user", user);
				break;
			case 1:
				resp.getWriter().println("��¼�ɹ�����ӭ����"+username+"(����Ա)");
				break;
			default:
				resp.getWriter().println("��¼ʧ�ܣ��û��������벻��"+username+"�����µ�¼");
		
		}
		
		
		//��ȡ��ʼ������(����)
		//String initName = getServletContext().getInitParameter("name");
		
		/***
		 * 	�̳�  HttpServlet �������ȡ��ʼ�������ķ�ʽ��ͬ
		 * 1.
		 * 	web.xml �ļ�����<context-param>��ǩ����Ĳ�����Ҫ�� ServletContext �����е� getInitParameter() ��ȡ
		 * 	ע�⣺�˴��Ĳ�����������Ӧ�ó������κ� servlet �ж���Ч
		 * 2.
		 * 	web.xml �ļ�����<init-param>��ǩ����Ĳ�����Ҫ�� ServletConfig �����е� getInitParameter() ��ȡ
		 * 	�˴��Ĳ��������� <servlet> ��ǩ�е� <servlet-class> ��ӵ�У�ֻ�ڵ�ǰ�� servlet ����Ч
		 */
		
		
		//��ȡ��ʼ������(����)
		//String initPassword = this.getServletConfig().getServletContext().getInitParameter("mima");
		
		//�����������
		resp.setContentType("text/html;charset=UTF-8");
		/*		
		//�жϵ�¼���û����������Ƿ���ȷ
		if(username.equals(initName) && password.equals(initPassword)) {
			resp.getWriter().println("��¼�ɹ�����ӭ����"+username);
		}else {
			resp.getWriter().println("��¼ʧ�ܣ�"+username+"�����µ�¼");
		}
		*/
	}

}
