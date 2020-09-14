package com.realize;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.DBUtils;
import com.DAO.PersonOperation;
import com.entity.Exhibition;
import com.entity.Item;
import com.entity.User;
import com.impl.UserImplement;

/***
 * 	�û���ʵ����
 * 	��Ҫ���û��ӿڶ���ķ�������ʵ��
 * 	����û���Ӧ������
 * @author lenovo
 *
 */
public class UserRealize extends PersonOperation implements UserImplement{
	
	
	 Connection conn = null;//���Ӷ���
	 PreparedStatement ps = null;//�������õ�Ԥ�������
	 ResultSet rs = null;//���������
	 
	 /***
	  * ��ѯ�û��Ƿ����
	  */
	@Override
	public User queryUser(String username, String password,String identityId) {
		//�����תΪ��������
		int identity_id = Integer.parseInt(identityId);
		//�û���ѯ�û��Ƿ������ݿ��д��ڵ�SQL��䣬���е� �� Ϊռλ�����������մ���Ĳ���
		String sql = "SELECT * FROM tbl_user "
				+ "WHERE user_name=? AND user_password=?and identity_id=?";
		
		//����DBUtils�е��෽��
		//��ȡ���Ӷ���
		conn = DBUtils.getConnection();
		//�����ѯ�Ľ��������
		//boolean boo = false;
		try {
			
			 ps = conn.prepareStatement(sql);
			//ΪSQL����е� �� ռλ����ֵ
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, identity_id);
			//����һ���û�����,����Ӧ�������ֶη�װ���������ں���ĻỰ����
			User user = null; 
			//�õ���ѯ�ķ������
			rs = ps.executeQuery();
			while(rs.next()) {
				//��������е�����ȡ����
				//�Ե�¼�û��Ľ��з�װ
				String user_name = rs.getString("user_name");
				String user_password = rs.getString("user_password");
				String user_tel = rs.getString("user_tel");
				String user_qq = rs.getString("user_qq");
				int dept_id = rs.getInt("dept_id");
				int identity_Id = rs.getInt("identity_id");
				user = new User(user_name, user_password, user_tel, user_qq, dept_id, identity_Id);
				
			}
			
			return user;
			
		} catch (SQLException e) {
			// �׳��쳣�����
			e.printStackTrace();
			return null;
		}finally {
			//�ر�������Դ
			DBUtils.closeAll(rs, ps, conn);
		}
		

	}
	
	/**
	 * ��ѯ�û����ĸ�����Ϣ����
	 */
/*	@Override
	public String[] queryUserIfo(User user) {
		
		
		//��ȡ��ǰ��¼���û��ı�ʶ��Ϣ
		String user_name = user.getUser_name();
		String user_password = user.getUser_password();
		int identity_id = user.getIdentity_id();
		int dept_id = user.getDept_id();
		
		//���ڲ�ѯ�û�������Ϣ��SQL���
		String sql = "SELECT identity_name,user_name,dept_name,user_tel,user_qq"
				+ " FROM tbl_identity,tbl_user,tbl_dept WHERE user_name=? AND "
				+ "user_password=? AND identity_id=? AND dept_id=?";

		//����DBUtils�е��෽��
		//��ȡ���Ӷ���
		conn = DBUtils.getConnection();
		//�����ѯ�Ľ��������
		//boolean boo = false;
		try {
			
			 ps = conn.prepareStatement(sql);
			//ΪSQL����е� �� ռλ����ֵ
			ps.setString(1, user_name);
			ps.setString(2, user_password);
			ps.setInt(3, identity_id);
			ps.setInt(4, dept_id);
			
			//����һ�����ڴ洢�û�������Ϣ��String����
			String []userInfo = new String[5];
			
			//�õ���ѯ�ķ������
			rs = ps.executeQuery();
			while(rs.next()) {
				
				
				//��������е�����ȡ����
				String identity_name = rs.getString("identity_name");
				String userName = rs.getString("user_name");
				String dept_name = rs.getString("dept_name");
				String user_tel = rs.getString("user_tel");
				String user_qq = rs.getString("user_qq");
				
				
				//��������е�����ȡ����
				//������ѯ�����û���Ϣ����userInfo������
				userInfo[0] = rs.getString("identity_name");
				userInfo[1] = rs.getString("user_name");
				userInfo[2] = rs.getString("dept_name");
				userInfo[3] = rs.getString("user_tel");
				userInfo[4] = rs.getString("user_qq");
				
			}
			
			return userInfo;
			
		} catch (SQLException e) {
			// �׳��쳣�����
			e.printStackTrace();
			return null;
		}finally {
			//�ر�������Դ
			DBUtils.closeAll(rs, ps, conn);
		}

	}
*/
	
	@Override
	public List<Exhibition> queryReleaseItemInfo(int user_id) {
		
		//���ڲ�ѯ�û���ʷ������¼��SQL��ѯ���
		String sql = "SELECT itemClass_name,item_name,item_img,item_describe,item_date,user_tel," 
					+"user_qq,item_status FROM tbl_itemClass,tbl_item,tbl_user "
					+ "WHERE tbl_itemClass.itemClass_id=tbl_item.itemClass_id"
					+ "AND tbl_item.user_id=?";
		
		//��ȡ���Ӷ���
		conn = DBUtils.getConnection();
		try {
			//ͨ�����Ӷ���õ�Ԥ�������
			ps = conn.prepareStatement(sql);
			//Ϊռλ��?��ֵ
			ps.setInt(1, user_id);
			//ִ��SQL��䣬���õ����������rs
			rs = ps.executeQuery();
			//����һ�� exhibitions ����������װ��ѯ��������Ʒ��Ϣ
			List<Exhibition> exhibitions = new  ArrayList<Exhibition>();
			
			//�����õ��Ľ���������е�����
			while(rs.next()) {
				
				//���ݽ�����е����ݵ��ֶ�����ȡ��������Ϣ
				String itemClass_name = rs.getString("itemClass_name");
				String item_name = rs.getString("item_name");
				String item_img = rs.getString("item_img");
				String item_describe = rs.getString("item_describe");
				String item_date = rs.getString("item_date");
				String user_tel = rs.getString("user_tel");
				String user_qq = rs.getString("user_qq");
				String item_status = rs.getString("item_status"); 
				
				//����һ��Item����������װ��ѯ��������Ʒ��Ϣ
				//����Item�����еĹ��췽�����ж���Ĵ���
				Exhibition exhibition = new Exhibition(itemClass_name, item_name, item_img, 
						item_describe,item_date, user_tel, user_qq, item_status);
				
				//����װ�õĶ���������ӵ�listItem���ϵ���
				exhibitions.add(exhibition);
				
			}
			
			//����װ��Item����ļ���
			return exhibitions;
			
			
		} catch (SQLException e) {
			// �׳��쳣�����
			e.printStackTrace();
			return null;
		}finally {
			//�ر�������Դ
			DBUtils.closeAll(rs, ps, conn);
		}
		
	}

	@Override
	public boolean addItem(Item item) {
		
		//�������ڲ������Ʒ��Ϣ��SQL���
		String sql = "INSERT INTO tbl_item(item_id,item_name,itemClass_id,"
				+ "item_img,item_describe,item_date,user_id,item_status)"
				+ " VALUES(default,?,?,?,?,?,?,?)";
		//������ݿ����Ӷ���
		conn = DBUtils.getConnection();
		try {
			
			//ͨ�����Ӷ�����Ԥ�������
			ps = conn.prepareStatement(sql);
			//ΪSQL����е�ռλ����ֵ
			ps.setString(1, item.getItem_name());
			ps.setInt(2, item.getItemClass_id());
			ps.setString(3, item.getItem_img());
			ps.setString(4, item.getItem_describe());
			ps.setString(5, item.getItem_date());
			ps.setInt(6, item.getUser_id());
			ps.setString(7, item.getItem_status());
			//ִ��SQL��䣬�õ����������
			int flag = ps.executeUpdate();
			
			if(flag != 0) {
				return true;
			}
			
			//�жϽ�������ǹ�������
			
		} catch (SQLException e) {
			// �����쳣�����
			e.printStackTrace();
			return false;
		}finally {
			//�ر�������Դ
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return false;
	}
	
	
	

}
