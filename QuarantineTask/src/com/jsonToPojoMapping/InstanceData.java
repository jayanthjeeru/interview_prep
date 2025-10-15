package com.jsonToPojoMapping;

public class InstanceData {
    private SopRecord[] record;
    private Instance instance;
    private String absolute_time_stamp;

    // Getters and Setters
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

    public String getAbsolute_time_stamp() {
        return absolute_time_stamp;
    }

    public void setAbsolute_time_stamp(String absolute_time_stamp) {
        this.absolute_time_stamp = absolute_time_stamp;
    }
}
