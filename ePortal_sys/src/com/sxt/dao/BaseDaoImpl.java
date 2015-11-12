package com.sxt.dao;

import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sxt.entity.Merchandise;


@Repository("BaseDao")
public class BaseDaoImpl implements BaseDao {
	@Resource HibernateTemplate hibernateTemplate;
	
	
	//������Ƶ�б������ʾ9����¼
	public List<Merchandise> getMerchandise(final String hql) {
		List list = hibernateTemplate.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(0);
				query.setMaxResults(9);
				List list = query.list();
				return list;
			}
		});
		return list;
	}
	
	//���ݹؼ��ֲ�ѯ�õ����,����ҳ����
	public List getObject(final String hql,final int page,final int size) {
		hibernateTemplate.find(hql);
		List list = hibernateTemplate.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((page-1)*size);
				query.setMaxResults(size);
				List list = query.list();
				return list;
			}
		});
		return list;
	}
	//�õ������size
	public int getCount(String hql){
		return this.hibernateTemplate.find(hql).size();
	}

	//�õ��û���Ϣ
	public List getValue(String hql) {
		return hibernateTemplate.find(hql);
	}
	
	//�������
	public void saveObject(Object obj) {
		hibernateTemplate.save(obj);
	}
	
	//�޸Ķ���
	public void updateObject(Object obj){
		hibernateTemplate.update(obj);
	}

	//ɾ������
	public void delObject(Object obj) {
		hibernateTemplate.delete(obj);
	}
	
	
}
