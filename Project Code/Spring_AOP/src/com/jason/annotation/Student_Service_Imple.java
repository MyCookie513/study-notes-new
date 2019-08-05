package com.jason.annotation;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("Student_Service_ImpleID")
@Scope("singleton")
public class Student_Service_Imple implements Student_service {
	
	private Student_Dao student_dao;
	

	@Autowired
	public void setStudent_dao(Student_Dao student_dao) {
		this.student_dao = student_dao;
	}
	public Student_Dao getStudent_dao() {
		return student_dao;
	}
	@PostConstruct
	public void Init() {
		System.out.println("service is Inited");
	}
	@Override
	public void adduser() {
		System.out.println("进行service层的处理");
		student_dao.dao();

	}

	@PreDestroy
	public void destory() {
		System.out.println("service is destory");
	}

}
