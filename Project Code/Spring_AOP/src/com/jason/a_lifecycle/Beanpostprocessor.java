package com.jason.a_lifecycle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Beanpostprocessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("前处理：" + beanName);

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("后处理：" + beanName);
		// 生成jdk代理
		return Proxy.newProxyInstance(Beanpostprocessor.class.getClassLoader(), bean.getClass().getInterfaces(),
				// 这里是调用处理者是一个接口，于是准备写匿名内部类；
				new InvocationHandler() {

					@Override
					public Object invoke(Object arg0, Method method, Object[] arg2) throws Throwable {
						System.out.println("----------开启事务---------");
						// 这里是调用方法时，进而引用原bean类的方法最后返回返回值
						Object obj = method.invoke(bean, arg2);
						System.out.println("----------关闭事务---------");

						return obj;
					}

				});
	}

}
