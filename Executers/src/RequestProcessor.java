import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executors;

public class RequestProcessor {
	
	
	static Deque<String> req = new ConcurrentLinkedDeque<>();
	
	public static void main(String[] args) {
		Executors.newFixedThreadPool(1).submit(new NonTelemetryTask1(req));
	}
	
}


class NonTelemetryTask1 implements Runnable {

	
	Deque<String> req = null;
	
	NonTelemetryTask1(Deque<String> req) {
		this.req =req;
	}
	
	
	@Override
	public void run() {
		
		while(true) {
			if(!req.isEmpty()) {
				processReq(req.poll());
			}
		}
		
	}
	
	private void processReq(String req) {
		
		try {
			System.out.println(req);
			Thread.sleep(5000);
			
			System.out.println(" the "+req+" is completed !!!");
		} catch (Exception e) {

		}
		
	}
	
}

