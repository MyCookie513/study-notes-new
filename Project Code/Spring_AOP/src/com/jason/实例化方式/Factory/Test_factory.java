package com.jason.实例化方式.Factory;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_factory {

	/*
	 * 和配置文件里面的命令也是同样的
	 */
	@Test
	public void 以前的用法_create_new() {
		//1.建造实例工厂；
		//2.然后工厂生产一个实例；
		//3.调用需要的实例对象
		Mybeanfactory mybeanfactory=new Mybeanfactory();
		UserService	userService=mybeanfactory.CreateService();
		userService.adduser();
	}
	
	@Test
	public void spring_factory_create_new () {
		
		String xmlpath="com/jason/实例化方式/Factory/Beans.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlpath);
		System.out.println("xml已经被加载");
		UserService	userService=applicationcontext.getBean("UserServiceID", UserService.class);
		userService.adduser();
	}
	
	
	
	
	
	
	
	
}
