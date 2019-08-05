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

		// �û���¼ 
		@Override
		public String execute() throws Exception {
			int a=Integer.parseInt(username);
			Session session = null;			//������һ��Session����
			Ach_users user = null;
			try {
				//Hibernate�ĳ־û�����
				session = HibernateInitialize.getSession();//��ȡSession
				session.beginTransaction();//������
				 user = (Ach_users) session.get(Ach_users.class, a);//װ�ض���

				
				
				session.getTransaction().commit();//�����ύ
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();//����ع�
			} finally{
				HibernateInitialize.closeSession();//�ر�Session
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
