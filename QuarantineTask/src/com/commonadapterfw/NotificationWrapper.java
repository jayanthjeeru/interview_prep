package com.commonadapterfw;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class NotificationWrapper {
    @JsonProperty("NotifList")
    private List<Notif> notifList;

    // Getters and Setters
    public List<Notif> getNotifList() {
        return notifList;
    }

    public void setNotifList(List<Notif> notifList) {
        this.notifList = notifList;
    }

    public static class Notif {
        private String neid;
        private Payload payload;

        // Getters and Setters
        public String getNeid() {
            return neid;
        }

        public void setNeid(String neid) {
            this.neid = neid;
        }

        public Payload getPayload() {
            return payload;
        }

        public void setPayload(Payload payload) {
            this.payload = payload;
        }
    }

    public static class Payload {
        private List<Notification> notification;

        // Getters and Setters
        public List<Notification> getNotification() {
            return notification;
        }

        public void setNotification(List<Notification> notification) {
            this.notification = notification;
        }
    }

    public static class Notification {
        private long timestamp;
        private List<Update> update;

        // Getters and Setters
        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public List<Update> getUpdate() {
            return update;
        }

        public void setUpdate(List<Update> update) {
            this.update = update;
        }
    }

    public static class Update {
        private Path path;
        private Val val;

        // Getters and Setters
        public Path getPath() {
            return path;
        }

        public void setPath(Path path) {
            this.path = path;
        }

        public Val getVal() {
            return val;
        }

        public void setVal(Val val) {
            this.val = val;
        }
    }

    public static class Path {
        private List<Elem> elem;

        // Getters and Setters
        public List<Elem> getElem() {
            return elem;
        }

        public void setElem(List<Elem> elem) {
            this.elem = elem;
        }
    }

    public static class Elem {
        private String name;

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Val {
        @JsonProperty("flight-recorder-instance-data")
        private FlightRecorderInstanceData flightRecorderInstanceData;

        // Getters and Setters
        public FlightRecorderInstanceData getFlightRecorderInstanceData() {
            return flightRecorderInstanceData;
        }

        public void setFlightRecorderInstanceData(FlightRecorderInstanceData flightRecorderInstanceData) {
            this.flightRecorderInstanceData = flightRecorderInstanceData;
        }
    }

    public static class FlightRecorderInstanceData {
        private Instance instance;
        private List<Record> record;
        
        @JsonProperty("absolute-time-stamp")
        private long absoluteTimeStamp;

        // Getters and Setters
        public Instance getInstance() {
            return instance;
        }

        public void setInstance(Instance instance) {
            this.instance = instance;
        }

        public List<Record> getRecord() {
            return record;
        }

        public void setRecord(List<Record> record) {
            this.record = record;
        }

        public long getAbsoluteTimeStamp() {
            return absoluteTimeStamp;
        }

        public void setAbsoluteTimeStamp(long absoluteTimeStamp) {
            this.absoluteTimeStamp = absoluteTimeStamp;
        }
    }

    public static class Instance {
        private Path path;
        private String type;

        // Getters and Setters
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

    public static class Record {
        @JsonProperty("sop-record")
        private SopRecord sopRecord;

        // Getters and Setters
        public SopRecord getSopRecord() {
            return sopRecord;
        }

        public void setSopRecord(SopRecord sopRecord) {
            this.sopRecord = sopRecord;
        }
    }

    public static class SopRecord {
        private double s1;
        private double s2;
        private double s3;
        
        @JsonProperty("lof-oof-state")
        private int lofOofState;
        
        @JsonProperty("relative-time-stamp")
        private long relativeTimeStamp;

        // Getters and Setters
        public double getS1() {
            return s1;
        }

        public void setS1(double s1) {
            this.s1 = s1;
        }

        public double getS2() {
            return s2;
        }

        public void setS2(double s2) {
            this.s2 = s2;
        }

        public double getS3() {
            return s3;
        }

        public void setS3(double s3) {
            this.s3 = s3;
        }

        public int getLofOofState() {
            return lofOofState;
        }

        public void setLofOofState(int lofOofState) {
            this.lofOofState = lofOofState;
        }

        public long getRelativeTimeStamp() {
            return relativeTimeStamp;
        }

        public void setRelativeTimeStamp(long relativeTimeStamp) {
            this.relativeTimeStamp = relativeTimeStamp;
        }
    }
}
