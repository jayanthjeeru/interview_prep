package com.commonadapterfw;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToPojoMapping {
	
	public static void main(String[] args) {
		try {
			
			String s ="{\"name\":\"jayanth\",\r\n"
					+ "\"rollNum\":54\r\n"
					+ "}";
			
			ObjectMapper o = new ObjectMapper();
			
		Student ss = o.readValue(s,Student.class);
		 
		 System.out.println(ss);
		 
		 System.out.println(ss.getName());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
