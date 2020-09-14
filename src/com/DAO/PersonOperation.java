package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Exhibition;


/***
 * 游客类
 * 该类是一个抽象类
 * 拥有游客用户和登录用户共同的方法
 * @author lenovo
 *
 */
public class PersonOperation {
	
	public List<Exhibition> queryItem(String queryName){
		
		Connection conn = null;//连接对象
		PreparedStatement ps = null;//创建并得到预编译对象
		ResultSet rs = null;//结果集对象
		
		//查询字符串
		String sql = "SELECT itemClass_name,item_name,item_describe "
				+ "item_date,user_tel,user_qq,item_status FROM "
				+ "tbl_itemClass,tbl_item,tbl_user"
				+ "WHERE tbl_item.itemClass_id=tbl_itemClass.itemClass_id "
				+ "AND tbl_item.user_id=tbl_user.user_id "
				+ "AND tbl_item.item_name=LIKE'%?%";
		//获得连接对象
		conn = DBUtils.getConnection();
		try {
			//通过连接对象获得预编译对象
			ps = conn.prepareStatement(sql);
			//为SQL语句中的？赋值
			ps.setString(1, queryName);
			//执行SQL语句的查询，并把查询到的结果保存在结果集rs中
			rs = ps.executeQuery();
			List<Exhibition> listExhibition = new ArrayList<Exhibition>(); 
			//取出结果集中的结果
			while(rs.next()) {
				//获得查询的结果集中的元组信息
				//根据字段名依次获取
				String itemClass_name = rs.getString("itemClass_name");
				String item_name = rs.getString("item_name");
				String item_img = rs.getString("item_img");
				String item_describe = rs.getString("item_describe");
				String item_date = rs.getString("item_date");
				String user_tel = rs.getString("user_tel");
				String user_qq = rs.getString("user_qq");
				String item_status = rs.getString("item_status");
				
				//将对应的展示信息封装起来
				//创建展示物品信息的对象
				Exhibition exhibition = new Exhibition(itemClass_name, item_name, item_img, 
						item_describe, item_date, user_tel, user_qq, item_status);
				//将封装后对象依次添加到listExhibition集合中
				listExhibition.add(exhibition);
			}
			
			//返回装有展示类Exhibition对象的集合
			return listExhibition;
			
		} catch (SQLException e) {
			//抛出异常后结束
			e.printStackTrace();
			return null;
		}finally {
			//关闭所有资源
			DBUtils.closeAll(rs, ps, conn);
		}
		
		
	}
}
