package com.jason.����;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class test_����Ӧ��_�����ļ����� {
	public static void main(String[] args) throws Exception {
		//ͨ�������ȡClass����
		Class stuClass = Class.forName(getValue("className"));//"cn.fanshe.Student"
		//2��ȡshow()����
		Method m = stuClass.getMethod(getValue("methodName"));//show
		//3.����show()����
		m.invoke(stuClass.getConstructor().newInstance());
		
	}
	
	//�˷�������һ��key���������ļ��л�ȡ��Ӧ��value
	public static String getValue(String key) throws IOException{
		//File file=new File("pro.txt");
		Properties pro = new Properties();//��ȡ�����ļ��Ķ���
		FileReader in = new FileReader("pro.txt");//��ȡ������
		pro.load(in);//�������ص������ļ�������
		in.close();
		return pro.getProperty(key);//���ظ���key��ȡ��valueֵ
	}


}
