package com.jci.jciPLMMQSubcriber.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Transaction")
public class Transaction {

	private int transaction_number;
	private int release_number;
	private String primary_object_id;
	private String created_by;
	private Date created_date;
	private String locale;
	private int destination;
	
	@XmlElement(name="TransactionNumber")
	public int getTransactionNumber() {
		return transaction_number;
	}
	@XmlElement(name="ReleaseNumber")
	public int getReleaseNumber() {
		return release_number;
	}
	@XmlElement(name="PrimaryObjectID")
	public String getPrimaryObjectID() {
		return primary_object_id;
	}
	@XmlElement(name="CreatedBy")
	public String getCreatedBy() {
		return created_by;
	}
	@XmlElement(name="CreatedDate")
	public Date getCreatedDate() {
		return created_date;
	}
	@XmlElement(name="Locale")
	public String getLocale() {
		return locale;
	}
	@XmlElement(name="Destination")
	public int getDestination() {
		return destination;
	}
	public void setTransactionNumber(int transaction_number) {
		this.transaction_number = transaction_number;
	}
	public void setReleaseNumber(int release_number) {
		this.release_number = release_number;
	}
	public void setPrimaryObjectID(String primary_object_id) {
		this.primary_object_id = primary_object_id;
	}
	public void setCreatedBy(String created_by) {
		this.created_by = created_by;
	}
	public void setCreatedDate(Date created_date) {
		this.created_date = created_date;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
}
