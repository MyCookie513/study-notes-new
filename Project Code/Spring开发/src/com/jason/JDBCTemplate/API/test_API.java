package com.jason.JDBCTemplate.API;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class test_API {

	public static void main(String[] args) {
		
		
		//1.�½�һ�����ӳ�
		BasicDataSource dataSource=new BasicDataSource();
		//2.�������ݿ�Ļ���4��
		    //1.���ü��ص�����
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbctemplate");
		dataSource.setUsername("root");
		dataSource.setPassword("988513");
		
		//�����������ݿ��ģ�壺
		JdbcTemplate jdbc =new JdbcTemplate();
		jdbc.setDataSource(dataSource);
		
		jdbc.update("insert into t_user(t_username,password) values(?,?);","��","love");
		
		
		
		
	}
	
	
	
}
