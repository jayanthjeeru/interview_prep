package com.commonadapterfw;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationData {
    private String neid;
    private long timestamp;
    private String name;
    private double s1;
    private double s2;
    private double s3;
 
    // Getters and Setters
    public String getNeid() {
        return neid;
    }
 
    public void setNeid(String neid) {
        this.neid = neid;
    }
 
    public long getTimestamp() {
        return timestamp;
    }
 
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
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
 
    @Override
    public String toString() {
        return "{" +
                "\"neid\"=\"" + neid + "\"" +
                ", \"timestamp\"=" + "\""+timestamp +"\""+
                ", \"name\"=" + "\""+name + "\"" +
                ", \"s1\"=" +"\""+ s1 +"\""+
                ", \"s2\"=" + "\""+s2 +"\""+
                ", \"s3\"=" + "\""+s3+"\"" +
                '}';
    }
}