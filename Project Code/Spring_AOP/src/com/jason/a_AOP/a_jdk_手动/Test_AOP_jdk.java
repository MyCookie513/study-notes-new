package com.jason.a_AOP.a_jdk_�ֶ�;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_AOP_jdk {

	
   public static void main(String[] args) {
	   String xmlpath="com/jason/a_AOP/a_jdk_�ֶ�/Beans.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlpath);
		System.out.println("xml�Ѿ�������");
		Target	target=(Target) applicationcontext.getBean("TargetID");
		target.dao();
		target.service();
    }
	
	@Test
	public void Test_AOP_new () {
		String xmlpath="com/jason/a_AOP/�ֶ�/Beans.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlpath);
		System.out.println("xml�Ѿ�������");
		Target	target=(Target) applicationcontext.getBean("TargetID");
		target.dao();
		target.service();
		
	}
}
