package com.sxt.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sxt.entity.Merchandise;


@Repository("baseDao")
public interface BaseDao {
	//商品视频列表
	public List<Merchandise> getMerchandise(final String hql);
	//下拉菜单+关键字   搜索，查询记录分页
	public List getObject(String hql,int page,int size);
	//得到总记录数
	public int getCount(String hql);
	//得到user
	public List getValue(String hql);
	//修改对象
	public void updateObject(Object obj);
	//保存对象
	public void saveObject(Object obj);
	//删除对象
	public void delObject(Object obj);
}
