package com.jason.ProxyTranster;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jason.ProxyTranster.service.AcountService;



public class test {

	
	public static void main(String[] args) {
	
		String path="com/jason/ProxyTranster/applicationContext.xml";
		ApplicationContext applicationcontext =new ClassPathXmlApplicationContext(path);
		AcountService acountservice =(AcountService) applicationcontext.getBean("ProxyAcountServiceID");
		acountservice.transfer_acount("jason","cookie", 1000);
	}
}
