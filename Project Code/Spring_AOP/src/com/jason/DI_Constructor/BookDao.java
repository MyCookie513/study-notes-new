package com.jason.DI_Constructor;

public class BookDao implements BookDao_Interface {

	@Override
	public void add_book() {

		System.out.println(" BookDao add  book");
	}

	public void MyInit() {
		System.out.println("BookDaoʵ������ɳ�ʼ��");
	}
	
	public void Mydestroy() {
		System.out.println("BookDaoʵ�����������");
	}
	public BookDao() {
		System.out.println("BookDaoʵ���๹�캯���ĵ���");
	}

	
	
}
