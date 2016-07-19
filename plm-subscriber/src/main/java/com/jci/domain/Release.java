package com.jci.jciPLMMQSubcriber.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Release")
public class Release {

	private String name;
	private String type;
	private int status;
	private Transaction transaction;
	
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
	@XmlElement(name="Transaction")
	public Transaction getTransaction() {
		return transaction;
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
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
