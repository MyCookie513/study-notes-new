package com.jason.AOP_transter_Annotation.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDao  extends JdbcDaoSupport implements acount_transter {

	@Override
	public void inner(String user, int in_money) {
		this.getJdbcTemplate().update("update acount set money=money-? where user=? ", in_money,user);
	}

	@Override
	public void outer(String user, int out_money) {
		this.getJdbcTemplate().update("update acount set money=money+? where user=? ", out_money,user);
	
	}

	
	
	
	
}
