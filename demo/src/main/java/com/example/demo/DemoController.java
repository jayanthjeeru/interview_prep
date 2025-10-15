package com.example.demo;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	
	LinkedBlockingDeque<String> req = new LinkedBlockingDeque<>();
	
	public DemoController() {
		ExecutorService e = Executors.newFixedThreadPool(5);
		
		for(int i=0;i<5;i++) {
			e.submit(new NonTelemetryTask1(req));
		}
//				
	}

	 
	
	@GetMapping("Shelf/{req1}")
	public String message(@PathVariable String req1) {
		
		for(int i=0;i<1000;i++) {
			req.add("req-"+i);
		}
		
//		req.add(req1);
		
//		display(req1); waste
		
		return "hi"+req1;
	}
	
	
	public synchronized void display(String req1) {
		
		try {
			
			System.out.println(" the  is started !!! "+req1 );

			
			Thread.sleep(20000);
			
			System.out.println(" the  is completed !!! "+req1 );
		} catch (Exception e) {

		}
	}
	
}


class NonTelemetryTask1 implements Runnable {

	
	LinkedBlockingDeque<String> req = null;
	
	NonTelemetryTask1(LinkedBlockingDeque<String> req) {
		this.req =req;
	}
	
	
	@Override
	public void run() {
		
		while(true) {
			try {
				String ss = req.poll(20, TimeUnit.SECONDS);
				processReq(ss);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
		}
		
	}
	
	private  void processReq(String req) {
		
		try {
			System.out.println(req);
			
			Thread.sleep(50);
			
			
			
			
			
			System.out.println(" the "+req+" is completed !!!"+Thread.currentThread().getName());
		} catch (Exception e) {

		}
		
	}
	
}


