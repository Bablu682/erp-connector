package com.jci.jciPLMMQSubcriber.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="UnchangedOprOperatedOnParts")
public class UnchangedOprOperatedOnParts {
	
	private String name;
	private String type;
	private int status;
	
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
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
