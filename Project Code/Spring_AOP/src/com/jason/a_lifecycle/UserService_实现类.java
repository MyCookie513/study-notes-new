package com.jason.a_lifecycle;

public class UserService_ʵ����  implements UserService {

	@Override
	public void adduser() {
		System.out.println("Ŀ�귽���ĵ���");
	}

	public void MyInit() {
		System.out.println("UserService_ʵ������ɳ�ʼ��");
	}
	
	public void Mydestroy() {
		System.out.println("UserService_ʵ�����������");
	}
	public UserService_ʵ����() {
		System.out.println("UserService_ʵ���๹�캯���ĵ���");
	}
}
