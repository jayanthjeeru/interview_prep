package com.sop.req;

import java.util.Map;

public class DataStream {
    private Map<String, MeasurementDetails> measurementsMap;
    private String[] measurements;

    // Getters and setters
    public Map<String, MeasurementDetails> getMeasurementsMap() {
        return measurementsMap;
    }

    public void setMeasurementsMap(Map<String, MeasurementDetails> measurementsMap) {
        this.measurementsMap = measurementsMap;
    }

    public String[] getMeasurements() {
        return measurements;
    }

    public void setMeasurements(String[] measurements) {
        this.measurements = measurements;
    }
}

