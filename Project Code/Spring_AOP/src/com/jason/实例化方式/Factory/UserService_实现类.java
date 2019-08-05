package com.jason.实例化方式.Factory;

public class UserService_实现类  implements UserService {

	@Override
	public void adduser() {
		System.out.println("static_Factory add user");
	}

	
	public UserService_实现类() {
		System.out.println("UserService_实现类 已经被初始化");
	}
	
}
