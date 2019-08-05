package com.jason.a_lifecycle;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_life {

	
	
	@Test
	void demo01() throws Exception {
	
		String xmlpath="com/jason/a_lifecycle/Beans.xml";
		ApplicationContext applicationcontext =new ClassPathXmlApplicationContext(xmlpath);
		UserService user= (UserService) applicationcontext.getBean("userServiceID");
		user.adduser();
		//当程序走到这个位置，application容器没有销毁，bean类不会调用destroy方法的
		//下面是利用反射机制进行关闭；
		//applicationcontext.getClass().getMethod("close").invoke(applicationcontext);
		((AbstractApplicationContext)applicationcontext).close();
		//当程序运行到这的时候，如果是作用域为单例则会调用销毁函数，如果为prototype多例则不会调用销毁函数；
	}
	
}
