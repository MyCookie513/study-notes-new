package com.jason.DI_Setter;

public  class Address {

	public static String h="ÀàµÄ¾²Ì¬ÊôĞÔ";
	private String address;
	private String pho_num;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPho_num() {
		return pho_num;
	}
	public void setPho_num(String pho_num) {
		this.pho_num = pho_num;
	}
	@Override
	public String toString() {
		return "Address [address=" + address + ", pho_num=" + pho_num + "]";
	}
	
	
}
