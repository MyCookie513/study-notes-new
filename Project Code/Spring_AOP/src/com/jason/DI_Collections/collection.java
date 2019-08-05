package com.jason.DI_Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class collection {

	private String[] array;
	private ArrayList<String> list;
	
	private Set<String> set;
	private Map<String,String> map;
	private Properties props;
	
	public ArrayList<String> getList() {
		return list;
	}
	public String[] getArray() {
		return array;
	}
	public void setArray(String[] array) {
		this.array = array;
	}
	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	@Override
	public String toString() {
		return "collection [ \n array=" + Arrays.toString(array) + ",\n list=" + list + ",\n set=" + set + ", \n map=" + map
				+ ", \n props=" + props + "]";
	}
	public Properties getProps() {
		return props;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	
	
	
	
}
