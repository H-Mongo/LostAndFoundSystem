package com.impl;


import java.util.List;

import com.entity.Exhibition;
import com.entity.Item;
import com.entity.User;

/**
 * 	用户接口
 *	 抽象出用户的操作和动作
 *
 * @author lenovo
 *
 */
public interface UserImplement {
	
	/***
	 * 	查询用户是否存在
	 * @param username	用户名
	 * @param password	密码
	 * @param identityId	用户的身份
	 * @return	-1:没有该用户	0:普通用户	1:管理员
	 */
	public abstract User queryUser(String username,String password,String identityId);
	
	/***
	 * 	查询用户到的个人信息资料
	 * @param user	当前登录的用户
	 * @return	返回当前登录的用户
	 */
//	public abstract String[] queryUserIfo(User user);
	
	/***
	 * 	查询用户自己发布的物品信息的记录
	 * @param user_id	当前查询用户的id
	 * @return	返回对应的物品展示信息
	 */
	public abstract List<Exhibition> queryReleaseItemInfo(int user_id);
	
	/****
	 * 	发布物品信息
	 * @param user	发布者
	 * @return	true 发布成功   		false 发布失败
	 */
	public abstract boolean addItem(Item item);

}
