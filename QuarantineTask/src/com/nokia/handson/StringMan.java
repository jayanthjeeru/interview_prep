package com.nokia.handson;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class StringMan {

	public static void main(String[] args) {
	
		String s = "/ne/system/security/ikev2/ikev2-local-instance[name=1-5]";
		
		System.out.println(s.split("/")[s.split("/").length-1].split("name=")[0].replace("[", "")); 
		
	}
}

class Car2 {
	String name;
	String num;
	
	public Car2(String name, String num) {
		
		this.name = name;
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Car2 [name=" + name + ", num=" + num + "]";
	}
	
	
	
}
