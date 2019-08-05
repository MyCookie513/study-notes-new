package com.jason.a_AOP.a_jdk_手动;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("singleton")
public class advice_Imple implements advice {
	
	


	@PostConstruct
	public void Init() {
		System.out.println("advice_Imple is Inited");
	}

	@PreDestroy
	public void destory() {
		System.out.println("advice_Imple is destory");
	}
	@Override
	public void before() {
		System.out.println("进行 advice 增强  之before处理");
		
	}
	@Override
	public void after() {
		System.out.println("进行 advice 增强  之after处理");
		
	}

}
