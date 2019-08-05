package com.jason.ʵ������ʽ.static_Factory;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_static_factory {

	
	@Test
	public void ��ǰ���÷�_create_new() {
		
		UserService	userService=Mybeanfactory.CreateService();
		userService.adduser();
	}
	
	@Test
	public void spring_static_factory_create_new () {
		
		String xmlpath="com/jason/ʵ������ʽ/static_Factory/Beans.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlpath);
		System.out.println("xml�Ѿ�������");
		UserService	userService=applicationcontext.getBean("userServiceID", UserService.class);
		userService.adduser();
	}
}
