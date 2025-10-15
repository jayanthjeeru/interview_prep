package xmltojson;

import org.json.JSONObject;
import org.json.XML;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
public class XmltoJsonParser {

	public static void main(String[] args) {
		String msg = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<namessage><hdr><opReqId>1676898775111</opReqId><opRole>NOTIF</opRole><opName>Notification_Handling_neChange</opName><opReqTime>1676898775111</opReqTime><objectType>OT_MANAGED_ELEMENT</objectType><notificationType>NT_ATTRIBUTE_VALUE_CHANGE</notificationType></hdr><Notification_Handling_neChangerqst><attrIndicator><dsCommon_StringList_Telem>NEQuarantineState</dsCommon_StringList_Telem></attrIndicator><ne><ne><neName></neName></ne><newNeName></newNeName><userLabel></userLabel><owner></owner><nativeName></nativeName><location></location><version></version><nativeVersion></nativeVersion><productName></productName><nodeType></nodeType><managedState></managedState><communicationState>CS_NA</communicationState><emsInSyncState>false</emsInSyncState><supportedRates/><onnsCapability></onnsCapability><ipAddress>10.47.192.3</ipAddress><sigIPaddress></sigIPaddress><commParams/><timezone></timezone><daylight></daylight><time>0</time><additionalInfo><globalDefs_NVSList_Telem><name>errorReason</name><value>NE has been quarantined. High NE Traps.</value></globalDefs_NVSList_Telem><globalDefs_NVSList_Telem><name>StateChangeSource</name><value>System</value></globalDefs_NVSList_Telem><globalDefs_NVSList_Telem><name>NEQuarantineState</name><value>TRUE</value></globalDefs_NVSList_Telem></additionalInfo></ne><emsTime>1676898775111</emsTime></Notification_Handling_neChangerqst></namessage>";
		msg.equalsIgnoreCase(msg);
		JSONObject js = XML.toJSONObject(msg);
		ObjectMapper objMapper = new ObjectMapper();
		try {
			JsonNode jn = objMapper.readValue(js.toString(), JsonNode.class);
			jn.findValue("globalDefs_NVSList_Telem").forEach(x -> {

				if (x.findValue("name").asText().contentEquals("NEQuarantineState")) {
					if (x.findValue("value").asText().contentEquals("true"))
						System.out.println("add it"+jn.findValue("ipAddress").asText());
					else
						System.out.println("dont add");
				}
			});
			System.out.println(jn);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
