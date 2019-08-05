package com.jason.a_AOP.cglib_�ֶ�;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class Aspect_BeanFactory {

	
	
	public static Target create_Target_Proxy() {
		//1 ������
		final advice_Imple advice = new advice_Imple();
		//2Ŀ����
		final Target target = new Target();
		
		
		//1.����Cglib�ĺ����ࣻEnhancer��ǿ����˼��
		Enhancer enhancer =new Enhancer();
		//2.ȷ��Target����ΪCglib��ԭ����Ǵ���Target������Ӷ�������ǿ��
		enhancer.setSuperclass(Target.class);
		//3.���ûص�����  MethodInteceptor�ӿڵ�Ч��InvocationHandler�ӿڣ�
		enhancer.setCallback(new MethodInterceptor(){

			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
				advice.before();
				Object obj=arg1.invoke(target, arg2);
				//��������˸�MethodProxy ��Ŀ����ķ����Ĵ��� 
				arg3.invokeSuper(arg0, arg2);//������ǣ�Ŀ����������ĸ���������������==Ŀ����ķ���ִ��
				arg3.invoke(target, arg2);//������ǣ�Ŀ����������������
				advice.after();
				return obj;
			}
			
		 });
		//4.�����������
		Target Proxy_target =(Target) enhancer.create();
		return Proxy_target;
	}
	
	
}
