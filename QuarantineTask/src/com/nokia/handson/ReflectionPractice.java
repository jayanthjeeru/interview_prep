package com.nokia.handson;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionPractice {

	public static void main(String[] args) {

		
		 try {
			Class<?> personClass = Class.forName("com.nokia.handson.Car");
			
			
			
			Constructor<?> constructor = personClass.getConstructor(String.class, int.class);
	        Object personObj = constructor.newInstance("TATA", 30);
	        
			Method m =  personClass.getDeclaredMethod("print",String.class);
			
			m.invoke(personObj,"jay");
			
			Field f = personClass.getDeclaredField("name");
			f.setAccessible(true);
			System.out.println(f.get(personObj));
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}


class Car {
	
	String x;
	private String name;
	private int number;
	
	
	
	public Car(String name, int number) {
		
		this.name = name;
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void print() {
		System.out.println(name);
	}
	
	public void print(String ownername) {
		System.out.println(name+"-"+ownername);
	}
	
}
