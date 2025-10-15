
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ExecutorScheduledThreadPractice {

	
	public static void main(String[] args) {
		ScheduledExecutorService ser = Executors.newScheduledThreadPool(1);
		
		
		Scanner sc = new Scanner(System.in);
		
		
		
		while(true) {
			String s = sc.nextLine();
			
			if(s.equals("stop")) {
				ser.shutdown();
				break;
			}
				
			
			else {
				ser.scheduleAtFixedRate(new NonTelemetryTask(s), 0, 2, TimeUnit.SECONDS);
			}
			
		}
			
		
		
        
	}
	
			
	
}

class NonTelemetryTask implements Runnable {

	String sss = "";
	
	
	
	public NonTelemetryTask(String sss) {
	
		this.sss = sss;
	}



	@Override
	public void run() {
		
		Thread.currentThread();
	
		System.out.println("Hi there !!!"+ sss);
		
		
		
		

		
	}
	
}
