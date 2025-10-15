
public class ClassB {

	 public static void B() {
		try {
			Thread.sleep(5000);
			System.out.println("thread is completed"+Thread.currentThread().getName());
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
}
