package com.jason.ʵ������ʽ.static_Factory;

public class Mybeanfactory {

	/*
	 * ����ʵ��
	 */
	public static UserService CreateService() {
		return new UserService_ʵ����();
	}
	public Mybeanfactory() {
		System.out.println("Mybeanfactory �Ѿ�����ʼ��");
	}
	
	
	
}
