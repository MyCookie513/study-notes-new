package com.jason.DI_Constructor;

public class BookDao implements BookDao_Interface {

	@Override
	public void add_book() {

		System.out.println(" BookDao add  book");
	}

	public void MyInit() {
		System.out.println("BookDao实现类完成初始化");
	}
	
	public void Mydestroy() {
		System.out.println("BookDao实现类完成销毁");
	}
	public BookDao() {
		System.out.println("BookDao实现类构造函数的调用");
	}

	
	
}
