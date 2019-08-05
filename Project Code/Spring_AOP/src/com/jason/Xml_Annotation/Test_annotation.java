package com.jason.Xml_Annotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_annotation {


	@Test
	void demo01() {

		 
	}
	@Test
	void demo02() {
	
		String xmlpath="com/jason/Xml_Annotation/Beans.xml";
		AbstractApplicationContext applicationcontext =new ClassPathXmlApplicationContext(xmlpath);
		Web_Student_action user=(Web_Student_action) applicationcontext.getBean("Web_Student_actionID");
		user.excute();
		applicationcontext.close();
	}
	
}
