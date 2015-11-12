package com.sxt.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.entity.Newscolumns;


public interface NewsColumnsBiz {
	
	//�õ�������Ŀ��Ϣ����ҳ
	public List getNewsColumns(int page, int size);
	//�õ��ܼ�¼��
	public int getNewsColumnsCount();
	//���������Ŀ
	public int saveNewsColumns(Object object);
	// getNewsColumnsPar�����õ���Ʒ���ඥ������
	public List getNewsColumnsPar();
	//ͨ��id�õ�NewsColumns����
	public Newscolumns getNewscolumns(int id);
	// ͨ��id�õ���NewsColumns����ɾ��
	public int delNewsColumns(int id);
	//ͨ��id�õ��޸Ķ���
	public Newscolumns getUpdateNewsColumns(int id);
	//�޸Ķ���
	public int updateNewsColumns(Newscolumns newscolumns);
}
