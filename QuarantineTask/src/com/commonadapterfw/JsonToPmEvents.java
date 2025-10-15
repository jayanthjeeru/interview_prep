package com.commonadapterfw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class JsonToPmEvents {

    public static void main(String[] args) throws Exception {
        String json = "{\n" +
                "    \"NotifList\": [\n" +
                "        {\n" +
                "            \"neid\": \"113\",\n" +
                "            \"payload\": {\n" +
                "                \"notification\": [\n" +
                "                    {\n" +
                "                        \"timestamp\": 1725372789931,\n" +
                "                        \"update\": [\n" +
                "                            {\n" +
                "                                \"path\": {\n" +
                "                                    \"elem\": [\n" +
                "                                        {\n" +
                "                                            \"name\": \"/components/component/PORT-1-1-6\"\n" +
                "                                        }\n" +
                "                                    ]\n" +
                "                                },\n" +
                "                                \"val\": {\n" +
                "                                    \"flight-recorder-instance-data\": {\n" +
                "                                        \"instance\": {\n" +
                "                                            \"path\": {\n" +
                "                                                \"elem\": [\n" +
                "                                                    {\n" +
                "                                                        \"name\": \"/components/component/PORT-1-1-6\"\n" +
                "                                                    }\n" +
                "                                                ]\n" +
                "                                            },\n" +
                "                                            \"type\": \"STATE_OF_POLARIZATION\"\n" +
                "                                        },\n" +
                "                                        \"record\": [\n" +
                "                                            {\n" +
                "                                                \"sop-record\": {\n" +
                "                                                    \"s1\": 0.69,\n" +
                "                                                    \"s2\": 0.6,\n" +
                "                                                    \"s3\": 0.04,\n" +
                "                                                    \"lof-oof-state\": 1,\n" +
                "                                                    \"relative-time-stamp\": 5000\n" +
                "                                                }\n" +
                "                                            }\n" +
                "                                        ],\n" +
                "                                        \"absolute-time-stamp\": 1725372789931\n" +
                "                                    }\n" +
                "                                }\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"neid\": \"113\",\n" +
                "            \"payload\": {\n" +
                "                \"notification\": [\n" +
                "                    {\n" +
                "                        \"timestamp\": 1725372789931,\n" +
                "                        \"update\": [\n" +
                "                            {\n" +
                "                                \"path\": {\n" +
                "                                    \"elem\": [\n" +
                "                                        {\n" +
                "                                            \"name\": \"/components/component/PORT-1-1-6\"\n" +
                "                                        }\n" +
                "                                    ]\n" +
                "                                },\n" +
                "                                \"val\": {\n" +
                "                                    \"flight-recorder-instance-data\": {\n" +
                "                                        \"instance\": {\n" +
                "                                            \"path\": {\n" +
                "                                                \"elem\": [\n" +
                "                                                    {\n" +
                "                                                        \"name\": \"/components/component/PORT-1-1-6\"\n" +
                "                                                    }\n" +
                "                                                ]\n" +
                "                                            },\n" +
                "                                            \"type\": \"STATE_OF_POLARIZATION\"\n" +
                "                                        },\n" +
                "                                        \"record\": [\n" +
                "                                            {\n" +
                "                                                \"sop-record\": {\n" +
                "                                                    \"s1\": 0.69,\n" +
                "                                                    \"s2\": 0.6,\n" +
                "                                                    \"s3\": 0.04,\n" +
                "                                                    \"lof-oof-state\": 1,\n" +
                "                                                    \"relative-time-stamp\": 5000\n" +
                "                                                }\n" +
                "                                            }\n" +
                "                                        ],\n" +
                "                                        \"absolute-time-stamp\": 1725372789931\n" +
                "                                    }\n" +
                "                                }\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);

       
        JsonNode notifListNode = rootNode.path("NotifList");
        for (JsonNode notifNode : notifListNode) {
            String neid = notifNode.path("neid").asText();
            JsonNode notificationNode = notifNode.path("payload").path("notification").get(0);
            long timestamp = notificationNode.path("timestamp").asLong();
            JsonNode updateNode = notificationNode.path("update").get(0);
            String name = updateNode.path("path").path("elem").get(0).path("name").asText();
            JsonNode recordNode = updateNode.path("val").path("flight-recorder-instance-data").path("record").get(0).path("sop-record");
            String b = "neid "+neid+" timestamp "+timestamp+" name "+ name+ " s1 "+recordNode.path("s1").asDouble()+" s2 "+recordNode.path("s2").asDouble()+" s3 "+ recordNode.path("s3").asDouble();
            System.out.println(b);
         
        }

    }
}
