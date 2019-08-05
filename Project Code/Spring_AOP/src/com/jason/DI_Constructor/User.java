package com.jason.DI_Constructor;

public class User {

	private Integer uid;
	private String username;
	private Integer age;
	private BookDao bookdao;
	public User(Integer uid, String username,BookDao bookdao) {
		
		this.uid = uid;
		this.username = username;
		this.bookdao = bookdao;
		System.out.println("匹配到第一种构造函数的DI\n"+"uid:"+uid+"username"+username+"bookdao:"+bookdao);
	}
	
	public User(String username, Integer age,BookDao bookdao) {
		
		this.username = username;
		this.age = age;
		this.bookdao = bookdao;
		System.out.println("匹配到第二种构造函数的DI"+"age："+age+"username"+username+"bookdao:"+bookdao);
	}
}