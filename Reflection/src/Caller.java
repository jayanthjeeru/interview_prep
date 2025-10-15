import java.lang.reflect.InvocationTargetException;

public class Caller {

	public static void main(String[] args) {
		
		provider p = new provider();
		
		
		try {
			try {
				System.out.println(p.getClass().getMethod("met",String.class).invoke(p,"hi"));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
