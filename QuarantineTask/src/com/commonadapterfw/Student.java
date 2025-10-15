package com.commonadapterfw;

public class Student {

	String name;
	int rollNum;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNum() {
		return rollNum;
	}
	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
	public Student(String name, int rollNum) {
		
		this.name = name;
		this.rollNum = rollNum;
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNum=" + rollNum + "]";
	}
	public Student() {
		
	}
}
