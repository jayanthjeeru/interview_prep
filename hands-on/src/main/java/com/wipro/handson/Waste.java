package com.wipro.handson;

import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;


public class Waste {
	
	static int x = 0; 

	private static AtomicLong threadCount = new AtomicLong();
	
	public static void main(String[] args) {
		
//		ThreadPoolExecutor exec =   (ThreadPoolExecutor) Executors.newFixedThreadPool(100);
//				
//		
//		for(int i=0 ;i<10000;i++) {
//			exec.submit(()-> {
//				
//				try {
//					Thread.sleep(90000);
//					
//					System.out.println("thread done");
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				
//			});
//			
//			System.out.println("hi finish with count "+i);
//		}
//		
//			
//		Executors.newFixedThreadPool(1).submit(new threadMonitor(exec));
//		
//		
		
//		check(null);
		
		int i=0;
		while(i<5) {
			
			long x = threadCount.getAndIncrement();
			
			System.out.println("thread-"+x);
			i++;
		}
		
	}
	
	
	private static void check(String str) {
		if(str == null) {
			try {
				Thread.sleep(3000);
				x++;
				if(x<=5) {
					System.out.println("x is :: "+x+ "date is :: "+ System.currentTimeMillis());
					check(str);
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

class threadMonitor implements Runnable {
	
	ThreadPoolExecutor exec = null;
	

	public threadMonitor(ThreadPoolExecutor exec) {
		
		this.exec = exec;
	}


	@Override
	public void run() {
		
		
		
		while(true) {
			
			try {
				
				
				
				
				System.out.println("***********Start************ " + new Date() + " \n");
				
				
				System.out.println("exec.getActiveCount() "+ exec.getActiveCount());
				System.out.println("exec.getCompletedTaskCount() "+ exec.getCompletedTaskCount());
				System.out.println("exec.getCorePoolSize() "+ exec.getCorePoolSize());
				System.out.println("exec.getLargestPoolSize() "+ exec.getLargestPoolSize());
				System.out.println("exec.getKeepAliveTime() "+ exec.getKeepAliveTime(TimeUnit.SECONDS));
				System.out.println("exec.getMaximumPoolSize() "+ exec.getMaximumPoolSize());
				System.out.println("exec.getPoolSize() "+ exec.getPoolSize());
				System.out.println("exec.getTaskCount() "+ exec.getTaskCount());
				
				System.out.println("***************************End****************** \n");
				
				
				System.out.println();
				
				
				
				Thread.sleep(20000);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
}

