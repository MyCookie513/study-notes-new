package com.jason.a_AOP.a_jdk_�ֶ�;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Aspect_BeanFactory {

	
	
	public static Target create_Target_Proxy() {
		//1 ������
		final advice_Imple advice = new advice_Imple();
		//2Ŀ����
		final Target_imple target = new Target_imple();
		/* 3 �����ࣺ��Ŀ���ࣨ����㣩�� �����֪ࣨͨ�� ��� --> ����
		 * 	Proxy.newProxyInstance
		 * 		����1��loader �������������̬������ ����ʱ�������κ��඼��Ҫ�������������ص��ڴ档
		 * 			һ���������ǰ��.class.getClassLoader();
		 * 					Ŀ����ʵ��.getClass().get...
		 * 		����2��Class[] interfaces ��������Ҫʵ�ֵ����нӿ�
		 * 			��ʽ1��Ŀ����ʵ��.getClass().getInterfaces()  ;ע�⣺ֻ�ܻ���Լ��ӿڣ����ܻ�ø�Ԫ�ؽӿ�
		 * 			��ʽ2��new Class[]{UserService.class}   
		 * 			���磺jdbc ����  --> DriverManager  ��ýӿ� Connection
		 * 		����3��InvocationHandler  �����࣬�ӿڣ��������ʵ���࣬һ����������ڲ�
		 * 			�ṩ invoke �������������ÿһ������ִ��ʱ����������һ��invoke
		 * 				����31��Object proxy ���������
		 * 				����32��Method method : �������ǰִ�еķ������������󣨷��䣩
		 * 					ִ�з�������method.getName()
		 * 					ִ�з�����method.invoke(����ʵ�ʲ���)
		 * 				����33��Object[] args :����ʵ�ʲ���
		 * 
		 */
		
		Target Proxy_target =(Target) Proxy.newProxyInstance(Aspect_BeanFactory.class.getClassLoader(),
				                                  // new Class[] {Target_imple.class}, 
				                                  Target_imple .class.getInterfaces(), 

				                                   new InvocationHandler() {

													@Override
													public Object invoke(Object proxy, Method method, Object[] args)
															throws Throwable {
														advice.before();
														Object obj=method.invoke(target,args);
														advice.after();
														return obj;
													}
			       
		                                            });
		
		
		return Proxy_target;
	}
	
	
}
