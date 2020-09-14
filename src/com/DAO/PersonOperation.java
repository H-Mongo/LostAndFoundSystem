package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Exhibition;


/***
 * �ο���
 * ������һ��������
 * ӵ���ο��û��͵�¼�û���ͬ�ķ���
 * @author lenovo
 *
 */
public class PersonOperation {
	
	public List<Exhibition> queryItem(String queryName){
		
		Connection conn = null;//���Ӷ���
		PreparedStatement ps = null;//�������õ�Ԥ�������
		ResultSet rs = null;//���������
		
		//��ѯ�ַ���
		String sql = "SELECT itemClass_name,item_name,item_describe "
				+ "item_date,user_tel,user_qq,item_status FROM "
				+ "tbl_itemClass,tbl_item,tbl_user"
				+ "WHERE tbl_item.itemClass_id=tbl_itemClass.itemClass_id "
				+ "AND tbl_item.user_id=tbl_user.user_id "
				+ "AND tbl_item.item_name=LIKE'%?%";
		//������Ӷ���
		conn = DBUtils.getConnection();
		try {
			//ͨ�����Ӷ�����Ԥ�������
			ps = conn.prepareStatement(sql);
			//ΪSQL����еģ���ֵ
			ps.setString(1, queryName);
			//ִ��SQL���Ĳ�ѯ�����Ѳ�ѯ���Ľ�������ڽ����rs��
			rs = ps.executeQuery();
			List<Exhibition> listExhibition = new ArrayList<Exhibition>(); 
			//ȡ��������еĽ��
			while(rs.next()) {
				//��ò�ѯ�Ľ�����е�Ԫ����Ϣ
				//�����ֶ������λ�ȡ
				String itemClass_name = rs.getString("itemClass_name");
				String item_name = rs.getString("item_name");
				String item_img = rs.getString("item_img");
				String item_describe = rs.getString("item_describe");
				String item_date = rs.getString("item_date");
				String user_tel = rs.getString("user_tel");
				String user_qq = rs.getString("user_qq");
				String item_status = rs.getString("item_status");
				
				//����Ӧ��չʾ��Ϣ��װ����
				//����չʾ��Ʒ��Ϣ�Ķ���
				Exhibition exhibition = new Exhibition(itemClass_name, item_name, item_img, 
						item_describe, item_date, user_tel, user_qq, item_status);
				//����װ�����������ӵ�listExhibition������
				listExhibition.add(exhibition);
			}
			
			//����װ��չʾ��Exhibition����ļ���
			return listExhibition;
			
		} catch (SQLException e) {
			//�׳��쳣�����
			e.printStackTrace();
			return null;
		}finally {
			//�ر�������Դ
			DBUtils.closeAll(rs, ps, conn);
		}
		
		
	}
}
