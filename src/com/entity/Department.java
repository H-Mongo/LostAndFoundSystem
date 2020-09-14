package com.entity;
/***
 * 	院系类
 * 	主要体现院系的编号和院系名称
 * 	对应用户的院系字段
 * @author lenovo
 *
 */
public class Department {
	
	//声明院系的属性
	private int dept_id;//院系的编号，能唯一标识用户的属性
	private String dept_name;//院系的名称
	
	//定义院系对应属性的getter和setter方法
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	

}
