package com.jason.DI_Constructor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.SystemPropertyUtils;

public class Test_DI_Constructor {


	@Test
	void demo01() {
		
		String xmlpath="com/jason/DI_Constructor/Beans.xml";
		ApplicationContext applicationcontext =new ClassPathXmlApplicationContext(xmlpath);
		System.out.println("º”‘ÿÕÍ≥…");
		User bookservice=(User) applicationcontext.getBean("userID");
		BookDao bookdao=(BookDao) applicationcontext.getBean("BookDaoID");
		System.out.println(bookdao);
	}
	
	
}
