package com.nokia.handson;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToPojoConverter {
    public static void main(String[] args) {
        String json = "{\"data\":{\"ietf-restconf:notification\":{\"eventTime\":\"2024-11-08T12:12:42Z\",\"nsp-fault:alarm-create\":{\"originalSeverity\":\"major\",\"neId\":\"133.33.333.333\",\"lastTimeAcknowledged\":null,\"acknowledged\":false,\"userText\":\"N/A\",\"sourceSystem\":\"fdn:realm:optics\",\"additionalText\":\"LOSS OF FRAME OSC:PORT-1-2-OSC:PORT-1-2-OSC:OTS:NULL\",\"affectedObject\":\"network:133.33.333.333:shelf-1:slot-2:card:port-OSC\",\"lastTimeDeEscalated\":null,\"acknowledgedBy\":\"N/A\",\"lastTimeCleared\":null,\"neName\":\"133.33.333.333\",\"frequency\":0,\"lastTimeEscalated\":null,\"probableCause\":\"LOSS OF FRAME OSC\",\"firstTimeDetected\":1545291134000,\"adminState\":\"unlocked\",\"rootCause\":false,\"numberOfOccurrencesSinceAck\":0,\"nodeTimeOffset\":1729522670692000,\"objectId\":\"fdn:model:fm:Alarm:1313\",\"severity\":\"major\",\"affectedObjectName\":\"133.33.333.333/PORT-1-2-OSC,OS,RCV\",\"clearedBy\":\"N/A\",\"serviceAffecting\":false,\"numberOfOccurrences\":1,\"impact\":0,\"implicitlyCleared\":true,\"alarmName\":\"LOSS OF FRAME OSC\",\"wasAcknowledged\":false,\"numberOfOccurrencesSinceClear\":0,\"objectFullName\":\"network:133.33.333.333:shelf-1:slot-2:PORT:port-OSC:OS:LOF-OSC:alarmId:342\",\"previousSeverity\":\"indeterminate\",\"highestSeverity\":\"major\",\"affectedObjectType\":\"TP\",\"alarmType\":\"EQUIPMENT\",\"specificProblem\":\"LOSS OF FRAME OSC\",\"sourceType\":\"nfmt\",\"lastTimeSeverityChanged\":null,\"lastTimeDetected\":1545291134000}}}}";

        try {
            // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Convert JSON to POJO
            NotificationWrapper notificationWrapper = objectMapper.readValue(json, NotificationWrapper.class);

            // Output POJO data (for example purposes)
            System.out.println("Event Time: " + notificationWrapper.getData().getNotification().getEventTime());

            
          
            
            if (notificationWrapper.getData().getNotification().getNspFaultAlarmCreate() != null) {
            	System.out.println("create flow");
                System.out.println("Alarm Name: " + notificationWrapper.getData().getNotification().getNspFaultAlarmCreate().getAlarmName());
            } else if(notificationWrapper.getData().getNotification().getNspFaultAlarmDelete() != null) {
            	System.out.println("delete flow");
            } else if(notificationWrapper.getData().getNotification().getNspFaultAlarmChange() != null) {
            	System.out.println("change flow");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
