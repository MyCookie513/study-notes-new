package com.cn.action;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;

import com.cn.hibernate_Init.HibernateInitialize;
import com.cn.hibernate_javabean.Ach_information;
import com.cn.hibernate_javabean.Ach_repair;
import com.cn.hibernate_javabean.Ach_users;
import com.cn.hibernate_javabean.Ach_wifi_data_01;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String username;// 用户名
	private String password;// 密码
	private String confirm_password;// 密码
	private String address;
	private String type;
	private String touch_screen;
	private String install_staff;
	private String phone;
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTouch_screen() {
		return touch_screen;
	}
	public void setTouch_screen(String touch_screen) {
		this.touch_screen = touch_screen;
	}
	public String getInstall_staff() {
		return install_staff;
	}
	public void setInstall_staff(String install_staff) {
		this.install_staff = install_staff;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	// 用户登录 
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
		
				
	}
	
	public String register() {
		
		Session session = null;			//声明第一个Session对象
		try {
			   
		     //* * 进行对用户名以及设备的注册信息
			 // 
			session = HibernateInitialize.getSession();//获取Session
			session.beginTransaction();//事务开启
			Ach_users ach_user=new Ach_users();
			ach_user.setUsername(username);
			ach_user.setPassword(confirm_password);
			ach_user.setPermission("normal");
			ach_user.setPhone(phone);
			Ach_information ach_information=new Ach_information();
			
			Date date = new Date();
			Timestamp install_time = new Timestamp(date.getTime());
			ach_information.setInstall_time(install_time);
			ach_user.setAch_information(ach_information);
			ach_information.setAch_users(ach_user);
			ach_information.setAddress(address);
			ach_information.setTouch_screen(touch_screen);
			ach_information.setType(type);
			ach_information.setInstall_staff(install_staff);
			
			session.save(ach_information);
			
		
			ActionContext contextfds =ActionContext.getContext();
			Map request=(Map) contextfds.get("request");
			request.put("Account",ach_information.getAch_ID());
			//System.out.println(ach_information.getAch_ID());
			session.getTransaction().commit();//事务提交
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();//事务回滚
		} finally{
			HibernateInitialize.closeSession();//关闭Session
		}
		
		
		return SUCCESS;
		
		
	}
	
	
	
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
}
