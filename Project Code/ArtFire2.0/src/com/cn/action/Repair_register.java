package com.cn.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.hibernate.Session;

import com.cn.hibernate_Init.HibernateInitialize;
import com.cn.hibernate_javabean.Ach_information;
import com.cn.hibernate_javabean.Ach_repair;
import com.cn.hibernate_javabean.Ach_users;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Repair_register extends ActionSupport{
	private String username;// 维修记录
	private String password;// 报警信息
	private String address;//设备id
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInstall_staff() {
		return install_staff;
	}
	public void setInstall_staff(String install_staff) {
		this.install_staff = install_staff;
	}
	private String install_staff;//维修人员姓名
	@Override
	public String execute() throws Exception {
		
		Session session = null;			//声明第一个Session对象
		try {
			   
		     //* * 进行对用户名以及设备的注册信息
			 // 
			session = HibernateInitialize.getSession();//获取Session
			session.beginTransaction();//事务开启
		
			Ach_repair ach_repair=new Ach_repair();
			
			Date date = new Date();
			Timestamp install_time = new Timestamp(date.getTime());
			Ach_information ach_information=new Ach_information();
			ach_information.setAch_ID(new Integer(address));
			ach_repair.setAch_information(ach_information);
			ach_repair.setAlert_time(install_time);
			ach_repair.setMaintain_staff(install_staff);
			ach_repair.setMaintain_status(username);
			ach_repair.setAlert_infor(password);
			session.save(ach_repair);
			
		
			session.getTransaction().commit();//事务提交
		} catch (Exception e) {
			
			e.printStackTrace();
			session.getTransaction().rollback();//事务回滚
			return ERROR;
		} finally{
			HibernateInitialize.closeSession();//关闭Session
		}
		
		
		return SUCCESS;
		
		
	}
}
