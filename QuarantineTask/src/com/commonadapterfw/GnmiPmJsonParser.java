package com.commonadapterfw;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class GnmiPmJsonParser {

	public static void main(String[] args) {
		
		List<Map<String,String>> pmAttributes = new ArrayList<>();
		
		String s = "{\r\n"
				+ "  \"source\": \"135.249.190.156:8980\",\r\n"
				+ "  \"subscription-name\": \"default-1702932581\",\r\n"
				+ "  \"timestamp\": 1663128824817254960,\r\n"
				+ "  \"time\": \"2022-09-14T09:43:44.81725496+05:30\",\r\n"
				+ "  \"updates\": [\r\n"
				+ "    {\r\n"
				+ "      \"Path\": \"components/component[name=TRANSCEIVER-1-1-C2]/transceiver/nokia-telemetry-ext/state/input-power-thresholds/delta-threshold\",\r\n"
				+ "      \"values\": {\r\n"
				+ "        \"components/component/transceiver/nokia-telemetry-ext/state/input-power-thresholds/delta-threshold\": \"0.0\"\r\n"
				+ "      }\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		
		jsonParser(s, pmAttributes);
		
		
		String ss = "P0";
		
		System.out.println(ss.matches("[0-9]+"));
	}
	
	
	public static void  jsonParser(String jsonString,List<Map<String,String>> pmAttributes) {
		
		
		if(jsonString.contains("prefix")) {
			jsonParserWithPrefix(jsonString, pmAttributes);
		} else {
			JSONObject jo = new JSONObject(jsonString);
			
			String source = jo.getString("source");
			String subscriptionName = jo.getString("subscription-name");
			long timestamp = jo.getLong("timestamp");
			String time = jo.getString("time");
			String Path = jo.getJSONArray("updates").getJSONObject(0).getString("Path");
			String name = Path.substring(Path.indexOf("["), Path.indexOf("]")+1);
			System.out.println(name.replace("[", "").replace("]", "").split("=")[1]);
			String value = jo.getJSONArray("updates").getJSONObject(0).getJSONObject("values").getString(Path.replace(Path.substring(Path.indexOf("["), Path.indexOf("]")+1), ""));
		
			System.out.println(source + " " + " "+subscriptionName + " "+timestamp+ " "+time + " "+ Path + " "+ value);
		}
	}
	
	public static void  jsonParserWithPrefix(String jsonString,List<Map<String,String>> pmAttributes) {
		JSONObject jo = new JSONObject(jsonString);
		String source = jo.getString("source");
		String subscriptionName = jo.getString("subscription-name");
		long timestamp = jo.getLong("timestamp");
		String time = jo.getString("time");
		
		String prefix = jo.getString("prefix");
		
		JSONArray updates = jo.getJSONArray("updates");
		
		
		
		for(Object update : updates) {
			JSONObject jsonUpdate = (JSONObject)update;
			String path = jsonUpdate.getString("Path");
			String value = jsonUpdate.getString(path);
		}
		
		
		
	}
	
	
}
