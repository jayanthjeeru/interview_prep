package com.wipro;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamWaste {
	
	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(1,2,3,4,5,6,7,8);
		
		System.out.println(l);
		
		int count=0;
		System.out.println(l.stream().filter(x->x%2==0).collect(Collectors.toList()));
		
		System.out.println(l.stream().filter(x->x%2!=0).collect(Collectors.toList()));
		
		System.out.println(l.stream().filter(x->isPrime(x)).collect(Collectors.toList()));
		
		List<String> ls = Arrays.asList("hi","hekki","jakki","lukky","lukky");
		
		System.out.println(ls.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
		
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	
	public static boolean isPrime(int z) {
		
		int count =0;
		
		for(int i=1;i<=z;i++) {
			if(z%i==0)
				count++;
		}
		if(count>2)
			return false;
		else
			return true;
	}

}
