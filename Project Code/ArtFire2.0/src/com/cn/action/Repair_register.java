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
	private String username;// ά�޼�¼
	private String password;// ������Ϣ
	private String address;//�豸id
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
	private String install_staff;//ά����Ա����
	@Override
	public String execute() throws Exception {
		
		Session session = null;			//������һ��Session����
		try {
			   
		     //* * ���ж��û����Լ��豸��ע����Ϣ
			 // 
			session = HibernateInitialize.getSession();//��ȡSession
			session.beginTransaction();//������
		
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
			
		
			session.getTransaction().commit();//�����ύ
		} catch (Exception e) {
			
			e.printStackTrace();
			session.getTransaction().rollback();//����ع�
			return ERROR;
		} finally{
			HibernateInitialize.closeSession();//�ر�Session
		}
		
		
		return SUCCESS;
		
		
	}
}
