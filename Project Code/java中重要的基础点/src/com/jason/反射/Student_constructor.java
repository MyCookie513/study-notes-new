package com.jason.����;
public class Student_constructor {
	
	//---------------���췽��-------------------
	//��Ĭ�ϵĹ��췽����
	Student_constructor(String str){
		System.out.println("(Ĭ��)�Ĺ��췽�� String s = " + str);
	}
	
	//�޲ι��췽��
	public Student_constructor(){
		System.out.println("�����˹��С��޲ι��췽��ִ���ˡ�����");
	}
	
	//��һ�������Ĺ��췽��
	public Student_constructor(char name){
		System.out.println("char������" + name);
	}
	
	//�ж�������Ĺ��췽��
	public Student_constructor(String name ,int age){
		System.out.println("String������"+name+"int���䣺"+ age);//���ִ��Ч�������⣬�Ժ�����
	}
	
	//�ܱ����Ĺ��췽��
	protected Student_constructor(boolean n){
		System.out.println("�ܱ����Ĺ��췽�� boolean n = " + n);
	}
	
	//˽�й��췽��
	private Student_constructor(int age){
		System.out.println("˽�еĹ��췽�� int ���䣺"+ age);
	}
 
}

