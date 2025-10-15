package com.commonadapterfw;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class SopJsonParser {
	
	public static void main(String[] args) {
		String message = "{\"notification\":[{\"timestamp\":1625837623000000000,\"update\":[{\"path\":{\"elem\":[{\"name\":\"/components/component/PORT-1-3-L1\"}]},\"val\":{\"flight-recorder-instance-data\":{\"instance\":{\"path\":{\"elem\":[{\"name\":\"/components/component/PORT-1-3-L1\"}]},\"type\":\"STATE_OF_POLARIZATION\"},\"record\":[{\"sop-record\":{\"s1\":0.1,\"s2\":0.2,\"s3\":0.2,\"lof-oof-state\":1,\"relative-time-stamp\":5000}}],\"absolute-time-stamp\":\"1625837623000000000\"}}}]}]}";

		String timeStamp = "";
		String portLabel = "";
		double s1 = 0.0;
		double s2 = 0.0;
		double s3 = 0.0;
		
		JSONObject jsonMessage1 = new JSONObject();
		
		System.out.println(jsonMessage1.isEmpty());
		
		
		JSONObject jsonMessage = new JSONObject(message);
		
		JSONArray notifications = jsonMessage.getJSONArray("notification");
		
		for (Object notification : notifications) {

			JSONObject jsonNotification = (JSONObject) notification;
			
			timeStamp = jsonNotification.getLong("timestamp")+"";
			
			JSONObject update = (JSONObject) jsonNotification.getJSONArray("update").get(0);

			JSONObject elem = (JSONObject) update.getJSONObject("path").getJSONArray("elem").get(0);
			
			portLabel =  elem.getString("name").split("/")[elem.getString("name").split("/").length-1];
			
			JSONObject record = (JSONObject) update.getJSONObject("val").getJSONObject("flight-recorder-instance-data").getJSONArray("record").get(0);
			
			s1 = record.getJSONObject("sop-record").getDouble("s1");
			s2 = record.getJSONObject("sop-record").getDouble("s2");
			s3 = record.getJSONObject("sop-record").getDouble("s3");
			
		}
		
		
		
		System.out.println(timeStamp);
		
		System.out.println(portLabel);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		Map<String, Object> sopResponseAttributes = new HashMap<>();
		
		sopResponseAttributes.put("timeStamp", timeStamp);
		
		sopResponseAttributes.put("portLabel", portLabel);
		
		sopResponseAttributes.put("portid", "");
		sopResponseAttributes.put("tplabel", "");
		sopResponseAttributes.put("neid", "");
		
		sopResponseAttributes.put("s1", s1);
		sopResponseAttributes.put("s2", s2);
		sopResponseAttributes.put("s3", s3);
		
		
		String translatedMessage = frameFinalMessage(sopResponseAttributes).toString();
		
		System.out.println(translatedMessage);
		
		
	}
	
	
	public static JSONObject frameFinalMessage(Map<String, Object> sopResponseAttributes) {
		
		JSONObject finalMessage = new JSONObject();
		
		
		
		try {
			finalMessage.put("dtis", sopResponseAttributes.get("timeStamp"));
			finalMessage.put("neid", sopResponseAttributes.get("neid"));
			finalMessage.put("portid", sopResponseAttributes.get("portid"));
			finalMessage.put("tplabel", sopResponseAttributes.get("tplabel"));
			finalMessage.put("s1", sopResponseAttributes.get("s1"));
			finalMessage.put("s2", sopResponseAttributes.get("s2"));
			finalMessage.put("s3", sopResponseAttributes.get("s3"));
			
		} catch (Exception e) {
			
		}
		
		return finalMessage;
	}

}
