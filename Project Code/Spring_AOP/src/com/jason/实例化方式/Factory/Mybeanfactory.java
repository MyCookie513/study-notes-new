package com.jason.实例化方式.Factory;

public class Mybeanfactory {

	/*
	 * 创建实例
	 */
	public  UserService CreateService() {
		return new UserService_实现类();
	}
	public Mybeanfactory() {
		System.out.println("Mybeanfactory 已经被初始化");
	}
	
	
	
}
