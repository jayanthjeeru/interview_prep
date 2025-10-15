package com.commonadapterfw;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHandsOn {

//	public static void main(String[] args) {
//		
//		
//		
//		List<String> ls = Arrays.asList(new String[] {"CARD-1-2","sx14320-1-1-1","PORT-1-1-4","PORT-1-1-2","PORT-1-1-3","CARD-1-1","PORT-1-2-1","PORT-1-2-4","PORT-1-2-2","PORT-1-2-3"});
//		
//		List<Port> ls1 = Arrays.asList(new Port("CARD-1-2",""),new Port("PORT-1-1-4",""),new Port("PORT-1-1-2",""),new Port("PORT-1-1-3",""),new Port("CARD-1-1",""),new Port("PORT-1-2-1",""),new Port("PORT-1-2-4",""),new Port("PORT-1-2-2",""),new Port("PORT-1-2-3",""),new Port("sx14320-1-1-1",""));
//
//		
//		Comparator<String> com =new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				 System.out.println(o1+" ;;; "+ o2);
//				 o1 = o1.substring(o1.indexOf("-"),o1.length());
//				 o2 = o2.substring(o2.indexOf("-"),o2.length());
//				 System.out.println(o1+" ;;; "+ o2);
//				return o1.compareTo(o2);
//			}
//			
//			
//			
//		};
////		System.out.println(ls);
////		ls.sort(com);
////		System.out.println(ls);
//		
//		
//		Comparator<Port> com1 =new Comparator<Port>() {
//
//			@Override
//			public int compare(Port p1, Port p2) {
//				String o1 = p1.getAid();
//				String o2 = p2.getAid();
//				System.out.println(o1+" ;;; "+ o2);
//				 o1 = o1.substring(o1.indexOf("-"),o1.length());
//				 o2 = o2.substring(o2.indexOf("-"),o2.length());
//				 System.out.println(o1+" ;;; "+ o2);
//				return o1.compareTo(o2);
//			}
//		};
//		
//		System.out.println(ls1);
//		ls1.sort(com1);
//		System.out.println(ls1);
//		
//	}
	
	
	public static void main(String[] args) {
		String s = "<namessage>\r\n"
				+ "	<hdr>\r\n"
				+ "		<opReqId>1716960610916</opReqId>\r\n"
				+ "		<opRole>NOTIF</opRole>\r\n"
				+ "		<opName>Notification_Handling_neChange</opName>\r\n"
				+ "		<opReqTime>1716960610916</opReqTime>\r\n"
				+ "		<objectType>OT_MANAGED_ELEMENT</objectType>\r\n"
				+ "		<notificationType>NT_ATTRIBUTE_VALUE_CHANGE</notificationType>\r\n"
				+ "	</hdr>\r\n"
				+ "	<Notification_Handling_neChangerqst>\r\n"
				+ "		<attrIndicator>\r\n"
				+ "			<dsCommon_StringList_Telem>OpenAgentEnabled</dsCommon_StringList_Telem>\r\n"
				+ "		</attrIndicator>\r\n"
				+ "		<ne>\r\n"
				+ "			<ne>\r\n"
				+ "				<ncName>EML_100_SNA</ncName>\r\n"
				+ "				<neName>726</neName>\r\n"
				+ "			</ne>\r\n"
				+ "			<newNeName>726</newNeName>\r\n"
				+ "			<userLabel>PSS24X_1</userLabel>\r\n"
				+ "			<owner/>\r\n"
				+ "			<nativeName/>\r\n"
				+ "			<location>NOKIA</location>\r\n"
				+ "			<version>24.6</version>\r\n"
				+ "			<nativeVersion>24.6</nativeVersion>\r\n"
				+ "			<productName>1830PSS</productName>\r\n"
				+ "			<nodeType>1830PSS</nodeType>\r\n"
				+ "			<managedState/>\r\n"
				+ "			<communicationState>CS_UP</communicationState>\r\n"
				+ "			<emsInSyncState>false</emsInSyncState>\r\n"
				+ "			<supportedRates/>\r\n"
				+ "			<onnsCapability/>\r\n"
				+ "			<ipAddress>25.26.245.196</ipAddress>\r\n"
				+ "			<sigIPaddress/>\r\n"
				+ "			<commParams/>\r\n"
				+ "			<timezone/>\r\n"
				+ "			<daylight/>\r\n"
				+ "			<time>0</time>\r\n"
				+ "			<additionalInfo>\r\n"
				+ "				<globalDefs_NVSList_Telem>\r\n"
				+ "					<name>OpenAgentEnabled</name>\r\n"
				+ "					<value>2</value>\r\n"
				+ "				</globalDefs_NVSList_Telem>\r\n"
				+ "				<globalDefs_NVSList_Telem>\r\n"
				+ "					<name>NEGROUPID</name>\r\n"
				+ "					<value>100</value>\r\n"
				+ "				</globalDefs_NVSList_Telem>\r\n"
				+ "				<globalDefs_NVSList_Telem>\r\n"
				+ "					<name>NEID</name>\r\n"
				+ "					<value>726</value>\r\n"
				+ "				</globalDefs_NVSList_Telem>\r\n"
				+ "			</additionalInfo>\r\n"
				+ "		</ne>\r\n"
				+ "		<emsTime>1716960610178</emsTime>\r\n"
				+ "	</Notification_Handling_neChangerqst>\r\n"
				+ "</namessage>";
		
		
		
		JSONObject jo = XML.toJSONObject(s);
		
		if(jo.getJSONObject("namessage").has("Notification_Handling_neChangerqst")) {
			
			if(jo.getJSONObject("namessage").getJSONObject("Notification_Handling_neChangerqst").has("ne")) {
				
				if(jo.getJSONObject("namessage").getJSONObject("Notification_Handling_neChangerqst").getJSONObject("ne").has("additionalInfo")) {
					System.out.println("has");
				}
				
				
			}
			
			
		}
		
		ObjectMapper objMapper = new ObjectMapper();
		try {
			JsonNode jsonNode = objMapper.readValue(jo.toString(), JsonNode.class);
			
			
			
			if(jsonNode.findValue("additionalInfo") != null) {
				System.out.println("it has");
				System.out.println(jsonNode.findValue("additionalInfo"));
				
				JsonNode jj = jsonNode.findValue("additionalInfo");
				
				System.out.println();
				
				if(jj.has("globalDefs_NVSList_Telem")) {
					System.out.println("hhhhh");
					JsonNode jjj = jj.findValue("globalDefs_NVSList_Telem");
					
					if(jjj.isArray()) {
						System.out.println(jjj.size());
						for(int i=0 ;i<jjj.size();i++) {
							JsonNode x = jjj.get(i);
							System.out.println();
							if(x.has("name")) {
								System.out.println();
								if(x.findValue("name").asText().equals("OpenAgentEnabled")) {
									if(x.has("value")) {
										System.out.println(x);
										System.out.println(x.findValue("value"));
									}
								}
							}
						}
					} else {
						
						String name = jjj.findValue("name").asText();
						System.out.println(name);
						
						String value = jjj.findValue("value").asText();
						System.out.println(value);
						
					}
					
					
					
				}
				
			}
			else
				System.out.println("it does not");
			
			
			
			System.out.println(Boolean.parseBoolean("true"));
			
		
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}

 class Port {
	String aid;
	String index;
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public Port(String aid, String index) {
		
		this.aid = aid;
		this.index = index;
	}
	@Override
	public String toString() {
		return "Port [aid=" + aid + ", index=" + index + "]";
	}
	
}
