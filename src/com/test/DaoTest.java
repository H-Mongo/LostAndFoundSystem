package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.DAO.DBUtils;

public class DaoTest {
	
	 
	public static void main(String[] args) {
		Connection conn = null;//�������Ӷ���
		Statement sta = null;
		 ResultSet res = null;//�������������
		 
		 //��ѯ��SQL���
		 String sql = "SELECT user_name,user_tel,user_qq,dept_name,identity_name FROM "
		 		+ "tbl_dept,tbl_user,tbl_identity WHERE tbl_dept.dept_id=tbl_user.dept_id"
		 		+ " AND tbl_user.identity_id=tbl_identity.identity_id";
		 
		//�������ݿ�������
		DBUtils db = new DBUtils();
		//��ȡ���Ӷ���
		conn = db.getConnection();
		if(conn == null) {
			System.out.println("�������ݿ�ʧ��");
		}
		try {
			sta = conn.createStatement();
			//��ý����
			res = sta.executeQuery(sql);
			System.out.println("\t\t�û���"+"\t\t\t��ϵ�绰"+""
					+ "\t\t\tQQ����"+"\t\t\t����Ժϵ"+"\t\t\t������");
			//����������еĽ��
			while(res.next()) {
				//��ò�ѯ�Ľ�����е�Ԫ����Ϣ
				String user_name = res.getString("user_tel");
				String user_tel = res.getString("user_tel");
				String user_qq = res.getString("user_qq");
				String dept_name = res.getString("dept_name");
				String identity_name = res.getString("identity_name");
				
				System.out.println("\t\t"+user_name+"\t\t"+user_tel+"\t\t"+user_qq+"\t\t"+dept_name+"\t\t"+identity_name);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*// ��ɺ�ر�
		res.close();
	    sta.close();
	    conn.close();*/
	}
	
}
