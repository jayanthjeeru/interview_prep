package com.wipro.handson;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.*;

public class HandsOn {

	public static void main(String[] args) throws Exception{
		
		Scanner sc=new Scanner(System.in);
	
//		int i=sc.nextInt();
//		for(String h: args)
//		System.out.println(h);
//		
//		Student s=new Student(1,"jay");
//		
//		HandsOn h=new HandsOn();
//		h.met3(s);
//		System.out.println(s);
//		 FileInputStream reader=new FileInputStream("/hands-on/src/main/resources/pro.properties");  
//		Properties p=new Properties();
//		p.load(reader);
//		System.out.println(p.getProperty("password"));
//		Set set=p.entrySet();  
//		  
//		Iterator itr=set.iterator();  
//		while(itr.hasNext()){  
//		Map.Entry entry=(Map.Entry)itr.next();  
//		System.out.println(entry.getKey()+" = "+entry.getValue());  
//		}  
		
//
//		System.out.println(h.met1());
//		
//		Map<Integer,String> m=new HashMap<>();
//		
//		m.put(1, "jay");
//		m.put(1, "reddy");
//		
//		System.out.println(m);
		
		List<String> sl = new ArrayList<>();
		
		sl.add("a1");
		sl.add("a2");
		sl.add("a4");
		
		
		sl.add(1, "a3");

		System.out.println(sl);
	}
	
	public void met3(Student s) {
		
		s.setName("ramba");
		
	
	}
	
	public List<Integer> met1() {
		List<Integer> li=new ArrayList<>();
		li.add(1);
		li.add(2);
		meth2(li);
		return li;
	}
	
	public void meth2(List<Integer> li) {
		li.add(4);
	}

}

class Student{
	int id;
	String name;
	
	
	
	public Student(int id, String name) {
		
		this.id = id;
		this.name = name;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + "]";
	}
	
	
}
