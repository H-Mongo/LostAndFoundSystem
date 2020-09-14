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
 * 	用户的实现类
 * 	主要对用户接口定义的方法进行实现
 * 	完成用户对应的需求
 * @author lenovo
 *
 */
public class UserRealize extends PersonOperation implements UserImplement{
	
	
	 Connection conn = null;//连接对象
	 PreparedStatement ps = null;//创建并得到预编译对象
	 ResultSet rs = null;//结果集对象
	 
	 /***
	  * 查询用户是否存在
	  */
	@Override
	public User queryUser(String username, String password,String identityId) {
		//将身份转为整型数字
		int identity_id = Integer.parseInt(identityId);
		//用户查询用户是否在数据库中存在的SQL语句，其中的 ？ 为占位符，用来接收传入的参数
		String sql = "SELECT * FROM tbl_user "
				+ "WHERE user_name=? AND user_password=?and identity_id=?";
		
		//调用DBUtils中的类方法
		//获取连接对象
		conn = DBUtils.getConnection();
		//保存查询的结果并返回
		//boolean boo = false;
		try {
			
			 ps = conn.prepareStatement(sql);
			//为SQL语句中的 ？ 占位符赋值
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, identity_id);
			//创建一个用户对象,将对应的属性字段封装起来，用于后面的会话操作
			User user = null; 
			//得到查询的反馈结果
			rs = ps.executeQuery();
			while(rs.next()) {
				//将结果集中的数据取出来
				//对登录用户的进行封装
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
			// 抛出异常后结束
			e.printStackTrace();
			return null;
		}finally {
			//关闭所有资源
			DBUtils.closeAll(rs, ps, conn);
		}
		

	}
	
	/**
	 * 查询用户到的个人信息资料
	 */
/*	@Override
	public String[] queryUserIfo(User user) {
		
		
		//获取当前登录的用户的标识信息
		String user_name = user.getUser_name();
		String user_password = user.getUser_password();
		int identity_id = user.getIdentity_id();
		int dept_id = user.getDept_id();
		
		//用于查询用户个人信息的SQL语句
		String sql = "SELECT identity_name,user_name,dept_name,user_tel,user_qq"
				+ " FROM tbl_identity,tbl_user,tbl_dept WHERE user_name=? AND "
				+ "user_password=? AND identity_id=? AND dept_id=?";

		//调用DBUtils中的类方法
		//获取连接对象
		conn = DBUtils.getConnection();
		//保存查询的结果并返回
		//boolean boo = false;
		try {
			
			 ps = conn.prepareStatement(sql);
			//为SQL语句中的 ？ 占位符赋值
			ps.setString(1, user_name);
			ps.setString(2, user_password);
			ps.setInt(3, identity_id);
			ps.setInt(4, dept_id);
			
			//创建一个用于存储用户个人信息的String数组
			String []userInfo = new String[5];
			
			//得到查询的反馈结果
			rs = ps.executeQuery();
			while(rs.next()) {
				
				
				//将结果集中的数据取出来
				String identity_name = rs.getString("identity_name");
				String userName = rs.getString("user_name");
				String dept_name = rs.getString("dept_name");
				String user_tel = rs.getString("user_tel");
				String user_qq = rs.getString("user_qq");
				
				
				//将结果集中的数据取出来
				//并将查询到的用户信息存入userInfo数组中
				userInfo[0] = rs.getString("identity_name");
				userInfo[1] = rs.getString("user_name");
				userInfo[2] = rs.getString("dept_name");
				userInfo[3] = rs.getString("user_tel");
				userInfo[4] = rs.getString("user_qq");
				
			}
			
			return userInfo;
			
		} catch (SQLException e) {
			// 抛出异常后结束
			e.printStackTrace();
			return null;
		}finally {
			//关闭所有资源
			DBUtils.closeAll(rs, ps, conn);
		}

	}
*/
	
	@Override
	public List<Exhibition> queryReleaseItemInfo(int user_id) {
		
		//用于查询用户历史发布记录的SQL查询语句
		String sql = "SELECT itemClass_name,item_name,item_img,item_describe,item_date,user_tel," 
					+"user_qq,item_status FROM tbl_itemClass,tbl_item,tbl_user "
					+ "WHERE tbl_itemClass.itemClass_id=tbl_item.itemClass_id"
					+ "AND tbl_item.user_id=?";
		
		//获取连接对象
		conn = DBUtils.getConnection();
		try {
			//通过连接对象得到预编译对象
			ps = conn.prepareStatement(sql);
			//为占位符?赋值
			ps.setInt(1, user_id);
			//执行SQL语句，并得到结果集对象rs
			rs = ps.executeQuery();
			//创建一个 exhibitions 对象，用来封装查询出来的物品信息
			List<Exhibition> exhibitions = new  ArrayList<Exhibition>();
			
			//遍历得到的结果集对象中的数据
			while(rs.next()) {
				
				//根据结果集中的数据的字段依次取出数据信息
				String itemClass_name = rs.getString("itemClass_name");
				String item_name = rs.getString("item_name");
				String item_img = rs.getString("item_img");
				String item_describe = rs.getString("item_describe");
				String item_date = rs.getString("item_date");
				String user_tel = rs.getString("user_tel");
				String user_qq = rs.getString("user_qq");
				String item_status = rs.getString("item_status"); 
				
				//创建一个Item对象，用来封装查询出来的物品信息
				//利用Item中已有的构造方法进行对象的创建
				Exhibition exhibition = new Exhibition(itemClass_name, item_name, item_img, 
						item_describe,item_date, user_tel, user_qq, item_status);
				
				//将封装好的对象依次添加到listItem集合当中
				exhibitions.add(exhibition);
				
			}
			
			//返回装有Item对象的集合
			return exhibitions;
			
			
		} catch (SQLException e) {
			// 抛出异常后结束
			e.printStackTrace();
			return null;
		}finally {
			//关闭所有资源
			DBUtils.closeAll(rs, ps, conn);
		}
		
	}

	@Override
	public boolean addItem(Item item) {
		
		//定义用于插入的物品信息的SQL语句
		String sql = "INSERT INTO tbl_item(item_id,item_name,itemClass_id,"
				+ "item_img,item_describe,item_date,user_id,item_status)"
				+ " VALUES(default,?,?,?,?,?,?,?)";
		//获得数据库连接对象
		conn = DBUtils.getConnection();
		try {
			
			//通过连接对象获得预编译对象
			ps = conn.prepareStatement(sql);
			//为SQL语句中的占位符赋值
			ps.setString(1, item.getItem_name());
			ps.setInt(2, item.getItemClass_id());
			ps.setString(3, item.getItem_img());
			ps.setString(4, item.getItem_describe());
			ps.setString(5, item.getItem_date());
			ps.setInt(6, item.getUser_id());
			ps.setString(7, item.getItem_status());
			//执行SQL语句，得到结果集对象
			int flag = ps.executeUpdate();
			
			if(flag != 0) {
				return true;
			}
			
			//判断结果集中是够有数据
			
		} catch (SQLException e) {
			// 发生异常后结束
			e.printStackTrace();
			return false;
		}finally {
			//关闭所有资源
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return false;
	}
	
	
	

}
