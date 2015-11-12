package com.sxt.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sxt.biz.NewsColumnsBiz;
import com.sxt.entity.Categorys;
import com.sxt.entity.Newscolumns;


@Controller
public class NewsColumnsAction extends ActionSupport{
	@Resource NewsColumnsBiz newsColumnsBiz;
	private int page = 1;
	private int size = 15;
	private int count;
	private int total;
	private List list;
	private Newscolumns newscolumns;
	private String message;
	private int id;
	private String columnname;
	private String columncode;
	
	
	
	
	public Newscolumns getNewscolumns() {
		return newscolumns;
	}
	public void setNewscolumns(Newscolumns newscolumns) {
		this.newscolumns = newscolumns;
	}
	public String getColumnname() {
		return columnname;
	}
	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}
	public String getColumncode() {
		return columncode;
	}
	public void setColumncode(String columncode) {
		this.columncode = columncode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Newscolumns getNewsColumns() {
		return newscolumns;
	}
	public void setNewsColumns(Newscolumns newsColumns) {
		this.newscolumns = newsColumns;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	
	//新闻栏目管理----->新闻栏目列表
	@Action(value="newsColumns",results={@Result(name="success",location="/WEB-INF/jsp/newsColumnsManage.jsp")})
	public String newsColumn() throws Exception{
		count=newsColumnsBiz.getNewsColumnsCount();
		total=count%size == 0 ? count/size:(count/size+1);
		list=newsColumnsBiz.getNewsColumns(page, size);
		return SUCCESS;
	}
	
	//新闻栏目管理----->得到新闻栏目最高级分类
	@Action(value="getNewsColumnPer",results={@Result(name="success",location="/WEB-INF/jsp/addNewsColumns.jsp")})
	public String getNewsColumnPer() throws Exception{
		list=newsColumnsBiz.getNewsColumnsPar();
		return SUCCESS;
	}
	//新闻栏目管理----->添加新闻栏目
	@Action(value="addNewsColumns",results={@Result(name="success",location="newsColumns",type="redirectAction"),@Result(name="error",location="/WEB-INF/jsp/addNewsColumns.jsp")})
	public String addnewsColumn() throws Exception{

		if(id != 0){
			Newscolumns newsCol=newsColumnsBiz.getNewscolumns(id);
			Newscolumns newscol1=new Newscolumns();
			newscol1.setNewscolumns(newsCol);
			newscol1.setColumnname(columnname);
			newscol1.setColumncode(columncode);
			if(newsColumnsBiz.saveNewsColumns(newscol1) == 1){
				return SUCCESS;
			}
		}
		if(id == 0){
			Newscolumns newscol1=new Newscolumns();
			newscol1.setNewscolumns(null);
			newscol1.setColumnname(columnname);
			newscol1.setColumncode(columncode);
			if(newsColumnsBiz.saveNewsColumns(newscol1) == 1){
				return SUCCESS;
			}
		}
		message="添加新闻栏目失败！";
		return ERROR;
	}
	//删除新闻栏目
	@Action(value="deleteNewsColumns",results={@Result(name="success",location="newsColumns",type="redirectAction")})
	public String deleteCategorys() throws Exception{
		int res=newsColumnsBiz.delNewsColumns(id);
		if(res==1){
			return SUCCESS;
		}else{
			message="删除失败！";
			return ERROR;
		}
	}
	//修改新闻栏目
	@Action(value="updateNewsColumns",results={@Result(name="success",location="/WEB-INF/jsp/updateNewsColumns.jsp")})
	public String updateCategorys() throws Exception{
		list=newsColumnsBiz.getNewsColumnsPar();
		newscolumns=newsColumnsBiz.getUpdateNewsColumns(id);
		System.out.println("newscolumns---->"+newscolumns.getColumnname());
		return SUCCESS;
	}
	
	@Action(value="submitUpdate",results={@Result(name="success",location="newsColumns",type="redirectAction"),@Result(name="error",location="updateNewsColumns",type="redirectAction")})
	public String submitUpdate() throws Exception{
		System.out.println("id---->"+id);
		int res=newsColumnsBiz.updateNewsColumns(newscolumns);
		if(res==1){
			return SUCCESS;
		}else{
			message="修改失败！";
			return ERROR;
		}
	}
}
