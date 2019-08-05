package com.jason.DI_Setter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.SystemPropertyUtils;

public class Test_DI_Setter {


	@Test
	void demo01() {
		
		String xmlpath="com/jason/DI_Setter/Beans.xml";
		ApplicationContext applicationcontext =new ClassPathXmlApplicationContext(xmlpath);
		System.out.println("º”‘ÿÕÍ≥…");
		Person person=(Person) applicationcontext.getBean("PersonID");
		System.out.println(person);
	}
	
	
}
