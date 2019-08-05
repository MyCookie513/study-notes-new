package com.cn.longclass;

import java.util.Set;

import com.cn.product.product;
import com.cn.user.User;

public class test_hibernate {
	
	
	public  int id;
	private String String_hibernate;
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	private Set<product> products;

	public Set<product> getProducts() {
		return products;
	}

	public void setProducts(Set<product> products) {
		this.products = products;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getString_hibernate() {
		return String_hibernate;
	}
	public void setString_hibernate(String string_hibernate) {
		String_hibernate = string_hibernate;
	}
	
	
	
	
	
	

}
