package com.wipro.handson;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;


public class Seperation {

	public static void main(String[] args) {
		
		
		Map<String,Map<String,Integer>> stats= new ConcurrentHashMap<>();
		Map<String,Integer> an1=new ConcurrentHashMap<>();
		an1.put("alarm",  29);
		an1.put("nonalarm",30);
		stats.put("101.102.456.44", an1);
		
		Map<String,Integer> an2=new ConcurrentHashMap<>();
		an2.put("alarm",  40);
		an2.put("nonalarm",50);
		stats.put("102.143.601.29", an2);
	//*************************************************	
		int total=0;
		for(String x: stats.keySet()) {
			//System.out.println(stats.get(x));
			total=total+(stats.get(x).get("nonalarm")+stats.get(x).get("alarm"));
		}
		
		int alarmEvents=0;
		for(String x: stats.keySet()) {
			//System.out.println(stats.get(x));
			alarmEvents=alarmEvents+(stats.get(x).get("alarm"));
		}
		
		int nonAlarmEvents=0;
		for(String x: stats.keySet()) {
			//System.out.println(stats.get(x));
			nonAlarmEvents=nonAlarmEvents+(stats.get(x).get("nonalarm"));
		}
		
		Map<String,Integer> totalNotifForEachNe=new ConcurrentHashMap<>();
		for(String x: stats.keySet()) {
			
			//System.out.println(stats.get(x));
			totalNotifForEachNe.put(x,stats.get(x).get("nonalarm")+stats.get(x).get("alarm"));
		}
		
		Map<String,Integer> alarmNotifForEachNe=new ConcurrentHashMap<>();
		for(String x: stats.keySet()) {
			//System.out.println(stats.get(x));
			alarmNotifForEachNe.put(x,stats.get(x).get("alarm"));
		}
		
		Map<String,Integer> nonAlarmNotifForEachNe=new ConcurrentHashMap<>();
		for(String x: stats.keySet()) {
			//System.out.println(stats.get(x));
			nonAlarmNotifForEachNe.put(x,stats.get(x).get("nonalarm"));
		}
		
		System.out.println("total = "+total);
		System.out.println("alarmEvents = "+alarmEvents);
		System.out.println("nonAlarmEvents = "+nonAlarmEvents);
		System.out.println("totalNotifForEachNe = "+totalNotifForEachNe);
		System.out.println("alarmNotifForEachNe = "+alarmNotifForEachNe);
		System.out.println("nonAlarmNotifForEachNe = "+nonAlarmNotifForEachNe);
		
		StringBuilder s=new StringBuilder("{");
		long stime = System.currentTimeMillis();
		Timestamp sts = new Timestamp(stime);
		s.append("\"timeStamp\": "+"\""+sts+"\",");
		s.append(" \"generalInfo\": {\"Origin\": \"nna-adapterfw\", \"instid\": \"9990\"}, \"currentMinuteBin\": {");
		s.append("\"TOTAL_EVENTS\": "+total+", ");
		s.append("\"ALARM_EVENTS\": "+alarmEvents+", ");
		s.append("\"NON_ALARM_EVENTS\": "+nonAlarmEvents+"},");
		s.append("\"currentTopNesBin\": {");
		int commaCount=totalNotifForEachNe.size()-1;
		for(Entry<String, Integer> x :totalNotifForEachNe.entrySet() ) {
			s.append("\""+x.getKey()+"\": "+x.getValue());
			if(commaCount>0)
				s.append(", ");
			commaCount--;
		}
		s.append("}, ");
		s.append("\"granularData\": {");
		s.append("\"ALARM_EVENTS\": {");
		commaCount=alarmNotifForEachNe.size()-1;
		for(Entry<String, Integer> x :alarmNotifForEachNe.entrySet() ) {
			s.append("\""+x.getKey()+"\": "+x.getValue());
			if(commaCount>0)
				s.append(", ");
			commaCount--;
		}
		s.append("}, ");
		s.append("\"NON_ALARM_EVENTS\": {");
		commaCount=nonAlarmNotifForEachNe.size()-1;
		for(Entry<String, Integer> x :nonAlarmNotifForEachNe.entrySet() ) {
			s.append("\""+x.getKey()+"\": "+x.getValue());
			if(commaCount>0)
				s.append(", ");
			commaCount--;
		}
		s.append("} } }");
		System.out.println();
		System.out.println(s.toString());
//		ObjectMapper objMapper = new ObjectMapper();
//		try {
//			JsonNode reqContext = objMapper.readValue(s.toString(), JsonNode.class);
//			System.out.println(reqContext);
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
	}
	
	
	
}
