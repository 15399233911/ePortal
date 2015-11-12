package com.sxt.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sxt.entity.Merchandise;


@Repository("baseDao")
public interface BaseDao {
	//��Ʒ��Ƶ�б�
	public List<Merchandise> getMerchandise(final String hql);
	//�����˵�+�ؼ���   ��������ѯ��¼��ҳ
	public List getObject(String hql,int page,int size);
	//�õ��ܼ�¼��
	public int getCount(String hql);
	//�õ�user
	public List getValue(String hql);
	//�޸Ķ���
	public void updateObject(Object obj);
	//�������
	public void saveObject(Object obj);
	//ɾ������
	public void delObject(Object obj);
}
