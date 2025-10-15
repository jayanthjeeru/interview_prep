package multithreading;

public class Driver {
	public static void main(String[] args) {
		
//		Thread t = new Thread(mt);
		
		for(int i=1;i<=5;i++) {
			MultiThread mt=new MultiThread("hello",i);
			Thread t = new Thread(mt);
//			System.out.println(Thread.currentThread().getName());
			t.start();
			
			try {
				t.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
