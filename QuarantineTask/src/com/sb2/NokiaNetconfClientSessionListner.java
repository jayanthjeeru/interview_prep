package com.sb2;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import com.sbi.SbiEventManager;

public class NokiaNetconfClientSessionListner {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		
			NokiaNetconfClientSessionListner sss=new NokiaNetconfClientSessionListner();
			sss.onMessage(20,"202.303.404.505");
			
		}
	
	
	
	public void onMessage(int a,String s) {
		Map<String,Integer>m=new ConcurrentHashMap<>();
//		some logic
		m.put("alarm", a);
		m.put("nonalarm", a);
		SbiEventManager.stats.put(s, m);
	}
	
}
