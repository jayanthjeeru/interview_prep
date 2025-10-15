package com.wipro.handson;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Demo {

	public static void main(String[] args) {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
		
		Scanner sc =new Scanner(System.in);
		
		Executors.newFixedThreadPool(1).submit(new Polling(queue));
		
		while(true) {
			System.out.print(">");
			String s = sc.next();
			queue.add(s);
			if(s.equals("0"))
				break;
		}
		
		
	}
}

class Polling implements Runnable {

	LinkedBlockingQueue<String> queue = null;
	
	public Polling(LinkedBlockingQueue<String> queue) {
		
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("this is before poll");
			String s = queue.poll(10,TimeUnit.SECONDS);
				System.out.println("this is after poll :: " + s);
			} catch (Exception e) {
				// 
			}
			
		}
		
	}
	
}
