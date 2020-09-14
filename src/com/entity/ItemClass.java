package com.entity;
/***
 * 	物品的种类
 * 	定义物品的种类标号和物品种类的名称
 * @author lenovo
 *
 */
public class ItemClass {
	
	//定义对应的属性
	private int itemClass_id;//物品种类的编号
	private String itemClass_name;//物品种类的名称
	
	//属性对应的getter和setter方法
	public int getItemClass_id() {
		return itemClass_id;
	}
	public void setItemClass_id(int itemClass_id) {
		this.itemClass_id = itemClass_id;
	}
	public String getItemClass_name() {
		return itemClass_name;
	}
	public void setItemClass_name(String itemClass_name) {
		this.itemClass_name = itemClass_name;
	}
	
	
	
}
