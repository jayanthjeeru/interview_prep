package com.commonadapterfw;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToPojoExample {
	
	
//	{
//	    "push_data": {
//	        "instanceData": [
//	            {
//	                "record": [
//	                    {
//	                        "sop_record": {
//	                            "s1": 1,
//	                            "s2": 2,
//	                            "s3": 3,
//	                            "lof_oof_state": 0,
//	                            "relative_time_stamp": 1
//	                        }
//	                    },
//	                    {
//	                        "sop_record": {
//	                            "s1": 2,
//	                            "s2": 3,
//	                            "s3": 4,
//	                            "lof_oof_state": 0,
//	                            "relative_time_stamp": 6
//	                        }
//	                    },
//	                    {
//	                        "sop_record": {
//	                            "s1": 3,
//	                            "s2": 4,
//	                            "s3": 5,
//	                            "lof_oof_state": 0,
//	                            "relative_time_stamp": 11
//	                        }
//	                    },
//	                    {
//	                        "sop_record": {
//	                            "s1": 4,
//	                            "s2": 5,
//	                            "s3": 6,
//	                            "lof_oof_state": 0,
//	                            "relative_time_stamp": 16
//	                        }
//	                    },
//
//
//	                    {
//	                        "sop_record": {
//	                            "s1": 200,
//	                            "s2": 201,
//	                            "s3": 202,
//	                            "lof_oof_state": 0,
//	                            "relative_time_stamp": 59996
//	                        }
//	                    }
//	                ],
//	                "instance": {
//	                    "path": {
//	                        "element": [],
//	                        "elem": [
//	                            {
//	                                "key": {},
//	                                "name": "components"
//	                            },
//	                            {
//	                                "key": {
//	                                    "name": "OCH-1-1-L1"
//	                                },
//	                                "name": "component"
//	                            }
//	                        ],
//	                        "origin": "",
//	                        "target": ""
//	                    },
//	                    "type": "STATE_OF_POLARIZATION"
//	                },
//	                "absolute_time_stamp": "1726054172000000000"
//	            }
//	        ]
//	    }
//	}

	
//	this json to pojo code is for the above json

    public static class Root {
        @JsonProperty("push_data")
        private PushData pushData;

        public PushData getPushData() {
            return pushData;
        }

        public void setPushData(PushData pushData) {
            this.pushData = pushData;
        }
    }

    public static class PushData {
        @JsonProperty("instanceData")
        private InstanceData[] instanceData;

        public InstanceData[] getInstanceData() {
            return instanceData;
        }

        public void setInstanceData(InstanceData[] instanceData) {
            this.instanceData = instanceData;
        }
    }

    public static class InstanceData {
        @JsonProperty("record")
        private SopRecord[] record;

        @JsonProperty("instance")
        private Instance instance;

        @JsonProperty("absolute_time_stamp")
        private String absoluteTimeStamp;

        public SopRecord[] getRecord() {
            return record;
        }

        public void setRecord(SopRecord[] record) {
            this.record = record;
        }

        public Instance getInstance() {
            return instance;
        }

        public void setInstance(Instance instance) {
            this.instance = instance;
        }

        public String getAbsoluteTimeStamp() {
            return absoluteTimeStamp;
        }

        public void setAbsoluteTimeStamp(String absoluteTimeStamp) {
            this.absoluteTimeStamp = absoluteTimeStamp;
        }
    }

    public static class Instance {
        @JsonProperty("path")
        private Path path;

        @JsonProperty("type")
        private String type;

        public Path getPath() {
            return path;
        }

        public void setPath(Path path) {
            this.path = path;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class Path {
        @JsonProperty("element")
        private Object[] element;

        @JsonProperty("elem")
        private Element[] elem;

        @JsonProperty("origin")
        private String origin;

        @JsonProperty("target")
        private String target;

        public Object[] getElement() {
            return element;
        }

        public void setElement(Object[] element) {
            this.element = element;
        }

        public Element[] getElem() {
            return elem;
        }

        public void setElem(Element[] elem) {
            this.elem = elem;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }
    }

    public static class Element {
        @JsonProperty("key")
        private Key key;

        @JsonProperty("name")
        private String name;

        public Key getKey() {
            return key;
        }

        public void setKey(Key key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Key {
        @JsonProperty("name")
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class SopRecord {
        @JsonProperty("sop_record")
        private SopRecordDetails sopRecord;

        public SopRecordDetails getSopRecord() {
            return sopRecord;
        }

        public void setSopRecord(SopRecordDetails sopRecord) {
            this.sopRecord = sopRecord;
        }
    }

    public static class SopRecordDetails {
        @JsonProperty("s1")
        private int s1;

        @JsonProperty("s2")
        private int s2;

        @JsonProperty("s3")
        private int s3;

        @JsonProperty("lof_oof_state")
        private int lofOofState;

        @JsonProperty("relative_time_stamp")
        private int relativeTimeStamp;

        public int getS1() {
            return s1;
        }

        public void setS1(int s1) {
            this.s1 = s1;
        }

        public int getS2() {
            return s2;
        }

        public void setS2(int s2) {
            this.s2 = s2;
        }

        public int getS3() {
            return s3;
        }

        public void setS3(int s3) {
            this.s3 = s3;
        }

        public int getLofOofState() {
            return lofOofState;
        }

        public void setLofOofState(int lofOofState) {
            this.lofOofState = lofOofState;
        }

        public int getRelativeTimeStamp() {
            return relativeTimeStamp;
        }

        public void setRelativeTimeStamp(int relativeTimeStamp) {
            this.relativeTimeStamp = relativeTimeStamp;
        }
    }

    public static void main(String[] args) {
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
            PushData pushData = root.getPushData();
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
            System.out.println("Absolute Time Stamp: " + instanceData.getAbsoluteTimeStamp());

            // Print s1, s2, s3 values from each record
            for (SopRecord record : records) {
                SopRecordDetails details = record.getSopRecord();
                System.out.println("s1: " + details.getS1() + ", s2: " + details.getS2() + ", s3: " + details.getS3());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

