package com.entity;

/**
 * 	��Ʒ��
 * 	�������������Ʒ������������
 * 	�Լ���Ӧ�ķ���
 * @author lenovo
 *
 */
public class Item {
	
	//������Ʒ������
	private int item_id;//��Ʒ�ı�ţ�Ψһ��ʶ��Ӧ����Ʒ��Ϣ
	private String item_name;//��Ʒ������
	private int itemClass_id;//��Ʒ�����
	private String item_img;//��Ʒ��ͼƬ
	private String item_describe;//��Ʒ����������
	private String item_date;//��Ʒ������ʱ��
	private int user_id;//��Ʒ�����ߵ�id
	private String item_status;//��Ʒ��״̬
//	private String itemClass_name;//��Ʒ��������
//	private String user_tel;//��Ʒ�����ߵ���ϵ�绰
//	private String user_qq;//��Ʒ�����ߵ�QQ��ϵ��ʽ 
	//Ĭ�ϵĹ��췽��

	public Item() {
		super();
	}
	
	
	//�Զ����������Ʒ��Ϣ�����ݿ��д���Ĺ��췽��
	public Item(String item_name, int itemClass_id, String item_img, String item_describe, String item_date,
			int user_id, String item_status) {
		super();
		this.item_name = item_name;
		this.itemClass_id = itemClass_id;
		this.item_img = item_img;
		this.item_describe = item_describe;
		this.item_date = item_date;
		this.user_id = user_id;
		this.item_status = item_status;
	}
	


/*	//�Զ����������ʾ��Ʒ��Ϣ�Ĺ��췽��
	public Item(String itemClass_name, String item_name, String item_describe, String item_date, String user_tel,
			String user_qq, String item_status, String item_img) {
		super();
		this.itemClass_name = itemClass_name;
		this.item_name = item_name;
		this.item_describe = item_describe;
		this.item_date = item_date;
		this.user_tel = user_tel;
		this.user_qq = user_qq;
		this.item_status = item_status;
		this.item_img = item_img;
	}
*/


	//������Ʒ��getter��setter����
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getItemClass_id() {
		return itemClass_id;
	}
	public void setItemClass_id(int itemClass_id) {
		this.itemClass_id = itemClass_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_describe() {
		return item_describe;
	}
	public void setItem_describe(String item_describe) {
		this.item_describe = item_describe;
	}
	public String getItem_date() {
		return item_date;
	}
	public void setItem_date(String item_date) {
		this.item_date = item_date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getItem_status() {
		return item_status;
	}
	public void setItem_status(String item_status) {
		this.item_status = item_status;
	}
	public String getItem_img() {
		return item_img;
	}
	public void setItem_img(String item_img) {
		this.item_img = item_img;
	}
	
	
/*
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

	public String getItemClass_name() {
		return itemClass_name;
	}

	public void setItemClass_name(String itemClass_name) {
		this.itemClass_name = itemClass_name;
	}

*/
	
	
	
	
	
}
