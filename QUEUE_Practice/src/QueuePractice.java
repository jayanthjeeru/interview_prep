import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueuePractice {
	
	public static void main(String[] args) {
		Queue<String> q = new ConcurrentLinkedQueue<>();
		
		
		
		q.add("hi");
		q.add("hello");
		q.add("bye");
		
		while(!q.isEmpty())
			System.out.println(q.poll());
		
		System.out.println(q);
	}

}
