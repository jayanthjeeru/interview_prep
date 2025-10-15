package pmtest;

import com.fasterxml.jackson.databind.util.JSONPObject;

public class Base64 {

	public static void main(String[] args) {
		
		String json = "channel[index=1010101111]";
		
		System.out.println(json.substring(json.indexOf("[")+1, json.indexOf("]")).split("="));
		

		System.out.println();
		
	}
	
}
