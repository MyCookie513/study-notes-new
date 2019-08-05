package com.jason.a_AOP.Aspect_Annotation;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


//��������ȷ��֪ͨ����Ҫʵ�ֲ�ͬ�Ľӿڣ��ӿھ��ǹ淶
//MethodInterceptor ���Ƽ�ǿ
@Component()
@Aspect()
public class aspect_advisor {
	
	 //����һ������������㼯
     @Pointcut("execution(* com.jason.a_AOP.Aspect_Annotation.Target_imple.*(..))")
     public void mypointcut() {
	
     }

	@PostConstruct
	public void Init() {
		System.out.println("advice_Imple is Inited");
	}

	@PreDestroy
	public void destory() {
		System.out.println("advice_Imple is destory");
	}
	
   // @Before(value = "execution(* com.jason.a_AOP.Aspect_Annotation.Target_imple.*(..))")
	public void mybefore(JoinPoint join) {
		System.out.println("ǰ�ô���"+join.getSignature().getName());
	}
	
	//@AfterReturning(value="execution(* com.jason.a_AOP.Aspect_Annotation.Target_imple.*(..))",returning="re_obj")
	public void myafterReturning(JoinPoint join,Object re_obj) {
		System.out.println("���ô���"+join.getSignature().getName()+re_obj);
	}
	@Around("mypointcut()")
	public Object myaround(ProceedingJoinPoint join) throws Throwable {
		System.out.println("ǰ�ô���"+join.getSignature().getName());
		Object obj=join.proceed();
		System.out.println("���ô���"+join.getSignature().getName());
		return obj;
	}

	@AfterThrowing(value="mypointcut()" ,throwing="throwable" )
	public void myafter_Throwing(JoinPoint join,Throwable throwable) {
		System.out.println("�쳣����"+join.getSignature().getName()+throwable.getMessage());
	}
	@After(value="mypointcut()")
	public void myafter(JoinPoint join) {
		System.out.println("finally����"+join.getSignature().getName());
	}
}
