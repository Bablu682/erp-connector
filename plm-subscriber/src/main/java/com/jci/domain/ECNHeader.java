package com.jci.jciPLMMQSubcriber.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ECNHeader")
public class ECNHeader {

	private String object_id;
	private String class_name;
	private String last_changed_by;
	private int number;
	private String name;
	private String description;
	private String need_date;
	private String the_cn_complexity;
	private String category;
	private String request_priority;
	private String supllement_CN;
	private int target_Id;
	
	@XmlElement(name="ObjectID")
	public String getObjectID() {
		return object_id;
	}
	@XmlElement(name="Class")
	public String getClassName() {
		return class_name;
	}
	@XmlElement(name="LastChangedBy")
	public String getLastChangedBy() {
		return last_changed_by;
	}
	@XmlElement(name="Number")
	public int getNumber() {
		return number;
	}
	@XmlElement(name="Name")
	public String getName() {
		return name;
	}
	@XmlElement(name="Description")
	public String getDescription() {
		return description;
	}
	@XmlElement(name="needDate")
	public String getNeedDate() {
		return need_date;
	}
	@XmlElement(name="theChangeNoticeComplexity")
	public String getTheCNComplexity() {
		return the_cn_complexity;
	}
	@XmlElement(name="CATEGORY")
	public String getCategory() {
		return category;
	}
	@XmlElement(name="REQUESTPRIORITY")
	public String getRequestPriority() {
		return request_priority;
	}
	@XmlElement(name="SUPLLEMENTCHANGENOTICE")
	public String getSupllementCN() {
		return supllement_CN;
	}
	@XmlElement(name="TargetID")
	public int getTargetId() {
		return target_Id;
	}
	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public void setLast_changed_by(String last_changed_by) {
		this.last_changed_by = last_changed_by;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setNeedDate(String need_date) {
		this.need_date = need_date;
	}
	public void setThe_cn_complexity(String the_cn_complexity) {
		this.the_cn_complexity = the_cn_complexity;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setRequest_priority(String request_priority) {
		this.request_priority = request_priority;
	}
	public void setSupllement_CN(String supllement_CN) {
		this.supllement_CN = supllement_CN;
	}
	public void setTarget_Id(int target_Id) {
		this.target_Id = target_Id;
	}
}
