package com.jason.Xml_Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

public class Web_Student_action   {

	@Autowired
	@Qualifier("Student_Service_ImpleID")
	private Student_service student_service;
	
	public void excute() {
		System.out.println("����Web��Ĵ���");
		student_service.adduser();
	}
	
}
