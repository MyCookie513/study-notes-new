package com.jason.a_ioc;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_IOC {

	
	@Test
	void demo01() {
		//��ǰ�ĵ��÷�ʽ
       UserService_ʵ���� user=new UserService_ʵ����();
       user.adduser();
		
		 
	}
	@Test
	void demo02() {
		//��spring�����л��
		//1.�������
		String xmlpath="com/jason/a_ioc/Beans.xml";
		ApplicationContext applicationcontext =new ClassPathXmlApplicationContext(xmlpath);
		//2.�������---����Ҫ�Լ�new���Ǵ�spring�����л��
		UserService_ʵ���� user=(UserService_ʵ����) applicationcontext.getBean("userServiceID");
		user.adduser();
	}
	
}
