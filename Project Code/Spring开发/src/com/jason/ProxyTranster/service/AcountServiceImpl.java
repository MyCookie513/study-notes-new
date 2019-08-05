package com.jason.ProxyTranster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.jason.ProxyTranster.dao.UserDao;



public class AcountServiceImpl implements AcountService {

	@Autowired()
	@Qualifier("UserDao_ID")
	private UserDao userdao;
	
   
   
	@Override
	public void transfer_acount(String user_out, String user_in, int money) {
     
			userdao.outer(user_out, money);
			//int i=3/0;
			userdao.inner(user_in, money);
			
	
	}




	

}
