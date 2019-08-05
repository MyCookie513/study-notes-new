package com.jason.ʵ������ʽ.Factory;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_factory {

	/*
	 * �������ļ����������Ҳ��ͬ����
	 */
	@Test
	public void ��ǰ���÷�_create_new() {
		//1.����ʵ��������
		//2.Ȼ�󹤳�����һ��ʵ����
		//3.������Ҫ��ʵ������
		Mybeanfactory mybeanfactory=new Mybeanfactory();
		UserService	userService=mybeanfactory.CreateService();
		userService.adduser();
	}
	
	@Test
	public void spring_factory_create_new () {
		
		String xmlpath="com/jason/ʵ������ʽ/Factory/Beans.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlpath);
		System.out.println("xml�Ѿ�������");
		UserService	userService=applicationcontext.getBean("UserServiceID", UserService.class);
		userService.adduser();
	}
	
	
	
	
	
	
	
	
}
