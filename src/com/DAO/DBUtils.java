package com.DAO; 
/***
 * 	该类为项目搭建数据库连接，并作出对应的数据操作
 * 	使用的是MySQL数据库
 * @author lenovo
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtils{
	
	public static Connection conn = null;//连接对象
	public static final String USER = "root";//登录数据库的用户名
	public static final String PASSWORD = "root";//登录数据库对应用户名的密码
	public static final String DB_URL = "jdbc:mysql://localhost:3306/zhaolingsys";//MySQL数据库的位置
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";//JDBC驱动名
	
	/***
	 * 	得到连接数据库的连接对象
	 * @return	返回连接对象
	 */
	public static Connection getConnection() {
		try {
			//注册数据库驱动
			Class.forName(JDBC_DRIVER);
			//获得数据库连接成功的对象
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			// 处理 JDBC 错误
			e.printStackTrace();
		} catch (SQLException e) {
			// 处理 Class.forName 错误
			e.printStackTrace();
		}
		return conn;
	}
	
	/***
	 * 	关闭所有资源
	 * @param rs	连接对象
	 * @param ps	预编译对象
	 * @param conn	结果集对象
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
