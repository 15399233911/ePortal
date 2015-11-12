package com.sxt.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.entity.Newscolumns;


public interface NewsColumnsBiz {
	
	//得到新闻栏目信息并分页
	public List getNewsColumns(int page, int size);
	//得到总记录数
	public int getNewsColumnsCount();
	//添加新闻栏目
	public int saveNewsColumns(Object object);
	// getNewsColumnsPar方法得到商品分类顶级分类
	public List getNewsColumnsPar();
	//通过id得到NewsColumns对象
	public Newscolumns getNewscolumns(int id);
	// 通过id得到、NewsColumns对象并删除
	public int delNewsColumns(int id);
	//通过id得到修改对象
	public Newscolumns getUpdateNewsColumns(int id);
	//修改对象
	public int updateNewsColumns(Newscolumns newscolumns);
}
