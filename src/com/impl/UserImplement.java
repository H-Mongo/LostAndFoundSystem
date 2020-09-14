package com.impl;


import java.util.List;

import com.entity.Exhibition;
import com.entity.Item;
import com.entity.User;

/**
 * 	�û��ӿ�
 *	 ������û��Ĳ����Ͷ���
 *
 * @author lenovo
 *
 */
public interface UserImplement {
	
	/***
	 * 	��ѯ�û��Ƿ����
	 * @param username	�û���
	 * @param password	����
	 * @param identityId	�û������
	 * @return	-1:û�и��û�	0:��ͨ�û�	1:����Ա
	 */
	public abstract User queryUser(String username,String password,String identityId);
	
	/***
	 * 	��ѯ�û����ĸ�����Ϣ����
	 * @param user	��ǰ��¼���û�
	 * @return	���ص�ǰ��¼���û�
	 */
//	public abstract String[] queryUserIfo(User user);
	
	/***
	 * 	��ѯ�û��Լ���������Ʒ��Ϣ�ļ�¼
	 * @param user_id	��ǰ��ѯ�û���id
	 * @return	���ض�Ӧ����Ʒչʾ��Ϣ
	 */
	public abstract List<Exhibition> queryReleaseItemInfo(int user_id);
	
	/****
	 * 	������Ʒ��Ϣ
	 * @param user	������
	 * @return	true �����ɹ�   		false ����ʧ��
	 */
	public abstract boolean addItem(Item item);

}
