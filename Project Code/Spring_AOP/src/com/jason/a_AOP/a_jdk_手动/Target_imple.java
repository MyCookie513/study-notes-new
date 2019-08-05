package com.jason.a_AOP.a_jdk_ ÷∂Ø;

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

}
