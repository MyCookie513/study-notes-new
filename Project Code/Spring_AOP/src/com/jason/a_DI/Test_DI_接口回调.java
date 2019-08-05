package com.jason.a_DI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.SystemPropertyUtils;

public class Test_DI_�ӿڻص� {

	public static void main(String[] args) {
		//��spring�����л��
				//1.�������
				String xmlpath="com/jason/a_DI/Beans.xml";
				ApplicationContext applicationcontext =new ClassPathXmlApplicationContext(xmlpath);
				//2.�������---����Ҫ�Լ�new���Ǵ�spring�����л��
				BookService bookservice=(BookService) applicationcontext.getBean("bookServiceID");
				//3.�����ǵ����ڲ��ӿڵ�һ��������Ȼ�����������ʵ�ֵ�Ҫ��ע��Ķ���Ϊ���֣�
				bookservice.add_book();
	}
	
	@Test
	void demo01() {
		//ʹ��applicationcontext���м���xml�ļ�
		
		//��spring�����л��
		//1.�������
		String xmlpath="com/jason/a_DI/Beans.xml";
		ApplicationContext applicationcontext =new ClassPathXmlApplicationContext(xmlpath);
		System.out.println("�������");
		//2.�������---����Ҫ�Լ�new���Ǵ�spring�����л��
		BookService bookservice=(BookService) applicationcontext.getBean("bookServiceID");
		//3.�����ǵ����ڲ��ӿڵ�һ��������Ȼ�����������ʵ�ֵ�Ҫ��ע��Ķ���Ϊ���֣�
		bookservice.add_book();
	}
	@Test
	void demo02() {
		//ʹ��BeanFactory���м���xml�ļ�
		
		//��spring�����л��
		//1.�������
		String xmlpath="com/jason/a_DI/Beans.xml";
		BeanFactory beanfactory=new XmlBeanFactory(new ClassPathResource(xmlpath));
		System.out.println("�������");
		//2.�������---����Ҫ�Լ�new���Ǵ�spring�����л��
		BookService bookservice=(BookService) beanfactory.getBean("bookServiceID");
		//3.�����ǵ����ڲ��ӿڵ�һ��������Ȼ�����������ʵ�ֵ�Ҫ��ע��Ķ���Ϊ���֣�
		bookservice.add_book();
	}
	
}
