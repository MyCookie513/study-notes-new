package com.jason.a_AOP.Aspect_Annotation;

import org.springframework.stereotype.Component;


@Component("Target")
public class Target_imple {


	public void dao() {
		/*int i=1/0;*/
		System.out.println("Target_imple is doing");
		
		
	}

	
	public void service() {
		System.out.println("Target_imple is service");
		
	}


}
