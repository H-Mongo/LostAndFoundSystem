package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.DAO.DBUtils;

public class DaoTest {
	
	 
	public static void main(String[] args) {
		Connection conn = null;//创建连接对象
		Statement sta = null;
		 ResultSet res = null;//创建结果集对象
		 
		 //查询的SQL语句
		 String sql = "SELECT user_name,user_tel,user_qq,dept_name,identity_name FROM "
		 		+ "tbl_dept,tbl_user,tbl_identity WHERE tbl_dept.dept_id=tbl_user.dept_id"
		 		+ " AND tbl_user.identity_id=tbl_identity.identity_id";
		 
		//创建数据库连接类
		DBUtils db = new DBUtils();
		//获取链接对象
		conn = db.getConnection();
		if(conn == null) {
			System.out.println("连接数据库失败");
		}
		try {
			sta = conn.createStatement();
			//获得结果集
			res = sta.executeQuery(sql);
			System.out.println("\t\t用户名"+"\t\t\t联系电话"+""
					+ "\t\t\tQQ号码"+"\t\t\t所在院系"+"\t\t\t身份类别");
			//遍历结果集中的结果
			while(res.next()) {
				//获得查询的结果集中的元组信息
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
		/*// 完成后关闭
		res.close();
	    sta.close();
	    conn.close();*/
	}
	
}
