package com.jason.a_ioc;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_IOC {

	
	@Test
	void demo01() {
		//以前的调用方式
       UserService_实现类 user=new UserService_实现类();
       user.adduser();
		
		 
	}
	@Test
	void demo02() {
		//从spring容器中获得
		//1.获得容器
		String xmlpath="com/jason/a_ioc/Beans.xml";
		ApplicationContext applicationcontext =new ClassPathXmlApplicationContext(xmlpath);
		//2.获得内容---不需要自己new都是从spring容器中获得
		UserService_实现类 user=(UserService_实现类) applicationcontext.getBean("userServiceID");
		user.adduser();
	}
	
}
