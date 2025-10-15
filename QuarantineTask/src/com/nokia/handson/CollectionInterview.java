package com.nokia.handson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CollectionInterview {

	public static void main(String[] args) {
		List<String> l = new ArrayList<>(Arrays.asList("hi", "hello", "abc"));
		try {
//			for(String s : l) {
//				if(s.equals("abc"))
//					l.remove(s);
//			}
			
			Iterator<String> it = l.iterator();
			
			while(it.hasNext()) {
				String s = it.next();
				if(s.equals("abc"))
					it.remove();
			}
			
			System.out.println(l);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
