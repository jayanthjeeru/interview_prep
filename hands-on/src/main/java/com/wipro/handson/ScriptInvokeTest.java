package com.wipro.handson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.Timestamp;

public class ScriptInvokeTest {
	
	public static void main(String[] args) {
		
//		try {
//			Process p = Runtime.getRuntime().exec("sh C:\\Users\\jayreddy\\Documents\\STS_WORKSPACE\\hands-on\\src\\main\\resources\\shscripttest.sh");
//			
//			System.out.println(p.info());
//			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
//			String output = in.readLine();
//			in.close();
//			
//			System.out.println(output);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		System.out.println(System.currentTimeMillis());
		
		System.out.println(new java.sql.Timestamp(System.currentTimeMillis()));
		
		
	}

}
