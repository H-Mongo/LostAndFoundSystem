package com.DAO; 
/***
 * 	����Ϊ��Ŀ����ݿ����ӣ���������Ӧ�����ݲ���
 * 	ʹ�õ���MySQL���ݿ�
 * @author lenovo
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtils{
	
	public static Connection conn = null;//���Ӷ���
	public static final String USER = "root";//��¼���ݿ���û���
	public static final String PASSWORD = "root";//��¼���ݿ��Ӧ�û���������
	public static final String DB_URL = "jdbc:mysql://localhost:3306/zhaolingsys";//MySQL���ݿ��λ��
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";//JDBC������
	
	/***
	 * 	�õ��������ݿ�����Ӷ���
	 * @return	�������Ӷ���
	 */
	public static Connection getConnection() {
		try {
			//ע�����ݿ�����
			Class.forName(JDBC_DRIVER);
			//������ݿ����ӳɹ��Ķ���
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			// ���� JDBC ����
			e.printStackTrace();
		} catch (SQLException e) {
			// ���� Class.forName ����
			e.printStackTrace();
		}
		return conn;
	}
	
	/***
	 * 	�ر�������Դ
	 * @param rs	���Ӷ���
	 * @param ps	Ԥ�������
	 * @param conn	���������
	 */
		public static void closeAll(ResultSet rs,PreparedStatement ps,Connection conn){
			try {
				if (rs!=null) {
					rs.close();
				}
				if (ps!=null) {
					ps.close();
				}
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
}
