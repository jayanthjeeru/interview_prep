package com.jsonToPojoMapping;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonToPojoExample {
    public static void main(String[] args) {
    	
    	
    	
//    	{
//    	    "push_data": {
//    	        "instanceData": [
//    	            {
//    	                "record": [
//    	                    {
//    	                        "sop_record": {
//    	                            "s1": 1,
//    	                            "s2": 2,
//    	                            "s3": 3,
//    	                            "lof_oof_state": 0,
//    	                            "relative_time_stamp": 1
//    	                        }
//    	                    },
//    	                    {
//    	                        "sop_record": {
//    	                            "s1": 2,
//    	                            "s2": 3,
//    	                            "s3": 4,
//    	                            "lof_oof_state": 0,
//    	                            "relative_time_stamp": 6
//    	                        }
//    	                    },
//    	                    {
//    	                        "sop_record": {
//    	                            "s1": 3,
//    	                            "s2": 4,
//    	                            "s3": 5,
//    	                            "lof_oof_state": 0,
//    	                            "relative_time_stamp": 11
//    	                        }
//    	                    },
//    	                    {
//    	                        "sop_record": {
//    	                            "s1": 4,
//    	                            "s2": 5,
//    	                            "s3": 6,
//    	                            "lof_oof_state": 0,
//    	                            "relative_time_stamp": 16
//    	                        }
//    	                    },
    //
    //
//    	                    {
//    	                        "sop_record": {
//    	                            "s1": 200,
//    	                            "s2": 201,
//    	                            "s3": 202,
//    	                            "lof_oof_state": 0,
//    	                            "relative_time_stamp": 59996
//    	                        }
//    	                    }
//    	                ],
//    	                "instance": {
//    	                    "path": {
//    	                        "element": [],
//    	                        "elem": [
//    	                            {
//    	                                "key": {},
//    	                                "name": "components"
//    	                            },
//    	                            {
//    	                                "key": {
//    	                                    "name": "OCH-1-1-L1"
//    	                                },
//    	                                "name": "component"
//    	                            }
//    	                        ],
//    	                        "origin": "",
//    	                        "target": ""
//    	                    },
//    	                    "type": "STATE_OF_POLARIZATION"
//    	                },
//    	                "absolute_time_stamp": "1726054172000000000"
//    	            }
//    	        ]
//    	    }
//    	}

    	
//    	this json to pojo code is for the above json
    	
        // JSON string to be deserialized
        String jsonString = "{\n" +
            "    \"push_data\": {\n" +
            "        \"instanceData\": [\n" +
            "            {\n" +
            "                \"record\": [\n" +
            "                    {\n" +
            "                        \"sop_record\": {\n" +
            "                            \"s1\": 1,\n" +
            "                            \"s2\": 2,\n" +
            "                            \"s3\": 3,\n" +
            "                            \"lof_oof_state\": 0,\n" +
            "                            \"relative_time_stamp\": 1\n" +
            "                        }\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"sop_record\": {\n" +
            "                            \"s1\": 2,\n" +
            "                            \"s2\": 3,\n" +
            "                            \"s3\": 4,\n" +
            "                            \"lof_oof_state\": 0,\n" +
            "                            \"relative_time_stamp\": 6\n" +
            "                        }\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"sop_record\": {\n" +
            "                            \"s1\": 3,\n" +
            "                            \"s2\": 4,\n" +
            "                            \"s3\": 5,\n" +
            "                            \"lof_oof_state\": 0,\n" +
            "                            \"relative_time_stamp\": 11\n" +
            "                        }\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"sop_record\": {\n" +
            "                            \"s1\": 4,\n" +
            "                            \"s2\": 5,\n" +
            "                            \"s3\": 6,\n" +
            "                            \"lof_oof_state\": 0,\n" +
            "                            \"relative_time_stamp\": 16\n" +
            "                        }\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"sop_record\": {\n" +
            "                            \"s1\": 200,\n" +
            "                            \"s2\": 201,\n" +
            "                            \"s3\": 202,\n" +
            "                            \"lof_oof_state\": 0,\n" +
            "                            \"relative_time_stamp\": 59996\n" +
            "                        }\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"instance\": {\n" +
            "                    \"path\": {\n" +
            "                        \"element\": [],\n" +
            "                        \"elem\": [\n" +
            "                            {\n" +
            "                                \"key\": {},\n" +
            "                                \"name\": \"components\"\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"key\": {\n" +
            "                                    \"name\": \"OCH-1-1-L1\"\n" +
            "                                },\n" +
            "                                \"name\": \"component\"\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"origin\": \"\",\n" +
            "                        \"target\": \"\"\n" +
            "                    },\n" +
            "                    \"type\": \"STATE_OF_POLARIZATION\"\n" +
            "                },\n" +
            "                \"absolute_time_stamp\": \"1726054172000000000\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}";

        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Deserialize JSON string to Root POJO
            Root root = objectMapper.readValue(jsonString, Root.class);

            // Extract data
            PushData pushData = root.getPush_data();
            InstanceData instanceData = pushData.getInstanceData()[0];
            Instance instance = instanceData.getInstance();
            Path path = instance.getPath();
            SopRecord[] records = instanceData.getRecord();

            // Print port name
            if (path.getElem().length > 0) {
                String portName = path.getElem()[1].getKey().getName();
                System.out.println("Port Name: " + portName);
            }

            // Print absolute time stamp
            System.out.println("Absolute Time Stamp: " + instanceData.getAbsolute_time_stamp());

            // Print s1, s2, s3 values from each record
            for (SopRecord record : records) {
                SopRecordDetails details = record.getSop_record();
                System.out.println("s1: " + details.getS1() + ", s2: " + details.getS2() + ", s3: " + details.getS3() + " relative_time_stamp : "+details.getRelative_time_stamp());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

