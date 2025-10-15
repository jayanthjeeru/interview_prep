package com.commonadapterfw;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;


public class Base64Test {

	public static void main(String[] args) throws IOException {

        String json = "{\"update\":{\"timestamp\":\"1664545400000000000\",\"prefix\":{\"elem\":[{\"name\":\"components\"},{\"name\":\"component\",\"key\":{\"name\":\"TRANSCEIVER-1-1-C1\"}},{\"name\":\"transceiver\"},{\"name\":\"state\"},{\"name\":\"output-power\"}]},\"update\":[{\"path\":{\"elem\":[{\"name\":\"instant\"}]},\"val\":{\"jsonIetfVal\":\"Ii00MC4wIg==\"}},{\"path\":{\"elem\":[{\"name\":\"avg\"}]},\"val\":{\"jsonIetfVal\":\"Ii00MC4wIg==\"}},{\"path\":{\"elem\":[{\"name\":\"min\"}]},\"val\":{\"jsonIetfVal\":\"Ii00MC4wIg==\"}},{\"path\":{\"elem\":[{\"name\":\"max\"}]},\"val\":{\"jsonIetfVal\":\"Ii00MC4wIg==\"}},{\"path\":{\"elem\":[{\"name\":\"min-time\"}]},\"val\":{\"jsonIetfVal\":\"IjE2NjQ1NDUzOTEwMDAwMDAwMDAi\"}},{\"path\":{\"elem\":[{\"name\":\"max-time\"}]},\"val\":{\"jsonIetfVal\":\"IjE2NjQ1NDUzOTEwMDAwMDAwMDAi\"}}]}}";


        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);


        decodeBase64(rootNode);


        String updatedJson = objectMapper.writeValueAsString(rootNode);
        updatedJson = updatedJson.replace("\\\"", "");
        System.out.println(updatedJson);
        
        JSONObject jo = new JSONObject(updatedJson);
        
        String timeStamp = jo.getJSONObject("update").getString("timestamp");
        System.out.println("timeStamp  =->> "+timeStamp);
        
        
        String portLabel = "";
        for(Object i : jo.getJSONObject("update").getJSONObject("prefix").getJSONArray("elem")) {
        	JSONObject j = (JSONObject) i;
        	if(j.has("key"))
        		portLabel = j.getJSONObject("key").getString("name");
        }
        System.out.println("Port-Label =->> "+portLabel);
        
        
        JSONObject counterName = (JSONObject) jo.getJSONObject("update").getJSONObject("prefix").getJSONArray("elem").get(jo.getJSONObject("update").getJSONObject("prefix").getJSONArray("elem").length()-1);
        System.out.println("Counter-Name =->>  "+counterName.getString("name"));
       
        
        Map<String,String> counterAttributes = new HashMap<>();
        
        for(Object i : jo.getJSONObject("update").getJSONArray("update")) {
        	JSONObject j = (JSONObject) i;
        	JSONObject attribute = (JSONObject) j.getJSONObject("path").getJSONArray("elem").get(0);
        	j.put("enum", EnumTest.FRIDAY);
        	System.out.println(j.get("enum").getClass());
//        	System.out.println(attribute.getString("name"));
//        	System.out.println(j.getJSONObject("val").getString("jsonIetfVal"));
        	counterAttributes.put(attribute.getString("name"), j.getJSONObject("val").getString("jsonIetfVal"));
        }
        System.out.println("Counter-Attributes  =->> "+counterAttributes);
        
        
        System.out.println();
        
        EnumTest x = EnumTest.FRIDAY;
       
        String name = "FRIDAY";
        
        System.out.println(EnumTest.valueOf(name));
        
        
        JSONArray ja = new JSONArray("[\r\n"
        		+ "				{\r\n"
        		+ "					\"name\": \"components\",\r\n"
        		+ "					\"filter\": \"\"\r\n"
        		+ "				},\r\n"
        		+ "				{\r\n"
        		+ "					\"name\": \"component\",\r\n"
        		+ "					\"filter\": \"name=*\"\r\n"
        		+ "				},\r\n"
        		+ "				{\r\n"
        		+ "					\"name\": \"transceiver\",\r\n"
        		+ "					\"filter\": \"\"\r\n"
        		+ "				}\r\n"
        		+ "			]");
     System.out.println(ja.toString());
        System.out.println(ja.get(0));
        System.out.println("1111111111111111111111111111111111111".matches("[0-9]+"));
    }

    private static void decodeBase64(JsonNode node) {
        if (node.isObject()) {
            ObjectNode objectNode = (ObjectNode) node;
            objectNode.fields().forEachRemaining(entry -> {
//	            	System.out.println(entry.getKey().contains("jsonIetfVal"));
	                JsonNode valueNode = entry.getValue();
	                if (valueNode.isTextual()) {
	                    String base64Value = valueNode.asText();
//	                    System.out.println(entry.getKey());
	                    String decodedValue = base64Value;
	                    if(entry.getKey().contains("jsonIetfVal"))
	                    	 decodedValue = decodeBase64String(base64Value);
	                    objectNode.put(entry.getKey(), decodedValue);
	                } else {
	                    decodeBase64(valueNode);
	                }
            });
        } else if (node.isArray()) {
            ArrayNode arrayNode = (ArrayNode) node;
            for (JsonNode element : arrayNode) {
                decodeBase64(element);
            }
        }
    }

    private static String decodeBase64String(String base64Value) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(base64Value);
            return new String(decodedBytes, "UTF-8");
        } catch (IllegalArgumentException | java.io.UnsupportedEncodingException e) {
            // Ignore invalid Base64-encoded values
            return base64Value;
        }
    }
}
