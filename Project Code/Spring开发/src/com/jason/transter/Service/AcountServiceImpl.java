package com.jason.transter.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.jason.transter.dao.UserDao;

public class AcountServiceImpl implements AcountService {

	@Autowired()
	@Qualifier("UserDaoID")
	private UserDao userdao;
	
    private TransactionTemplate transactiontemplate;
    //要使操作成为一个整体事务；才能确定操作的原子性；
	@Override
	public void transfer_acount(String user_out, String user_in, int money) {
      transactiontemplate.execute(new TransactionCallbackWithoutResult() {
		
		@Override
		protected void doInTransactionWithoutResult(TransactionStatus status) {
			userdao.outer(user_out, money);
			//int i=3/0;
			userdao.inner(user_in, money);
			
		}
	});
		
	}
	public TransactionTemplate getTransactiontemplate() {
		return transactiontemplate;
	}
	public void setTransactiontemplate(TransactionTemplate transactiontemplate) {
		this.transactiontemplate = transactiontemplate;
	}

}
