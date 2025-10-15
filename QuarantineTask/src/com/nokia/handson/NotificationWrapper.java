package com.nokia.handson;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

// Root class
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

// Root class
public class NotificationWrapper {
    private Data data;

    // Getter and Setter
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    // Inner Data class
    public static class Data {
        @JsonProperty("ietf-restconf:notification")
        private Notification notification;

        // Getter and Setter
        public Notification getNotification() {
            return notification;
        }

        public void setNotification(Notification notification) {
            this.notification = notification;
        }
    }

    // Notification class which will hold the different notification types (create, delete, change)
    public static class Notification {
        private String eventTime;
        
        @JsonProperty("nsp-fault:alarm-create")
        private AlarmCreate nspFaultAlarmCreate;
        
        @JsonProperty("nsp-fault:alarm-delete")
        private AlarmDelete nspFaultAlarmDelete;
        
        @JsonProperty("nsp-fault:alarm-change")
        private AlarmChange nspFaultAlarmChange;

        // Getters and Setters
        public String getEventTime() {
            return eventTime;
        }

        public void setEventTime(String eventTime) {
            this.eventTime = eventTime;
        }

        public AlarmCreate getNspFaultAlarmCreate() {
            return nspFaultAlarmCreate;
        }

        public void setNspFaultAlarmCreate(AlarmCreate nspFaultAlarmCreate) {
            this.nspFaultAlarmCreate = nspFaultAlarmCreate;
        }

        public AlarmDelete getNspFaultAlarmDelete() {
            return nspFaultAlarmDelete;
        }

        public void setNspFaultAlarmDelete(AlarmDelete nspFaultAlarmDelete) {
            this.nspFaultAlarmDelete = nspFaultAlarmDelete;
        }

        public AlarmChange getNspFaultAlarmChange() {
            return nspFaultAlarmChange;
        }

        public void setNspFaultAlarmChange(AlarmChange nspFaultAlarmChange) {
            this.nspFaultAlarmChange = nspFaultAlarmChange;
        }
    }

//    // AlarmCreate class for the first notification type
//    import com.fasterxml.jackson.annotation.JsonProperty;
//    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//    @JsonIgnoreProperties(ignoreUnknown = true) // Ignores unknown fields if any
    public static class AlarmCreate {

        private String originalSeverity;
        private String neId;
        private Long lastTimeAcknowledged;
        private boolean acknowledged;
        private String userText;
        private String sourceSystem;
        private String additionalText;
        private String affectedObject;
        private Long lastTimeDeEscalated;
        private String acknowledgedBy;
        private Long lastTimeCleared;
        private String neName;
        private int frequency;
        private Long lastTimeEscalated;
        private String probableCause;
        private Long firstTimeDetected;
        private String adminState;
        private boolean rootCause;
        private int numberOfOccurrencesSinceAck;
        private Long nodeTimeOffset;
        private String objectId;
        private String severity;
        private String affectedObjectName;
        private String clearedBy;
        private boolean serviceAffecting;
        private int numberOfOccurrences;
        private int impact;
        private boolean implicitlyCleared;
        private String alarmName;
        private boolean wasAcknowledged;
        private int numberOfOccurrencesSinceClear;
        private String objectFullName;
        private String previousSeverity;
        private String highestSeverity;
        private String affectedObjectType;
        private String alarmType;
        private String specificProblem;
        private String sourceType;
        private Long lastTimeSeverityChanged;
        private Long lastTimeDetected;

        // Getters and Setters
        public String getOriginalSeverity() {
            return originalSeverity;
        }

        public void setOriginalSeverity(String originalSeverity) {
            this.originalSeverity = originalSeverity;
        }

        public String getNeId() {
            return neId;
        }

        public void setNeId(String neId) {
            this.neId = neId;
        }

        public Long getLastTimeAcknowledged() {
            return lastTimeAcknowledged;
        }

        public void setLastTimeAcknowledged(Long lastTimeAcknowledged) {
            this.lastTimeAcknowledged = lastTimeAcknowledged;
        }

        public boolean isAcknowledged() {
            return acknowledged;
        }

        public void setAcknowledged(boolean acknowledged) {
            this.acknowledged = acknowledged;
        }

        public String getUserText() {
            return userText;
        }

        public void setUserText(String userText) {
            this.userText = userText;
        }

        public String getSourceSystem() {
            return sourceSystem;
        }

        public void setSourceSystem(String sourceSystem) {
            this.sourceSystem = sourceSystem;
        }

        public String getAdditionalText() {
            return additionalText;
        }

        public void setAdditionalText(String additionalText) {
            this.additionalText = additionalText;
        }

        public String getAffectedObject() {
            return affectedObject;
        }

        public void setAffectedObject(String affectedObject) {
            this.affectedObject = affectedObject;
        }

        public Long getLastTimeDeEscalated() {
            return lastTimeDeEscalated;
        }

        public void setLastTimeDeEscalated(Long lastTimeDeEscalated) {
            this.lastTimeDeEscalated = lastTimeDeEscalated;
        }

        public String getAcknowledgedBy() {
            return acknowledgedBy;
        }

        public void setAcknowledgedBy(String acknowledgedBy) {
            this.acknowledgedBy = acknowledgedBy;
        }

        public Long getLastTimeCleared() {
            return lastTimeCleared;
        }

        public void setLastTimeCleared(Long lastTimeCleared) {
            this.lastTimeCleared = lastTimeCleared;
        }

        public String getNeName() {
            return neName;
        }

        public void setNeName(String neName) {
            this.neName = neName;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        public Long getLastTimeEscalated() {
            return lastTimeEscalated;
        }

        public void setLastTimeEscalated(Long lastTimeEscalated) {
            this.lastTimeEscalated = lastTimeEscalated;
        }

        public String getProbableCause() {
            return probableCause;
        }

        public void setProbableCause(String probableCause) {
            this.probableCause = probableCause;
        }

        public Long getFirstTimeDetected() {
            return firstTimeDetected;
        }

        public void setFirstTimeDetected(Long firstTimeDetected) {
            this.firstTimeDetected = firstTimeDetected;
        }

        public String getAdminState() {
            return adminState;
        }

        public void setAdminState(String adminState) {
            this.adminState = adminState;
        }

        public boolean isRootCause() {
            return rootCause;
        }

        public void setRootCause(boolean rootCause) {
            this.rootCause = rootCause;
        }

        public int getNumberOfOccurrencesSinceAck() {
            return numberOfOccurrencesSinceAck;
        }

        public void setNumberOfOccurrencesSinceAck(int numberOfOccurrencesSinceAck) {
            this.numberOfOccurrencesSinceAck = numberOfOccurrencesSinceAck;
        }

        public Long getNodeTimeOffset() {
            return nodeTimeOffset;
        }

        public void setNodeTimeOffset(Long nodeTimeOffset) {
            this.nodeTimeOffset = nodeTimeOffset;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public String getSeverity() {
            return severity;
        }

        public void setSeverity(String severity) {
            this.severity = severity;
        }

        public String getAffectedObjectName() {
            return affectedObjectName;
        }

        public void setAffectedObjectName(String affectedObjectName) {
            this.affectedObjectName = affectedObjectName;
        }

        public String getClearedBy() {
            return clearedBy;
        }

        public void setClearedBy(String clearedBy) {
            this.clearedBy = clearedBy;
        }

        public boolean isServiceAffecting() {
            return serviceAffecting;
        }

        public void setServiceAffecting(boolean serviceAffecting) {
            this.serviceAffecting = serviceAffecting;
        }

        public int getNumberOfOccurrences() {
            return numberOfOccurrences;
        }

        public void setNumberOfOccurrences(int numberOfOccurrences) {
            this.numberOfOccurrences = numberOfOccurrences;
        }

        public int getImpact() {
            return impact;
        }

        public void setImpact(int impact) {
            this.impact = impact;
        }

        public boolean isImplicitlyCleared() {
            return implicitlyCleared;
        }

        public void setImplicitlyCleared(boolean implicitlyCleared) {
            this.implicitlyCleared = implicitlyCleared;
        }

        public String getAlarmName() {
            return alarmName;
        }

        public void setAlarmName(String alarmName) {
            this.alarmName = alarmName;
        }

        public boolean isWasAcknowledged() {
            return wasAcknowledged;
        }

        public void setWasAcknowledged(boolean wasAcknowledged) {
            this.wasAcknowledged = wasAcknowledged;
        }

        public int getNumberOfOccurrencesSinceClear() {
            return numberOfOccurrencesSinceClear;
        }

        public void setNumberOfOccurrencesSinceClear(int numberOfOccurrencesSinceClear) {
            this.numberOfOccurrencesSinceClear = numberOfOccurrencesSinceClear;
        }

        public String getObjectFullName() {
            return objectFullName;
        }

        public void setObjectFullName(String objectFullName) {
            this.objectFullName = objectFullName;
        }

        public String getPreviousSeverity() {
            return previousSeverity;
        }

        public void setPreviousSeverity(String previousSeverity) {
            this.previousSeverity = previousSeverity;
        }

        public String getHighestSeverity() {
            return highestSeverity;
        }

        public void setHighestSeverity(String highestSeverity) {
            this.highestSeverity = highestSeverity;
        }

        public String getAffectedObjectType() {
            return affectedObjectType;
        }

        public void setAffectedObjectType(String affectedObjectType) {
            this.affectedObjectType = affectedObjectType;
        }

        public String getAlarmType() {
            return alarmType;
        }

        public void setAlarmType(String alarmType) {
            this.alarmType = alarmType;
        }

        public String getSpecificProblem() {
            return specificProblem;
        }

        public void setSpecificProblem(String specificProblem) {
            this.specificProblem = specificProblem;
        }

        public String getSourceType() {
            return sourceType;
        }

        public void setSourceType(String sourceType) {
            this.sourceType = sourceType;
        }

        public Long getLastTimeSeverityChanged() {
            return lastTimeSeverityChanged;
        }

        public void setLastTimeSeverityChanged(Long lastTimeSeverityChanged) {
            this.lastTimeSeverityChanged = lastTimeSeverityChanged;
        }

        public Long getLastTimeDetected() {
            return lastTimeDetected;
        }

        public void setLastTimeDetected(Long lastTimeDetected) {
            this.lastTimeDetected = lastTimeDetected;
        }
    }






    // AlarmDelete class for the second notification type
    public static class AlarmDelete {
        private String objectId;

        // Getter and Setter
        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }
    }

    // AlarmChange class for the third notification type
    public static class AlarmChange {
        private SeverityChange severity;
        private Map<String, Object> lastTimeSeverityChanged;
        private Map<String, Object> lastTimeCleared;
        private String objectId;

        // Getters and Setters
        public SeverityChange getSeverity() {
            return severity;
        }

        public void setSeverity(SeverityChange severity) {
            this.severity = severity;
        }

        public Map<String, Object> getLastTimeSeverityChanged() {
            return lastTimeSeverityChanged;
        }

        public void setLastTimeSeverityChanged(Map<String, Object> lastTimeSeverityChanged) {
            this.lastTimeSeverityChanged = lastTimeSeverityChanged;
        }

        public Map<String, Object> getLastTimeCleared() {
            return lastTimeCleared;
        }

        public void setLastTimeCleared(Map<String, Object> lastTimeCleared) {
            this.lastTimeCleared = lastTimeCleared;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }
    }

    // Helper class to represent the severity change
    public static class SeverityChange {
        private String oldValue;
        private String newValue;

        // Getters and Setters
        public String getOldValue() {
            return oldValue;
        }

        public void setOldValue(String oldValue) {
            this.oldValue = oldValue;
        }

        public String getNewValue() {
            return newValue;
        }

        public void setNewValue(String newValue) {
            this.newValue = newValue;
        }
    }
}
