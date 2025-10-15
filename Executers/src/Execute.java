import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Execute {

	public static void main(String[] args) {

		Execute e = new Execute();
		e.ram();

	}

	public void ram() {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		Collection<Callable<Void>> tasks = new ArrayList<>();
		
		for(int i=0;i<3;i++) {
			Map<String , String> m = new HashMap<>();
		m.put(i+"", i+"");
			tasks.add(new Student("jay",m));
//			m.clear();
		}
		
		
//		tasks.add(new Student("vai",new HashMap<>()));
//		tasks.add(new Student("java",new HashMap<>()));
		
		tasks.forEach(task -> {
			
			Future<Void> future = executor.submit(task);
	
		});
		
		executor.shutdown();
	}

	public synchronized void getmessage(Map<String, String> m) {
		System.out.println("hi by thread" + Thread.currentThread().getName());
		System.out.println(m);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public class Student implements Callable<Void> {

		String name;
		Map<String,String> m;
		
		public Student() {
			
		}
		
		public Student(String name, Map<String, String> m) {
			
			this.name = name;
			this.m = m;
			
//			System.out.println(m);
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public Map<String, String> getM() {
			return m;
		}



		public void setM(Map<String, String> m) {
			this.m = m;
		}



		@Override
		public Void call() throws Exception {
//			System.out.println("rambo....!!"+name);
//			System.out.println(Thread.currentThread().getName());
			
			ClassA.A();
			return null;

		}
	}

}
