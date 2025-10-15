package com.commonadapterfw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonHelp {

public static void main(String[] args) {
	
	try {
		
		JSONArray jjj = new JSONArray("[{\r\n"
				+ "			\"neid\": \"200\",\r\n"
				+ "			\"timestamp\": 1725649377688,\r\n"
				+ "			\"name\": \"PORT-1-1-10\",\r\n"
				+ "			\"s1\": 0.57,\r\n"
				+ "			\"s2\": 0.53,\r\n"
				+ "			\"s3\": 0.08\r\n"
				+ "		},\r\n"
				+ "		{\r\n"
				+ "			\"neid\": \"200\",\r\n"
				+ "			\"timestamp\": 1725649377693,\r\n"
				+ "			\"name\": \"PORT-1-1-10\",\r\n"
				+ "			\"s1\": 0.27,\r\n"
				+ "			\"s2\": 0.87,\r\n"
				+ "			\"s3\": 0.2\r\n"
				+ "		}]");
		
		
		
		BufferedReader bread = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("100_PORT-1-1-3_dataset.json"))));
		String content = null;
		
		
		while ((content = bread.readLine()) != null) {
//			System.out.println(content);
			JSONObject jj = new JSONObject(content);
			System.out.println(jj.getJSONArray("NotifList").length());
			
//			jj.getJSONArray("NotifList").forEach( i -> {
//				System.out.println(i);
//			});
			
	}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	for(int i=101;i<=125;i++) {
		System.out.print(i+" ");
	}
	
	}

}
