package com.entity;
/***
 * 	身份类
 * 	定义对应的方法和属性
 * 	区别用户和管理员的身份
 * @author lenovo
 *
 */
public class Identity {
	
	//声明对应的属性
	private int identity_id;//身份的标号，能唯一标识身份状态
	private String identity_name;//身份类型的名称
	
	//定义对应的getter和setter方法
	public int getIdentity_id() {
		return identity_id;
	}
	public void setIdentity_id(int identity_id) {
		this.identity_id = identity_id;
	}
	public String getIdentity_name() {
		return identity_name;
	}
	public void setIdentity_name(String identity_name) {
		this.identity_name = identity_name;
	}
	
	

}
