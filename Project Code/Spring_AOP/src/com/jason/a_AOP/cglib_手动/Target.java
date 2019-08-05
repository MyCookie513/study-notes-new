package com.jason.a_AOP.cglib_ ÷∂Ø;

import org.springframework.stereotype.Repository;

public class Target {


	public void dao() {
		
		System.out.println("Target_cglib is doing");
		
		
	}


	public void service() {
		System.out.println("Target_cglib is service");
		
	}

}
