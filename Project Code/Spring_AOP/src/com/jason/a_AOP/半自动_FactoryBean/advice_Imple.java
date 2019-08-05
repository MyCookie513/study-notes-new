package com.jason.a_AOP.半自动_FactoryBean;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//切面类中确定通知，需要实现不同的接口，接口就是规范
//MethodInterceptor 环绕加强
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
		
		System.out.println("环绕加强之前处理加强");
		Object obj=method.proceed();
		System.out.println("环绕加强之后处理加强");

		return obj;
	}

}
