package com.jason.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller("Web_Student_actionID")
public class Web_Student_action   {

	@Autowired
	@Qualifier("Student_Service_ImpleID")
	private Student_service student_service;
	
	public void excute() {
		System.out.println("进行Web层的处理");
		student_service.adduser();
	}
	
}
