package com.entity;
/***
 * 	�û���
 * 	��������ϵͳ�е��û��ࣨ�����ߣ�
 * 	���û����е������������ж���Ϳ̻�
 * @author lenovo
 *
 */
public class User {
	
	//������Ӧ������
	private int user_id;//�û���Ӧ��id��Ψһ�Ĳ��ظ�
	private String user_name;//�û���
	private String user_password;//�û�����
	private String user_tel;//�û�����ϵ�绰
	private String user_qq;//�û���Ӧ��QQ��ϵ��ʽ
	private int dept_id;//�û���Ӧ���ڵ�Ժϵid�����Ը��ݶ�Ӧ��id�鵽��Ӧѧ����Ժϵ
	private int identity_id;//��Ӧ�û������ʶ��
	
	//��ʾĬ�ϵĹ��췽��
	public User() {}
	
	//��Ӧ�Զ���Ĺ��췽��
	public User(String user_name, String user_password, String user_tel, String user_qq, int dept_id,
			int identity_id) {
		super();
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_tel = user_tel;
		this.user_qq = user_qq;
		this.dept_id = dept_id;
		this.identity_id = identity_id;
	}
	
	//�������Զ�Ӧ��getter��setter����
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getUser_qq() {
		return user_qq;
	}
	public void setUser_qq(String user_qq) {
		this.user_qq = user_qq;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public int getIdentity_id() {
		return identity_id;
	}
	public void setIdentity_id(int identity_id) {
		this.identity_id = identity_id;
	}
	
	
}
