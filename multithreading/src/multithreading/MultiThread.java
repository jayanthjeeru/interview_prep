package multithreading;

public class MultiThread implements Runnable{

	private String s=null;
	private int ii=0;
	MultiThread(String s,int ii){
		this.s=s;
		this.ii=ii;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName("beautiful thread");
		for(int i=1;i<=5;i++) {
			System.out.println(i + " " + s + " thread number is ::" + ii );
//			try {
//				Thread.currentThread().sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
		
	}

}
