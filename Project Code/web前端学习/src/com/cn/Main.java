package com.cn;

import java.sql.Connection;

import com.mysql.ConnDB;


public class Main {

public static void main(String[] args) {
		
		ConnDB conndb=new ConnDB();
        
        
		
	}
	public static boolean isEamil(String str) {
		
		String str0="\\w+([-+.']\\w+)*\\@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		String str1="\\.@.[.+]";
		boolean result=str.matches(str1);
		return result;
	}
	
}
