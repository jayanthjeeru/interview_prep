package filereaderandwriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class FileRD_WT {

	public static void main(String[] args) {
		
//		try {
//			BufferedWriter writer =new BufferedWriter(new FileWriter("device2.txt",true));
//			writer.append("deviceID : "+ "18930"+"$");
//			
////			writer.write("\n2nd line asdsaf");
//			writer.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
			List<String> nodeIds = new ArrayList<>();	
			BufferedReader reader =new BufferedReader(new FileReader("file.csv"));
			String line;
			while((line=reader.readLine())!=null) {
				nodeIds.addAll(Arrays.asList(line.split(",")));
				
			}
			reader.close();
			
			System.out.println(nodeIds);
			
			System.out.println(System.getProperty("JAVA_HOME"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		

	}
	
	public String msg() {
		return "reflection";
	}

}
