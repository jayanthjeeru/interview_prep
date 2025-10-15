package com.java.cassandrasupport.entity;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class InventoryKey implements Serializable{
	
	@PrimaryKeyColumn(name = "deviceId", type = PrimaryKeyType.PARTITIONED)
    private long deviceId;

    @PrimaryKeyColumn(name = "elementPath", type = PrimaryKeyType.CLUSTERED)
    private String elementPath;

    public InventoryKey() {}

    public InventoryKey(long deviceId, String elementPath) {
        this.deviceId = deviceId;
        this.elementPath = elementPath;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getElementPath() {
        return elementPath;
    }

    public void setElementPath(String elementPath) {
        this.elementPath = elementPath;
    }

    @Override
    public String toString() {
        return "InventoryKey{" +
               "deviceId=" + deviceId +
               ", elementPath='" + elementPath + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryKey that = (InventoryKey) o;
        return deviceId == that.deviceId &&
               elementPath.equals(that.elementPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, elementPath);
    }

}
