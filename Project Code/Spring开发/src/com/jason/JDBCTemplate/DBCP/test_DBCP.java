package com.jason.JDBCTemplate.DBCP;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jason.JDBCTemplate.Domain.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class test_DBCP {

	public static void main(String[] args) {
		String xmlpath="com/jason/JDBCTemplate/DBCP/Beans.xml";
		ApplicationContext applicationcontext =new ClassPathXmlApplicationContext(xmlpath);
		UserDao userdao=(UserDao)applicationcontext.getBean("UserDaoID");
		User user=new User();
		user.setT_password("520");
		user.setIdt_user(2);
		user.setT_username("xueyongjie");
		userdao.Update(user);
		List<User> list=userdao.findall();
		for(User users:list) {
			System.out.println(users.toString());
			
		}
		User gao=userdao.getbyid(1);
		System.out.println(gao);
		
	}

	@Test
	void Demo1() {

	}
	
	
	
}
