package com.jason.a_AOP.���Զ�_FactoryBean;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//��������ȷ��֪ͨ����Ҫʵ�ֲ�ͬ�Ľӿڣ��ӿھ��ǹ淶
//MethodInterceptor ���Ƽ�ǿ
public class advice_Imple implements MethodInterceptor {
	
	


	@PostConstruct
	public void Init() {
		System.out.println("advice_Imple is Inited");
	}

	@PreDestroy
	public void destory() {
		System.out.println("advice_Imple is destory");
	}
	

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		
		System.out.println("���Ƽ�ǿ֮ǰ�����ǿ");
		Object obj=method.proceed();
		System.out.println("���Ƽ�ǿ֮�����ǿ");

		return obj;
	}

}
