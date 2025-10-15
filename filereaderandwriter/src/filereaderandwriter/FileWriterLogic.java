package filereaderandwriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class FileWriterLogic {

	public static void main(String[] args) {
		
		
//		System.out.println(new File("C:\\Users\\jayreddy\\Documents\\otdrbug.patch").exists());
//		
//		String fileName = "10001.meta";
//		
//		if(new File("10001.meta").exists())
//			fileName = "10001.meta" + ".jiga";
		
	

		if(!new File("C:\\Users\\jayreddy\\Documents\\testFolder1").exists()) {
			new File("C:\\Users\\jayreddy\\Documents\\testFolder1").mkdir();
		}
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\jayreddy\\Documents\\testFolder1\\hi.txt", false));) {
			
			System.out.println();
			
			Scanner sc =new Scanner(System.in);
			
		while(true) {
			String s = sc.next();
			
			if(s.equals("0")) {
				break;
			}
			
			writer.append(s+"\n");
			
		}
			


			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
