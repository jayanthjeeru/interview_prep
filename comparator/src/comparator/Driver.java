package comparator;

import java.util.*;



public class Driver {

	public static void main(String[] args) {
		
		List<Student> l =Arrays.asList(new Student(40,"IR32AW-1-1-1"),new Student(40,"MEC2L-1-1-MEC1"),new Student(35,"PORT-1-1-1-CUSTLAN"),new Student(40,"PORT-1-1-1-CUSTLAN"),new Student(30,"PORT-1-1-1-FS3"),new Student(70,"SHELF-1-1"));
		
		Comparator<Student> c =new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
//				return o1.getName().compareTo(o2.getName());
				int count1  =o1.getName().split("-").length;
				int count2=o2.getName().split("-").length;
				
				String s1=o1.getName().substring(o1.getName().indexOf("-"));
				System.out.println(s1);
				String s2=o2.getName().substring(o2.getName().indexOf("-"));
				System.out.println(s2);
				if(count1!=count2)
				return o1.getName().compareTo(o2.getName());
				
				return -1;
			}
		};
		
		System.out.println(l);
//		Collections.sort(l,c);
		l.sort(c);
		System.out.println(l);
	}

}
