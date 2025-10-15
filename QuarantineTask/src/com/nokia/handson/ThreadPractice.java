package com.nokia.handson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPractice implements Runnable {
	
//	ExecutorService ex = Executors.newFixedThreadPool(10);
	
	public void run() {
		
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(Thread.currentThread().getName());
		
//		ex.submit( () -> {
//			System.out.println();
//		});
	}
	
	public static void main(String[] args) {
		ThreadPractice th = new ThreadPractice();
		
		Thread th1 = new Thread(th);
		
		th1.start();
		
		System.out.println(Thread.currentThread().getName());
		
		
		
	}

}
