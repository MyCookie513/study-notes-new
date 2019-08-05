package com.jason.annotation;

import org.springframework.stereotype.Repository;

@Repository("Student_dao_imple")
public class Student_dao_imple implements Student_Dao{

	@Override
	public void dao() {
		
		System.out.println("Dao is doing");
		
		
	}

}
