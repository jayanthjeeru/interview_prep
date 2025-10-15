package com.commonadapterfw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperTest {
	public static List<NotificationData> mapJsonToPojo(String json) throws IOException {
        List<NotificationData> dataList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
 
        // Parse the JSON tree
        JsonNode rootNode = mapper.readTree(json);
        String neid = rootNode.path("neid").asText();
 
        // Extract relevant fields
        JsonNode notifications = rootNode.path("payload").path("notification");
        
//        System.out.println(notifications.get(0));
        
        
        for (JsonNode notification : notifications) {
            long timestamp = notification.path("timestamp").asLong();
            JsonNode updates = notification.path("update");
 
            for (JsonNode update : updates) {
                String name = update.path("path").path("elem").get(0).path("name").asText();
                name = name.split("/")[3];
                JsonNode sopRecord = update.path("val").path("flight-recorder-instance-data")
                                            .path("record").get(0).path("sop-record");
                double s1 = sopRecord.path("s1").asDouble();
                double s2 = sopRecord.path("s2").asDouble();
                double s3 = sopRecord.path("s3").asDouble();
 
                // Create and add NotificationData object to the list
                NotificationData data = new NotificationData();
                data.setNeid(neid);
                data.setTimestamp(timestamp);
                data.setName(name);
                data.setS1(s1);
                data.setS2(s2);
                data.setS3(s3);
                dataList.add(data);
            }
        }
 
        return dataList;
    }
 
    public static void main(String[] args) {
        String json = "{\"neid\":\"101\",\"payload\":{\"notification\":[{\"timestamp\":1724652285393,\"update\":[{\"path\":{\"elem\":[{\"name\":\"/components/component/PORT-1-1-1\"}]},\"val\":{\"flight-recorder-instance-data\":{\"instance\":{\"path\":{\"elem\":[{\"name\":\"/components/component/PORT-1-1-1\"}]},\"type\":\"STATE_OF_POLARIZATION\"},\"record\":[{\"sop-record\":{\"s1\":0.38,\"s2\":0.37,\"s3\":0.88,\"lof-oof-state\":1,\"relative-time-stamp\":5000}}],\"absolute-time-stamp\":1724652285393}}}]}]}}"; // Replace with your JSON string
        try {
        	
        	
            List<NotificationData> data = mapJsonToPojo(json);
            data.forEach(x -> {
            	System.out.println(x.toString()+"\n");
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
