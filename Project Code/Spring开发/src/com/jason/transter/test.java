package com.jason.transter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jason.transter.Service.AcountService;

public class test {

	
	public static void main(String[] args) {
	
		String path="com/jason/transter/Service/applicationContext.xml";
		ApplicationContext applicationcontext =new ClassPathXmlApplicationContext(path);
		AcountService acountservice =(AcountService) applicationcontext.getBean("AcountServiceID");
		acountservice.transfer_acount("jason","cookie", 1000);
	}
}
