package com.java.cassandrasupport;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Waste {

	   static ObjectMapper objectMapper = new ObjectMapper();
	    static Properties p = new Properties();

	public static void main(String[] args) {
		 
        try {
        	  FileInputStream reader=new FileInputStream("test.properties");  
      		
      		p.load(reader);
      		
      		System.out.println(p.get("1"));
      		
      		
      		transformer3(p.getProperty("2"));
      		
      		Map<String, List<String>> sss = new HashMap<>();
      		
      		List<String> l = new ArrayList<>();
      		
      		l.add("hi");
      		l.add("sss");
      		
      		sss.put("cha-1", l);
      		sss.put("cha-1=2", l);
      		JSONObject jooo = new JSONObject(sss);
      		
      		System.out.println(jooo);
      		
        } catch (Exception e) {
			e.printStackTrace();
		}
        
	}
	
	public static void transformer(String input) throws JSONException {
		 JSONObject jsonObject = new JSONObject(input);

	        // Extract the necessary data from state
	        JSONObject state = jsonObject.getJSONObject("state");
	        jsonObject.put("part-no", state.getString("part-no"));
	        jsonObject.put("hardware-version", state.getString("hardware-version"));
	        jsonObject.put("mfg-name", state.getString("mfg-name"));
	        jsonObject.put("allocated-power", state.getDouble("allocated-power"));
	        jsonObject.put("used-power", state.getDouble("used-power"));
	        jsonObject.put("description", state.getString("description"));
	        jsonObject.put("mfg-date", state.getString("mfg-date"));
	        jsonObject.put("serial-no", state.getString("serial-no"));
	        jsonObject.put("removable", state.getBoolean("removable"));
	        jsonObject.put("location", state.getString("location"));
	        jsonObject.put("id", state.getString("id"));
	        jsonObject.put("oper-status", state.getJSONObject("oper-status").getString("content"));
	        jsonObject.put("equipment-mismatch", state.getJSONObject("equipment-mismatch").getBoolean("content"));
	        jsonObject.put("equipment-failure", state.getJSONObject("equipment-failure").getBoolean("content"));
	        jsonObject.put("type", state.getJSONObject("type").getString("content"));

	        // Extract properties
	        JSONObject properties = jsonObject.getJSONObject("properties");
	        JSONArray propertiesArray = properties.getJSONArray("property");
	        for (int i = 0; i < propertiesArray.length(); i++) {
	            JSONObject property = propertiesArray.getJSONObject(i);
	            String name = property.getString("name");
	            String value = property.getJSONObject("state").getString("value");
	            jsonObject.put(name, value);
	        }

	        // Remove the unnecessary fields
	        jsonObject.remove("state");
	        jsonObject.remove("properties");
	        jsonObject.remove("subcomponents");
	        jsonObject.remove("config");

	        // Print the transformed JSON object
	        System.out.println(jsonObject.toString(4));
	    
		
	}
	
	public static void transformer1(String jsonString) throws JSONException {
		JSONObject jsonObject = new JSONObject(jsonString);

        // Extract the necessary data from state
        JSONObject state = jsonObject.optJSONObject("state");

        if (state != null) {
            // Add each field from state if available, checking for null values
            jsonObject.put("part-no", state.optString("part-no", null));
            jsonObject.put("hardware-version", state.optString("hardware-version", null));
            jsonObject.put("mfg-name", state.optString("mfg-name", null));
            jsonObject.put("allocated-power", state.optDouble("allocated-power", -1));
            jsonObject.put("used-power", state.optDouble("used-power", -1));
            jsonObject.put("description", state.optString("description", null));
            jsonObject.put("mfg-date", state.optString("mfg-date", null));
            jsonObject.put("serial-no", state.optString("serial-no", null));
            jsonObject.put("removable", state.optBoolean("removable", false));
            jsonObject.put("location", state.optString("location", null));
            jsonObject.put("id", state.optString("id", null));

            // Handle nested 'oper-status', 'equipment-mismatch', 'equipment-failure', and 'type'
            jsonObject.put("oper-status", state.optJSONObject("oper-status") != null ?
                    state.getJSONObject("oper-status").optString("content", null) : null);
            jsonObject.put("equipment-mismatch", state.optJSONObject("equipment-mismatch") != null ?
                    state.getJSONObject("equipment-mismatch").optBoolean("content", false) : false);
            jsonObject.put("equipment-failure", state.optJSONObject("equipment-failure") != null ?
                    state.getJSONObject("equipment-failure").optBoolean("content", false) : false);
            jsonObject.put("type", state.optJSONObject("type") != null ?
                    state.getJSONObject("type").optString("content", null) : null);
        }

        // Extract properties
        JSONObject properties = jsonObject.optJSONObject("properties");
        if (properties != null) {
            JSONArray propertiesArray = properties.optJSONArray("property");
            if (propertiesArray != null) {
                for (int i = 0; i < propertiesArray.length(); i++) {
                    JSONObject property = propertiesArray.optJSONObject(i);
                    if (property != null) {
                        String name = property.optString("name", null);
                        String value = property.optJSONObject("state") != null ?
                                property.getJSONObject("state").optString("value", null) : null;
                        if (name != null) {
                            jsonObject.put(name, value);
                        }
                    }
                }
            }
        }

        // Remove the unnecessary fields
        jsonObject.remove("state");
        jsonObject.remove("properties");
        jsonObject.remove("subcomponents");
        jsonObject.remove("config");
        jsonObject.remove("port");
        // Print the transformed JSON object
        System.out.println(jsonObject.toString(4));
	}
	
    public static void transformer3(String inp) throws JSONException {
    	 JSONObject jsonObject = new JSONObject(inp);

         // Extract the necessary data from state
         JSONObject state = jsonObject.optJSONObject("state");

         if (state != null) {
             // Add each field from state if available, checking for null values
             jsonObject.put("part-no", state.optString("part-no", ""));
             jsonObject.put("hardware-version", state.optString("hardware-version", ""));
             jsonObject.put("mfg-name", state.optString("mfg-name", ""));
             jsonObject.put("allocated-power", state.optDouble("allocated-power", 0.0));
             jsonObject.put("used-power", state.optDouble("used-power", 0.0));
             jsonObject.put("description", state.optString("description", ""));
             jsonObject.put("mfg-date", state.optString("mfg-date", ""));
             jsonObject.put("serial-no", state.optString("serial-no", ""));
             jsonObject.put("removable", state.optBoolean("removable", false));
             jsonObject.put("location", state.optString("location", ""));
             jsonObject.put("id", state.optString("id", ""));

             // Handle nested 'oper-status', 'equipment-mismatch', 'equipment-failure', and 'type'
             jsonObject.put("oper-status", state.optJSONObject("oper-status") != null ?
                     state.getJSONObject("oper-status").optString("content", "") : "");
             jsonObject.put("equipment-mismatch", state.optJSONObject("equipment-mismatch") != null ?
                     state.getJSONObject("equipment-mismatch").optBoolean("content", false) : false);
             jsonObject.put("equipment-failure", state.optJSONObject("equipment-failure") != null ?
                     state.getJSONObject("equipment-failure").optBoolean("content", false) : false);
             jsonObject.put("type", state.optJSONObject("type") != null ?
                     state.getJSONObject("type").optString("content", "") : "");
         }

         // Extract properties
         JSONObject properties = jsonObject.optJSONObject("properties");
         if (properties != null) {
             JSONArray propertiesArray = properties.optJSONArray("property");
             if (propertiesArray != null) {
                 for (int i = 0; i < propertiesArray.length(); i++) {
                     JSONObject property = propertiesArray.optJSONObject(i);
                     if (property != null) {
                         String name = property.optString("name", "");
                         String value = property.optJSONObject("state") != null ?
                                 property.getJSONObject("state").optString("value", "") : "";
                         jsonObject.put(name, value);
                     }
                 }
             }
         }

         // Remove the unnecessary fields
         jsonObject.remove("state");
         jsonObject.remove("properties");
         jsonObject.remove("subcomponents");
         jsonObject.remove("config");
         jsonObject.remove("port");
         // Print the transformed JSON object
         System.out.println(jsonObject.toString(4));
    }
	
}
