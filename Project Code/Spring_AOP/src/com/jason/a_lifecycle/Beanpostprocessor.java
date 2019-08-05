package com.jason.a_lifecycle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Beanpostprocessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("ǰ����" + beanName);

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("����" + beanName);
		// ����jdk����
		return Proxy.newProxyInstance(Beanpostprocessor.class.getClassLoader(), bean.getClass().getInterfaces(),
				// �����ǵ��ô�������һ���ӿڣ�����׼��д�����ڲ��ࣻ
				new InvocationHandler() {

					@Override
					public Object invoke(Object arg0, Method method, Object[] arg2) throws Throwable {
						System.out.println("----------��������---------");
						// �����ǵ��÷���ʱ����������ԭbean��ķ�����󷵻ط���ֵ
						Object obj = method.invoke(bean, arg2);
						System.out.println("----------�ر�����---------");

						return obj;
					}

				});
	}

}
