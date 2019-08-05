package com.cn.action;

import java.util.Map;

import org.hibernate.Session;

import com.cn.hibernate_Init.HibernateInitialize;
import com.cn.hibernate_javabean.Ach_information;
import com.cn.hibernate_javabean.Ach_users;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport{
	
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

		// 用户登录 
		@Override
		public String execute() throws Exception {
			int a=Integer.parseInt(username);
			Session session = null;			//声明第一个Session对象
			Ach_users user = null;
			try {
				//Hibernate的持久化操作
				session = HibernateInitialize.getSession();//获取Session
				session.beginTransaction();//事务开启
				 user = (Ach_users) session.get(Ach_users.class, a);//装载对象

				
				
				session.getTransaction().commit();//事务提交
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();//事务回滚
			} finally{
				HibernateInitialize.closeSession();//关闭Session
			}
			if(user.getPassword().equals(password)) {
				ActionContext contextfds =ActionContext.getContext();
				Map session0=(Map) contextfds.getSession();
				session0.put("username", username);
				session0.put("password", password);
				return SUCCESS;
			}else {
				ActionContext contextfds =ActionContext.getContext();
				Map request=(Map) contextfds.get("request");
				request.put("fail","password");
				return ERROR;
				
			}
			
			
					
		}

}
