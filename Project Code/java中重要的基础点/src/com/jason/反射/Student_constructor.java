package com.jason.反射;
public class Student_constructor {
	
	//---------------构造方法-------------------
	//（默认的构造方法）
	Student_constructor(String str){
		System.out.println("(默认)的构造方法 String s = " + str);
	}
	
	//无参构造方法
	public Student_constructor(){
		System.out.println("调用了公有、无参构造方法执行了。。。");
	}
	
	//有一个参数的构造方法
	public Student_constructor(char name){
		System.out.println("char姓名：" + name);
	}
	
	//有多个参数的构造方法
	public Student_constructor(String name ,int age){
		System.out.println("String姓名："+name+"int年龄："+ age);//这的执行效率有问题，以后解决。
	}
	
	//受保护的构造方法
	protected Student_constructor(boolean n){
		System.out.println("受保护的构造方法 boolean n = " + n);
	}
	
	//私有构造方法
	private Student_constructor(int age){
		System.out.println("私有的构造方法 int 年龄："+ age);
	}
 
}

