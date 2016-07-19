package com.jci.jciPLMMQSubcriber.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DeletedBOMComponents")
public class DeletedBOMComponents {

	private String name;
	private String type;
	private int status;
	private BOMComponent bom_component;
	
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
	@XmlElement(name="BOMComponent")
	public BOMComponent getBom_component() {
		return bom_component;
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
	public void setBom_component(BOMComponent bom_component) {
		this.bom_component = bom_component;
	}
}
