package com.jason.a_AOP.全自动;

import org.springframework.stereotype.Repository;

public class Target_imple {


	public void dao() {
		
		System.out.println("Target_imple is doing");
		
		
	}

	
	public void service() {
		System.out.println("Target_imple is service");
		
	}
	public void Target_private_Method() {
		System.out.println("非接口方法调用");
		
	}

}
