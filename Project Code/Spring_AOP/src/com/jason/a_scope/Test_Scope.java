package com.jason.a_scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Scope {

	/*singleton
	 * Ĭ��Ϊ��ʵ��ģʽ��ֻ����һ��
	 * com.jason.a_scope.UserService_ʵ����@4386f16
     * com.jason.a_scope.UserService_ʵ����@4386f16
     * 
     * prototype��ʵ��ģʽ
     * com.jason.a_scope.UserService_ʵ����@3c22fc4c
     * com.jason.a_scope.UserService_ʵ����@460d0a57
	 */
	@Test
	void demo01() {
		//��spring�����л��
		//1.�������
		String xmlpath="com/jason/a_scope/Beans.xml";
		ApplicationContext applicationcontext =new ClassPathXmlApplicationContext(xmlpath);
		//2.�������---����Ҫ�Լ�new���Ǵ�spring�����л��
		UserService_ʵ���� user=(UserService_ʵ����) applicationcontext.getBean("userServiceID");
		UserService_ʵ���� user0=(UserService_ʵ����) applicationcontext.getBean("userServiceID");

		System.out.println(user);
		System.out.println(user0);

	}
	
}
