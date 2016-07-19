package com.jci.jciPLMMQSubcriber.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="AddedECN")
public class AddedECN {

	private String name;
	private String type;
	private int status;
	private ECNHeader ecn_header;
	
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
	@XmlElement(name="ECNHeader")
	public ECNHeader getEcn_header() {
		return ecn_header;
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
	public void setEcnHeader(ECNHeader ecn_header) {
		this.ecn_header = ecn_header;
	}
}
