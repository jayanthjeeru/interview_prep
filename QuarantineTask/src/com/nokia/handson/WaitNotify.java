package com.nokia.handson;

public class WaitNotify {
	public static void main(String[] args) {
		Object obj1 = new Object();
		
		
		Thread t1 = new Thread(() -> {
			synchronized (obj1) {
				
				
				try {
					System.out.println("before t1 wait");
					obj1.wait();
					System.out.println("after t1 wait");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t1 end");
			}
		});
		
		Thread t2 = new Thread(() -> {
			synchronized (obj1) {
				
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				obj1.notify();
				System.out.println("t2 end");
			}
		});
		
		t1.start();
		t2.start();
	}
}
