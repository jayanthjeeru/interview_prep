package com.java.cassandrasupport.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("devinventory")
public class Inventory {

	@PrimaryKey
	private InventoryKey key;
	long timeStamp;
	String modelName;
	String elementValue;

	public Inventory() {

	}
	
	

	public Inventory(InventoryKey key, long timeStamp, String modelName, String elementValue) {
		
		this.key = key;
		this.timeStamp = timeStamp;
		this.modelName = modelName;
		this.elementValue = elementValue;
	}



	public InventoryKey getKey() {
		return key;
	}

	public void setKey(InventoryKey key) {
		this.key = key;
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
