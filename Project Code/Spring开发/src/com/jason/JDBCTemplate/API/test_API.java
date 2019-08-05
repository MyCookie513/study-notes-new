package com.jason.JDBCTemplate.API;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class test_API {

	public static void main(String[] args) {
		
		
		//1.新建一个连接池
		BasicDataSource dataSource=new BasicDataSource();
		//2.链接数据库的基本4项
		    //1.设置加载的驱动
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbctemplate");
		dataSource.setUsername("root");
		dataSource.setPassword("988513");
		
		//创建操纵数据库的模板：
		JdbcTemplate jdbc =new JdbcTemplate();
		jdbc.setDataSource(dataSource);
		
		jdbc.update("insert into t_user(t_username,password) values(?,?);","爱","love");
		
		
		
		
	}
	
	
	
}
