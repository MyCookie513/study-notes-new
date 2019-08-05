package com.jason.DI_Setter;

public class Person {

	private String name ;
	private int age;
	private Address home_address;
	private Address com_address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getHome_address() {
		return home_address;
	}
	public void setHome_address(Address home_address) {
		this.home_address = home_address;
	}
	public Address getCom_address() {
		return com_address;
	}
	public void setCom_address(Address com_address) {
		this.com_address = com_address;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", home_address=" + home_address + ", com_address="
				+ com_address + "]";
	}
	
	
	
}
