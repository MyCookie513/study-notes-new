package com.jason.a_AOP.cglib_手动;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class Aspect_BeanFactory {

	
	
	public static Target create_Target_Proxy() {
		//1 切面类
		final advice_Imple advice = new advice_Imple();
		//2目标类
		final Target target = new Target();
		
		
		//1.创建Cglib的核心类；Enhancer增强的意思；
		Enhancer enhancer =new Enhancer();
		//2.确定Target；因为Cglib的原理就是创建Target的子类从而进行增强；
		enhancer.setSuperclass(Target.class);
		//3.设置回掉函数  MethodInteceptor接口等效于InvocationHandler接口；
		enhancer.setCallback(new MethodInterceptor(){

			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
				advice.before();
				Object obj=arg1.invoke(target, arg2);
				//在这里多了个MethodProxy ：目标类的方法的代理； 
				arg3.invokeSuper(arg0, arg2);//代表的是：目标类代理对象的父类调用这个方法；==目标类的方法执行
				arg3.invoke(target, arg2);//代表的是：目标类调用这个方法；
				advice.after();
				return obj;
			}
			
		 });
		//4.创建代理对象；
		Target Proxy_target =(Target) enhancer.create();
		return Proxy_target;
	}
	
	
}
