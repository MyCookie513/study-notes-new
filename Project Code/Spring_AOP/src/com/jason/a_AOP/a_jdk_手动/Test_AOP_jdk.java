package com.jason.a_AOP.a_jdk_手动;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_AOP_jdk {

	
   public static void main(String[] args) {
	   String xmlpath="com/jason/a_AOP/a_jdk_手动/Beans.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlpath);
		System.out.println("xml已经被加载");
		Target	target=(Target) applicationcontext.getBean("TargetID");
		target.dao();
		target.service();
    }
	
	@Test
	public void Test_AOP_new () {
		String xmlpath="com/jason/a_AOP/手动/Beans.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlpath);
		System.out.println("xml已经被加载");
		Target	target=(Target) applicationcontext.getBean("TargetID");
		target.dao();
		target.service();
		
	}
}
