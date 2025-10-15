package com.java.cassandrasupport.dto;



public class InventoryDto {
	
	private long deviceId;
    private String elementPath;
    long timeStamp;
	String modelName;
	String elementValue;
	
	
	
	public InventoryDto(long deviceId, String elementPath, long timeStamp, String modelName, String elementValue) {
		
		this.deviceId = deviceId;
		this.elementPath = elementPath;
		this.timeStamp = timeStamp;
		this.modelName = modelName;
		this.elementValue = elementValue;
	}
	
	
	
	public InventoryDto() {
	
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
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getElementValue() {
		return elementValue;
	}
	public void setElementValue(String elementValue) {
		this.elementValue = elementValue;
	}
	
	

}
