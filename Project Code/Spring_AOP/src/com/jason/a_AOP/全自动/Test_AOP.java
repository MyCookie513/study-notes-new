package com.jason.a_AOP.全自动;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Test_AOP {

	
   public static void main(String[] args) {
	   
		  String xmlpath="com/jason/a_AOP/全自动/Beans.xml";
			ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlpath);
			System.out.println("xml已经被加载");
			Target_imple target=(Target_imple) applicationcontext.getBean("Target");
			target.dao();
			target.service();
			target.Target_private_Method();
    }
	

}
