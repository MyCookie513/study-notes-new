package com.jason.a_DI;

public class BookService implements BookService_Interface{

	
	private BookDao_Interface  Bookdao;
	public void setBookdao(BookDao_Interface bookdao) {
		this.Bookdao = bookdao;
	}
	@Override
	public void add_book() {
		this.Bookdao.add_book();
	}
	public BookService() {
		System.out.println("BookService 被实例化了");
	}


}
