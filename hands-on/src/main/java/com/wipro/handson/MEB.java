package com.wipro.handson;

import java.util.concurrent.ConcurrentHashMap;

public class MEB {

	int a;
	String st;
	public MEB(){
		
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}
	public MEB(int a, String st) {
		this.a = a;
		this.st = st;
	}
	@Override
	public String toString() {
		return "MEB [a=" + a + ", st=" + st + "]";
	}
	
	
	
	
	
	

	


}
