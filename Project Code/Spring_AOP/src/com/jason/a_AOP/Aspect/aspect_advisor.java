package com.jason.a_AOP.Aspect;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//切面类中确定通知，需要实现不同的接口，接口就是规范
//MethodInterceptor 环绕加强
public class aspect_advisor {
	
	


	@PostConstruct
	public void Init() {
		System.out.println("advice_Imple is Inited");
	}

	@PreDestroy
	public void destory() {
		System.out.println("advice_Imple is destory");
	}
	

	public void mybefore(JoinPoint join) {
		System.out.println("前置处理"+join.getSignature().getName());
	}
	
	public void myafterReturning(JoinPoint join,Object re_obj) {
		System.out.println("后置处理"+join.getSignature().getName()+re_obj);
	}
	
	public Object myaround(ProceedingJoinPoint join) throws Throwable {
		System.out.println("前置处理"+join.getSignature().getName());
		Object obj=join.proceed();
		System.out.println("后置处理"+join.getSignature().getName());
		return obj;
	}

	
	public void myafter_Throwing(JoinPoint join,Throwable throwable) {
		System.out.println("异常处理"+join.getSignature().getName()+throwable.getMessage());
	}
	public void myafter(JoinPoint join) {
		System.out.println("finally处理"+join.getSignature().getName());
	}
}
