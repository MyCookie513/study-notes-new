package com.jason.a_DI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.SystemPropertyUtils;

public class Test_DI_接口回调 {

	public static void main(String[] args) {
		//从spring容器中获得
				//1.获得容器
				String xmlpath="com/jason/a_DI/Beans.xml";
				ApplicationContext applicationcontext =new ClassPathXmlApplicationContext(xmlpath);
				//2.获得内容---不需要自己new都是从spring容器中获得
				BookService bookservice=(BookService) applicationcontext.getBean("bookServiceID");
				//3.这样是调用内部接口的一个方法，然而方法是如何实现的要以注入的对象为区分；
				bookservice.add_book();
	}
	
	@Test
	void demo01() {
		//使用applicationcontext进行加载xml文件
		
		//从spring容器中获得
		//1.获得容器
		String xmlpath="com/jason/a_DI/Beans.xml";
		ApplicationContext applicationcontext =new ClassPathXmlApplicationContext(xmlpath);
		System.out.println("加载完成");
		//2.获得内容---不需要自己new都是从spring容器中获得
		BookService bookservice=(BookService) applicationcontext.getBean("bookServiceID");
		//3.这样是调用内部接口的一个方法，然而方法是如何实现的要以注入的对象为区分；
		bookservice.add_book();
	}
	@Test
	void demo02() {
		//使用BeanFactory进行加载xml文件
		
		//从spring容器中获得
		//1.获得容器
		String xmlpath="com/jason/a_DI/Beans.xml";
		BeanFactory beanfactory=new XmlBeanFactory(new ClassPathResource(xmlpath));
		System.out.println("加载完成");
		//2.获得内容---不需要自己new都是从spring容器中获得
		BookService bookservice=(BookService) beanfactory.getBean("bookServiceID");
		//3.这样是调用内部接口的一个方法，然而方法是如何实现的要以注入的对象为区分；
		bookservice.add_book();
	}
	
}
