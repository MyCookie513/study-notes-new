package com.jason.a_AOP.Aspect_Annotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Test_AOP_Aspect_Annotation {

	
   public static void main(String[] args) {
	   
		  String xmlpath="com/jason/a_AOP/Aspect_Annotation/Beans.xml";
			ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlpath);
			System.out.println("xml�Ѿ�������");
			Target_imple target=(Target_imple) applicationcontext.getBean("Target");
			target.dao();
			target.service();
			
			
    }
	

}
