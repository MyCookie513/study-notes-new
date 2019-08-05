package com.jason.a_scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Scope {

	/*singleton
	 * 默认为单实例模式，只创建一次
	 * com.jason.a_scope.UserService_实现类@4386f16
     * com.jason.a_scope.UserService_实现类@4386f16
     * 
     * prototype多实例模式
     * com.jason.a_scope.UserService_实现类@3c22fc4c
     * com.jason.a_scope.UserService_实现类@460d0a57
	 */
	@Test
	void demo01() {
		//从spring容器中获得
		//1.获得容器
		String xmlpath="com/jason/a_scope/Beans.xml";
		ApplicationContext applicationcontext =new ClassPathXmlApplicationContext(xmlpath);
		//2.获得内容---不需要自己new都是从spring容器中获得
		UserService_实现类 user=(UserService_实现类) applicationcontext.getBean("userServiceID");
		UserService_实现类 user0=(UserService_实现类) applicationcontext.getBean("userServiceID");

		System.out.println(user);
		System.out.println(user0);

	}
	
}
