package com.sop.req;

import java.util.List;

public class MeasurementData {
    private String objectId;
    private String measurementBaseTime;
    private List<List<String>> measurements;

    // Getters and setters
    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getMeasurementBaseTime() {
        return measurementBaseTime;
    }

    public void setMeasurementBaseTime(String measurementBaseTime) {
        this.measurementBaseTime = measurementBaseTime;
    }

    public List<List<String>> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<List<String>> measurements) {
        this.measurements = measurements;
    }
}

