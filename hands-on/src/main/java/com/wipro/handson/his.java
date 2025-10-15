package com.wipro.handson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class his {

	
	public static void main(String[] args) {
		try {
			BufferedWriter writer =new BufferedWriter(new FileWriter("src/main/resources/device3.txt"));
			writer.append("deviceID : "+ "18930"+"$");
			
//			writer.write("\n2nd line asdsaf");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
