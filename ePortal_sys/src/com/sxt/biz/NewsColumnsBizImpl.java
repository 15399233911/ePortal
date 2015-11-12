package com.sxt.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.dao.BaseDao;
import com.sxt.entity.Categorys;
import com.sxt.entity.Newscolumns;


@Service("newsColumnsBiz")
public class NewsColumnsBizImpl implements NewsColumnsBiz {
	@Resource BaseDao baseDao;
	@Transactional
	
	
	// �õ�������Ŀ��Ϣ����ҳ
	public List getNewsColumns(int page, int size) {
		return baseDao.getObject("from Newscolumns", page, size);
	}
	
	//�õ��ܼ�¼��
	public int getNewsColumnsCount(){
		return baseDao.getCount("from Newscolumns");
	}
	
	// getNewsColumnsPar�����õ���Ʒ���ඥ������
	public List getNewsColumnsPar(){
		return baseDao.getValue("from Newscolumns where parentid is null");
	}
	
	//ͨ��id�õ�NewsColumns����
	public Newscolumns getNewscolumns(int id) {
		System.out.println(id);
		List list=baseDao.getValue("from Newscolumns where parentid is null and id="+id);
		System.out.println(list.size());
		Newscolumns newsColumns=(Newscolumns) list.get(0);
		return newsColumns;
	}
	
	//���������Ŀ
	@Transactional(propagation=Propagation.REQUIRED)
	public int saveNewsColumns(Object obj) {
		try {
			baseDao.saveObject(obj);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	// ͨ��id�õ���NewsColumns����ɾ��
	@Transactional(propagation=Propagation.REQUIRED)
	public int delNewsColumns(int id) {
		List list=baseDao.getValue("from Newscolumns where id="+id);
		Newscolumns cate=(Newscolumns) list.get(0);
		try{
			baseDao.delObject(cate);
			return 1;
		}catch (Exception e) {
			return 0;
		}
	}
	
	//ͨ��id�õ��޸Ķ����޸�
	@Transactional(propagation=Propagation.REQUIRED)
	public Newscolumns getUpdateNewsColumns(int id) {
		List list=baseDao.getValue("from Newscolumns where id="+id);
		Newscolumns newscolumns=(Newscolumns) list.get(0);
		return newscolumns;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateNewsColumns(Newscolumns newscolumns) {
		try{
			baseDao.updateObject(newscolumns);
			return 1;
		}catch (Exception e) {
			return 0;
		}
	}
}
