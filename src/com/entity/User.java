package com.entity;
/***
 * 	用户类
 * 	定义招领系统中的用户类（发布者）
 * 	对用户进行的属性特征进行定义和刻画
 * @author lenovo
 *
 */
public class User {
	
	//声明对应的属性
	private int user_id;//用户对应的id是唯一的不重复
	private String user_name;//用户名
	private String user_password;//用户密码
	private String user_tel;//用户的联系电话
	private String user_qq;//用户对应的QQ联系方式
	private int dept_id;//用户对应所在的院系id，可以根据对应的id查到对应学生的院系
	private int identity_id;//对应用户的身份识别
	
	//显示默认的构造方法
	public User() {}
	
	//对应自定义的构造方法
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
	
	//生成属性对应的getter和setter方法
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
