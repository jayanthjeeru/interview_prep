import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadShutdown {
	public static void main(String[] args) {
        // Create ExecutorService with a fixed number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Thread.currentThread();
        
        // Submit tasks to the ExecutorService
        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
        	Future<String> future = executorService.submit(new NonTelemetryTask2());
        	futureList.add(future);
        }

        List<String> resultList = new ArrayList<>();
		for (Future<String> future : futureList) {
			try {
				
				future.get(2,TimeUnit.SECONDS);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
        System.out.println("ends");
        // Shutdown the ExecutorService
        executorService.shutdown();
//
//        try {
//            // Wait for all tasks to complete or timeout after a certain time
//            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
//                // If the timeout occurs, force shutdown
//                executorService.shutdownNow();
//            }
//        } catch (InterruptedException e) {
//            // Handle interruption if necessary
//            e.printStackTrace();
//        }
    }
}


class NonTelemetryTask2 implements Callable<String> {

	

	@Override
	public String call() throws Exception {
		
		
		long ii = 1000000000000000000l;
		Thread.sleep(3000);
		while(ii<0) {
			ii++;
		}
		System.out.println("Executing task...");
		return "true";
	}
	
}
