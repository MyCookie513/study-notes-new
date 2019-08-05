package com.jason.JDBCTemplate.Domain;

public class User {

	private Integer idt_user ;
	private String t_username ;
	private String t_password ;
	public Integer getIdt_user() {
		return idt_user;
	}
	public void setIdt_user(Integer idt_user) {
		this.idt_user = idt_user;
	}
	public String getT_username() {
		return t_username;
	}
	public void setT_username(String t_username) {
		this.t_username = t_username;
	}
	public String getT_password() {
		return t_password;
	}
	public void setT_password(String t_password) {
		this.t_password = t_password;
	}
	@Override
	public String toString() {
		return "User [idt_user=" + idt_user + ", t_username=" + t_username + ", t_password=" + t_password + "]";
	}

	
	
}
