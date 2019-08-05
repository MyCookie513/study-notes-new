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
		//�������ߵ����λ�ã�application����û�����٣�bean�಻�����destroy������
		//���������÷�����ƽ��йرգ�
		//applicationcontext.getClass().getMethod("close").invoke(applicationcontext);
		((AbstractApplicationContext)applicationcontext).close();
		//���������е����ʱ�������������Ϊ�������������ٺ��������Ϊprototype�����򲻻�������ٺ�����
	}
	
}
