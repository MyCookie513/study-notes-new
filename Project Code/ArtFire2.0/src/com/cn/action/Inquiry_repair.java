package com.cn.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cn.hibernate_Init.HibernateInitialize;
import com.cn.hibernate_javabean.Ach_repair;
import com.cn.hibernate_javabean.Ach_users;
import com.cn.hibernate_javabean.Ach_wifi_data_01;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Inquiry_repair extends ActionSupport{

	
	private	String id;
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String execute() throws Exception {
		ActionContext contextfds =ActionContext.getContext();
		Map session0=(Map) contextfds.getSession();
		Map request=(Map) contextfds.get("request");
		String username=(String) session0.get("username");
		String password=(String) session0.get("password");
		//String date=request.get("nocache").toString();
		
		if(username==null)
			return ERROR;
		int ach_ID=Integer.parseInt(username);
		Session session = null;			//声明第一个Session对象
		Ach_repair repair = null;
		try {
			//Hibernate的持久化操作
			session = HibernateInitialize.getSession();//获取Session
			
			String hql = " from Ach_repair repair  where repair.ach_information.ach_ID=:ach_ID order by repair.ID desc";
			 
			 Query query = session.createQuery(hql);
			 query.setParameter("ach_ID",new Integer(id));
			 System.out.println(id);
		    /* query.setFirstResult(0);
		     query.setMaxResults(1);*/
		     List<Ach_repair> repair_list = query.list();
		     
		      request.put("repair_list",repair_list);
		        	
		        	
		        
	
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();//事务回滚
		} finally{
			HibernateInitialize.closeSession();//关闭Session
		}

			return SUCCESS;
		
				
	}
}
