package com.entity;
/***
 * 	չʾ��
 * 	����ҳ����ʾ��Ʒ��Ӧ��Ϣ����
 * 	����չʾʱ��Ӧ��ʾ������
 * @author lenovo
 *
 */
public class Exhibition {

	//�����Ӧ������
	private String itemClass_name;//���
	private String item_name;//��Ʒ����
	private String item_img;//��ƷͼƬ
	private String item_describe;//��Ʒ���� 
	private String item_date;//����ʱ��
	private String user_tel;//��ϵ����ϵ�绰 
	private String user_qq;//��ϵ��QQ
	private String item_status;//��Ʒ״̬
	
	
	//�Զ�������ڷ�װչʾ��Ʒ�Ĺ��췽��
		public Exhibition(String itemClass_name, String item_name, String item_img, String item_describe, String item_date,
				String user_tel, String user_qq, String item_status) {
			super();
			this.itemClass_name = itemClass_name;
			this.item_name = item_name;
			this.item_img = item_img;
			this.item_describe = item_describe;
			this.item_date = item_date;
			this.user_tel = user_tel;
			this.user_qq = user_qq;
			this.item_status = item_status;
		}
		
	
	
	//��Ӧ���Ե�getter��setter����
	public String getItemClass_name() {
		return itemClass_name;
	}
	public void setItemClass_name(String itemClass_name) {
		this.itemClass_name = itemClass_name;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_img() {
		return item_img;
	}
	public void setItem_img(String item_img) {
		this.item_img = item_img;
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
	public String getItem_status() {
		return item_status;
	}
	public void setItem_status(String item_status) {
		this.item_status = item_status;
	}
	
	
	
	
}