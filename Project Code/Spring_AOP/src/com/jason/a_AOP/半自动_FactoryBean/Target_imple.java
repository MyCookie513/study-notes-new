package com.jason.a_AOP.���Զ�_FactoryBean;

import org.springframework.stereotype.Repository;

public class Target_imple implements Target{

	@Override
	public void dao() {
		
		System.out.println("Target_imple is doing");
		
		
	}

	@Override
	public void service() {
		System.out.println("Target_imple is service");
		
	}
	public void Target_private_Method() {
		System.out.println("�ǽӿڷ�������");
		
	}

}
