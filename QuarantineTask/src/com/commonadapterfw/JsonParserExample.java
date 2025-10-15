package com.commonadapterfw;

import com.google.gson.JsonParser;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonParserExample {

    public static void main(String[] args) {
        String json = "{\n" +
                "  \"NotifList\": [\n" +
                "    {\n" +
                "      \"neid\": \"113\",\n" +
                "      \"payload\": {\n" +
                "        \"notification\": [\n" +
                "          {\n" +
                "            \"timestamp\": 1725372789931,\n" +
                "            \"update\": [\n" +
                "              {\n" +
                "                \"path\": {\n" +
                "                  \"elem\": [\n" +
                "                    {\n" +
                "                      \"name\": \"/components/component/PORT-1-1-6\"\n" +
                "                    }\n" +
                "                  ]\n" +
                "                },\n" +
                "                \"val\": {\n" +
                "                  \"flight-recorder-instance-data\": {\n" +
                "                    \"instance\": {\n" +
                "                      \"path\": {\n" +
                "                        \"elem\": [\n" +
                "                          {\n" +
                "                            \"name\": \"/components/component/PORT-1-1-6\"\n" +
                "                          }\n" +
                "                        ]\n" +
                "                      },\n" +
                "                      \"type\": \"STATE_OF_POLARIZATION\"\n" +
                "                    },\n" +
                "                    \"record\": [\n" +
                "                      {\n" +
                "                        \"sop-record\": {\n" +
                "                          \"s1\": 0.69,\n" +
                "                          \"s2\": 0.6,\n" +
                "                          \"s3\": 0.04,\n" +
                "                          \"lof-oof-state\": 1,\n" +
                "                          \"relative-time-stamp\": 5000\n" +
                "                        }\n" +
                "                      }\n" +
                "                    ],\n" +
                "                    \"absolute-time-stamp\": 1725372789931\n" +
                "                  }\n" +
                "                }\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"neid\": \"113\",\n" +
                "      \"payload\": {\n" +
                "        \"notification\": [\n" +
                "          {\n" +
                "            \"timestamp\": 1725372789931,\n" +
                "            \"update\": [\n" +
                "              {\n" +
                "                \"path\": {\n" +
                "                  \"elem\": [\n" +
                "                    {\n" +
                "                      \"name\": \"/components/component/PORT-1-1-6\"\n" +
                "                    }\n" +
                "                  ]\n" +
                "                },\n" +
                "                \"val\": {\n" +
                "                  \"flight-recorder-instance-data\": {\n" +
                "                    \"instance\": {\n" +
                "                      \"path\": {\n" +
                "                        \"elem\": [\n" +
                "                          {\n" +
                "                            \"name\": \"/components/component/PORT-1-1-6\"\n" +
                "                          }\n" +
                "                        ]\n" +
                "                      },\n" +
                "                      \"type\": \"STATE_OF_POLARIZATION\"\n" +
                "                    },\n" +
                "                    \"record\": [\n" +
                "                      {\n" +
                "                        \"sop-record\": {\n" +
                "                          \"s1\": 0.69,\n" +
                "                          \"s2\": 0.6,\n" +
                "                          \"s3\": 0.04,\n" +
                "                          \"lof-oof-state\": 1,\n" +
                "                          \"relative-time-stamp\": 5000\n" +
                "                        }\n" +
                "                      }\n" +
                "                    ],\n" +
                "                    \"absolute-time-stamp\": 1725372789931\n" +
                "                  }\n" +
                "                }\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        // Create a Gson instance
        Gson gson = new Gson();

        // Parse the JSON
        JsonElement root = JsonParser.parseString(json);
        JsonObject rootObject = root.getAsJsonObject();
        JsonArray notifList = rootObject.getAsJsonArray("NotifList");

       
        for (JsonElement notifElement : notifList) {
            JsonObject notifObject = notifElement.getAsJsonObject();
            JsonObject payload = notifObject.getAsJsonObject("payload");
            JsonArray notifications = payload.getAsJsonArray("notification");

            JsonElement notificationElement = notifications.get(0); 
                JsonObject notificationObject = notificationElement.getAsJsonObject();
                long timestamp = notificationObject.get("timestamp").getAsLong();
                JsonArray updates = notificationObject.getAsJsonArray("update");

                JsonElement updateElement = updates.get(0); 
                    JsonObject updateObject = updateElement.getAsJsonObject();
                    JsonObject path = updateObject.getAsJsonObject("path");
                    JsonObject elem = path.getAsJsonArray("elem").get(0).getAsJsonObject();
                    String name = elem.get("name").getAsString();

                    JsonObject val = updateObject.getAsJsonObject("val");
                    JsonObject flightRecorderInstanceData = val.getAsJsonObject("flight-recorder-instance-data");
                    JsonArray record = flightRecorderInstanceData.getAsJsonArray("record");
                    JsonObject sopRecord = record.get(0).getAsJsonObject().getAsJsonObject("sop-record");

                    double s1 = sopRecord.get("s1").getAsDouble();
                    double s2 = sopRecord.get("s2").getAsDouble();
                    double s3 = sopRecord.get("s3").getAsDouble();

                    
                    System.out.printf("Name: %s, Timestamp: %d, s1: %.2f, s2: %.2f, s3: %.2f%n",
                            name, timestamp, s1, s2, s3);
                
            
        }
    }
}
