package com.jason.实例化方式.static_Factory;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_static_factory {

	
	@Test
	public void 以前的用法_create_new() {
		
		UserService	userService=Mybeanfactory.CreateService();
		userService.adduser();
	}
	
	@Test
	public void spring_static_factory_create_new () {
		
		String xmlpath="com/jason/实例化方式/static_Factory/Beans.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlpath);
		System.out.println("xml已经被加载");
		UserService	userService=applicationcontext.getBean("userServiceID", UserService.class);
		userService.adduser();
	}
}
