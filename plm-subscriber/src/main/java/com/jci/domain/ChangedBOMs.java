package com.jci.jciPLMMQSubcriber.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ChangedBOMs")
public class ChangedBOMs {

	private String name;
	private String type;
	private int status;
	private BOMHeader bom_header;
	
	@XmlAttribute(name="NAME")
	public String getName() {
		return name;
	}
	@XmlAttribute(name="TYPE")
	public String getType() {
		return type;
	}
	@XmlAttribute(name="STATUS")
	public int getStatus() {
		return status;
	}
	@XmlElement(name="BOMHeader")
	public BOMHeader getBom_header() {
		return bom_header;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setBom_header(BOMHeader bom_header) {
		this.bom_header = bom_header;
	}
	
}
