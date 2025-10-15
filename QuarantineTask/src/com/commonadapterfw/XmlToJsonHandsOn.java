package com.commonadapterfw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.*;
import java.util.Properties;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



public class XmlToJsonHandsOn {
	public static void main(String[] args) throws Exception{
		String msg = "";
		System.out.println("total mem :: "+(Runtime.getRuntime().totalMemory()/1024)/1024);
		System.out.println("free mem 27 :: "+(Runtime.getRuntime().freeMemory()/1000000)+" MB");
		 Properties props = new Properties();
		try (InputStream file = new FileInputStream("rpc.txt")) {
			long start = Runtime.getRuntime().freeMemory();
			System.out.println(start);
            props.load(file);
            msg = props.getProperty("jayrpc");
            long end = Runtime.getRuntime().freeMemory();
            System.out.println(end);
            System.out.println(" this is the used memory "+(((start-end)/1024))+" MB");
            System.out.println(" this is the used memory "+(((start-end)/1024)/1024)+" GB");

	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		

		Map<String , Map<String,String>> shelf = new HashMap<>();
		Map<String , Map<String,String>> card = new HashMap<>();
		
		msg = "<rpc-reply xmlns=\"urn:ietf:params:xml:ns:netconf:base:1.0\"\r\n"
				+ "     message-id=\"103\">\r\n"
				+ "  <data>\r\n"
				+ "    <node-elements xmlns=\"http://nokia.com/yang/nokia-optics-nodel\">\r\n"
				+ "      <provisioned-nodels>\r\n"
				+ "        <provisioned-nodel>\r\n"
				+ "          <name>false</name>\r\n"
				+ "        </provisioned-nodel>\r\n"
				+ "        <provisioned-nodel>\r\n"
				+ "          <name>true</name>\r\n"
				+ "        </provisioned-nodel>\r\n"
				+ "      </provisioned-nodels>\r\n"
				+ "    </node-elements>\r\n"
				+ "  </data>\r\n"
				+ "</rpc-reply>\r\n"
				+ "]]>]]>";
//		msg = "kuku";
		JSONObject js = XML.toJSONObject(msg);
		ObjectMapper objMapper = new ObjectMapper();
		try {
			JsonNode jn = objMapper.readValue(js.toString(), JsonNode.class);
			System.out.println();
			if(jn.findValue("provisioned-nodels")!=null)
			for(JsonNode j : jn.findValue("provisioned-nodels").findValues("name"))
				System.out.println(j.asBoolean());
//			System.out.println(jn.findValue("data").findValue("components"));
//			System.exit(0);
//			List<JsonNode> a = jn.findValue("data").findValue("components").findValue("component").findValues("state");
//		int c =0;
//			for(JsonNode n : a) {
//				if( n.has("n-o-oc-plat-ext:hardware-name") && ((n.findValue("name")!=null && n.findValue("name").asText().toLowerCase().contains("card"))||( n.findValue("name")!=null && n.findValue("name").asText().toLowerCase().contains("chassis")))) {
//					
//					if(n.findValue("name").asText().toLowerCase().contains("chassis")) {
//						Map<String,String> shelfmap = new HashMap<>();
//						shelfmap.put("serial-no", n.has("serial-no")?n.findValue("serial-no").asText():"");
//						shelfmap.put("mfg-date", n.has("mfg-date")?n.findValue("mfg-date").asText():"");
//						shelfmap.put("description", n.has("description")?n.findValue("description").asText():"");
//						shelfmap.put("part-no", n.has("part-no")?n.findValue("part-no").asText():"");
//						shelfmap.put("name", n.findValue("name").asText());
//						shelf.put(n.findValue("name").asText(), shelfmap);
//					}
//					else if (n.findValue("name").asText().toLowerCase().contains("card")) {
//						c++;
//						Map<String,String> cardmap = new HashMap<>();
//						cardmap.put("serial-no", n.has("part-no")?n.findValue("part-no").asText():"");
//						cardmap.put("mfg-date", n.has("part-no")?n.findValue("part-no").asText():"");
//						cardmap.put("description", n.has("part-no")?n.findValue("part-no").asText():"");
//						cardmap.put("part-no", n.has("part-no")?n.findValue("part-no").asText():"");
//						card.put(n.findValue("name").asText(), cardmap);
//					}
//					System.out.println(n.findValue("name"));
////					System.out.println(n);
//					
//				}
//			}
//			System.out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
//		System.out.println();
//		System.out.println(card);
//		System.out.println();
//		System.out.println(shelf);
		
//		Map< String,Map<String , Map<String,String>>> tree = new HashMap<>();
//		
//		
//		for(String s : shelf.keySet()) {
//			Map<String , Map<String,String>> cardm = new HashMap<>();
//			Map<String , Map<String,String>> shelfm = new HashMap<>();
//			for(String c : card.keySet()) {
//				if(c.split("-")[1].equals(s.split("-")[1])) {
//					cardm.put(c, card.get(c));
//				}
//			}
//			cardm.put(s, shelf.get(s));
//			
//			tree.put(s, cardm);
//		}
//		
//		System.out.println(tree);
		
		System.out.println("free mem 111 :: "+(Runtime.getRuntime().freeMemory()/1000000)+" MB");
		
	}
}
