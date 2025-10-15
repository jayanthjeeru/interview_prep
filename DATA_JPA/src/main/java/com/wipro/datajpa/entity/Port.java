package com.wipro.datajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Port {

	@Id
	int tpId;
	String portName;
	String portAttributes;
	
	public int getTpId() {
		return tpId;
	}
	public void setTpId(int tpId) {
		this.tpId = tpId;
	}
	public String getPortName() {
		return portName;
	}
	public void setPortName(String portName) {
		this.portName = portName;
	}
	public String getPortAttributes() {
		return portAttributes;
	}
	public void setPortAttributes(String portAttributes) {
		this.portAttributes = portAttributes;
	}
	
	public Port(int tpId, String portName, String portAttributes) {

		this.tpId = tpId;
		this.portName = portName;
		this.portAttributes = portAttributes;
	}
	
	@Override
	public String toString() {
		return "Port [tpId=" + tpId + ", portName=" + portName + ", portAttributes=" + portAttributes + "]";
	}
	
	
	
}
