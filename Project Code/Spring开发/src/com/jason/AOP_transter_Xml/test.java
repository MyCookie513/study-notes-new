package com.jason.AOP_transter_Xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jason.AOP_transter_Xml.Service.AcountService;





public class test {

	
	public static void main(String[] args) {
	
		String path="com/jason/AOP_transter_Xml/applicationContext.xml";
		ApplicationContext applicationcontext =new ClassPathXmlApplicationContext(path);
		AcountService acountservice =(AcountService) applicationcontext.getBean("AcountServiceID");
		acountservice.transfer_acount("jason","cookie", 1000);
	}
}
