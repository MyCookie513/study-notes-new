package com.cn.hibernate_javabean;

import java.sql.Timestamp;
import java.util.Set;

public class Ach_information {

	
	private int ach_ID;
	private String install_company;
	private Timestamp  install_time;
	private String install_staff;//安装人员
	private String address;	
	private String type;;
	private String touch_screen;
	private Ach_users ach_users;
	private Set<Ach_wifi_data_01> ach_wifi_data_01;//保存的是一个壁炉所对应的所有实时数据
	private Set<Ach_repair> ach_repair;
	public Set<Ach_repair> getAch_repair() {
		return ach_repair;
	}
	public void setAch_repair(Set<Ach_repair> ach_repair) {
		this.ach_repair = ach_repair;
	}
	public Set<Ach_wifi_data_01> getAch_wifi_data_01() {
		return ach_wifi_data_01;
	}
	public void setAch_wifi_data_01(Set<Ach_wifi_data_01> ach_wifi_data_01) {
		this.ach_wifi_data_01 = ach_wifi_data_01;
	}
	public int getAch_ID() {
		return ach_ID;
	}
	public void setAch_ID(int ach_ID) {
		this.ach_ID = ach_ID;
	}
	public String getInstall_company() {
		return install_company;
	}
	public void setInstall_company(String install_company) {
		this.install_company = install_company;
	}
	public Timestamp getInstall_time() {
		return install_time;
	}
	public void setInstall_time(Timestamp install_time) {
		this.install_time = install_time;
	}
	public String getInstall_staff() {
		return install_staff;
	}
	public void setInstall_staff(String install_staff) {
		this.install_staff = install_staff;
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
	public Ach_users getAch_users() {
		return ach_users;
	}
	public void setAch_users(Ach_users ach_users) {
		this.ach_users = ach_users;
	}
	
	
	
	
	
	
}
