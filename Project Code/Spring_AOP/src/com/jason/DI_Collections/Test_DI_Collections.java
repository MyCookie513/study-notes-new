package com.jason.DI_Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.SystemPropertyUtils;

public class Test_DI_Collections {


	@Test
	void demo01() {
		
		String xmlpath="com/jason/DI_Collections/Beans.xml";
		ApplicationContext applicationcontext =new ClassPathXmlApplicationContext(xmlpath);
		System.out.println("º”‘ÿÕÍ≥…");
		collection coll=(collection) applicationcontext.getBean("collectionsID");
		System.out.println(coll);
	}
	
	
}
