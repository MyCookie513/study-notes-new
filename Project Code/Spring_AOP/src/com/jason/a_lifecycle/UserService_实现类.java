package com.jason.a_lifecycle;

public class UserService_实现类  implements UserService {

	@Override
	public void adduser() {
		System.out.println("目标方法的调用");
	}

	public void MyInit() {
		System.out.println("UserService_实现类完成初始化");
	}
	
	public void Mydestroy() {
		System.out.println("UserService_实现类完成销毁");
	}
	public UserService_实现类() {
		System.out.println("UserService_实现类构造函数的调用");
	}
}
