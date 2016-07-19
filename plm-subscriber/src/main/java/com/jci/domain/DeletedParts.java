package com.jci.jciPLMMQSubcriber.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DeletedParts")
public class DeletedParts {
	private String name;
	private String type;
	private int status;
	private List<Part> part;
	
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
	@XmlElement(name="Part")
	public List<Part> getPart() {
		return part;
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
	public void setPart(List<Part> part) {
		this.part = part;
	}
}
