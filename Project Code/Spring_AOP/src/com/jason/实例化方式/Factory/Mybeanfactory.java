package com.jason.ʵ������ʽ.Factory;

public class Mybeanfactory {

	/*
	 * ����ʵ��
	 */
	public  UserService CreateService() {
		return new UserService_ʵ����();
	}
	public Mybeanfactory() {
		System.out.println("Mybeanfactory �Ѿ�����ʼ��");
	}
	
	
	
}
