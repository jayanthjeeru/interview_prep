package com.nokia.handson;

public class Deadlock {

	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		Thread t1 = new Thread(() -> {
			System.out.println("t1 start");
			synchronized (obj2) {
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("t1 before obj1");
				synchronized (obj1) {

				}
				System.out.println("t1 end");
			}
			
			
		});
		
		Thread t2 = new Thread(() -> {
			System.out.println("t2 start");
			synchronized (obj1) {
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("t2 before obj2");
				synchronized (obj2) {

				}
				System.out.println("t2 end");
			}
			
			
		});
		
		t1.start();
		t2.start();
		
	}
}
