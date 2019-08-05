package com.cn.hibernate_javabean;

public class Ach_users {

	private int userid;
	private String username;
	private String password;
	private String permission;//х╗оч
	private Ach_information ach_information;
	private String phone;
	
	public Ach_information getAch_information() {
		return ach_information;
	}
	public void setAch_information(Ach_information ach_information) {
		this.ach_information = ach_information;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
