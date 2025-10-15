package com.sop.req;

import java.util.List;

public class MeasurementDetails {
    private List<String> measurementSchema;
    private List<MeasurementData> measurementData;

    // Getters and setters
    public List<String> getMeasurementSchema() {
        return measurementSchema;
    }

    public void setMeasurementSchema(List<String> measurementSchema) {
        this.measurementSchema = measurementSchema;
    }

    public List<MeasurementData> getMeasurementData() {
        return measurementData;
    }

    public void setMeasurementData(List<MeasurementData> measurementData) {
        this.measurementData = measurementData;
    }
}
