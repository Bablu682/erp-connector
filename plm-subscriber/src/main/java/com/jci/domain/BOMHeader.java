package com.jci.jciPLMMQSubcriber.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="BOMHeader")
public class BOMHeader {

	private String object_id;
	private String class_name;
	private String last_changed_by;
	private int number;
	private Date start_effectivity;
	private Date end_effectivity;
	private String start_serial_number_effectivity;
	private String end_serial_number_effectivity;
	private String start_lot_number_effectivity;
	private String end_lot_number_effectivity;
	private String serial_number_effectivity_cxt_partno;
	private String lot_number_effectivity_cxt_partno;
	private String version;
	private int iteration;
	private String previous_version;
	private String usage;
	private String alternate;
	private boolean is_cad_phantom;
	private int target_id;
	
	@XmlElement(name="ObjectID")
	public String getObject_id() {
		return object_id;
	}
	@XmlElement(name="Class")
	public String getClass_name() {
		return class_name;
	}
	@XmlElement(name="LastChangedBy")
	public String getLast_changed_by() {
		return last_changed_by;
	}
	@XmlElement(name="Number")
	public int getNumber() {
		return number;
	}
	@XmlElement(name="StartEffectivity")
	public Date getStart_effectivity() {
		return start_effectivity;
	}
	@XmlElement(name="EndEffectivity")
	public Date getEnd_effectivity() {
		return end_effectivity;
	}
	@XmlElement(name="StartSerialNumberEffectivity")
	public String getStart_serial_number_effectivity() {
		return start_serial_number_effectivity;
	}
	@XmlElement(name="EndSerialNumberEffectivity")
	public String getEnd_serial_number_effectivity() {
		return end_serial_number_effectivity;
	}
	@XmlElement(name="StartLotNumberEffectivity")
	public String getStart_lot_number_effectivity() {
		return start_lot_number_effectivity;
	}
	@XmlElement(name="EndLotNumberEffectivity")
	public String getEnd_lot_number_effectivity() {
		return end_lot_number_effectivity;
	}
	@XmlElement(name="SerialNumberEffectivityCxtPartNumber")
	public String getSerial_number_effectivity_cxt_partno() {
		return serial_number_effectivity_cxt_partno;
	}
	@XmlElement(name="LotNumberEffectivityCxtPartNumber")
	public String getLot_number_effectivity_cxt_partno() {
		return lot_number_effectivity_cxt_partno;
	}
	@XmlElement(name="Version")
	public String getVersion() {
		return version;
	}
	@XmlElement(name="Iteration")
	public int getIteration() {
		return iteration;
	}
	@XmlElement(name="PreviousVersion")
	public String getPrevious_version() {
		return previous_version;
	}
	@XmlElement(name="Usage")
	public String getUsage() {
		return usage;
	}
	@XmlElement(name="Alternate")
	public String getAlternate() {
		return alternate;
	}
	@XmlElement(name="IsCADPhantom")
	public boolean isIs_cad_phantom() {
		return is_cad_phantom;
	}
	@XmlElement(name="TargetID")
	public int getTarget_id() {
		return target_id;
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
	public void setStart_effectivity(Date start_effectivity) {
		this.start_effectivity = start_effectivity;
	}
	public void setEnd_effectivity(Date end_effectivity) {
		this.end_effectivity = end_effectivity;
	}
	public void setStart_lot_number_effectivity(String start_lot_number_effectivity) {
		this.start_lot_number_effectivity = start_lot_number_effectivity;
	}
	public void setEnd_lot_number_effectivity(String end_lot_number_effectivity) {
		this.end_lot_number_effectivity = end_lot_number_effectivity;
	}
	public void setSerial_number_effectivity_cxt_partno(String serial_number_effectivity_cxt_partno) {
		this.serial_number_effectivity_cxt_partno = serial_number_effectivity_cxt_partno;
	}
	public void setLot_number_effectivity_cxt_partno(String lot_number_effectivity_cxt_partno) {
		this.lot_number_effectivity_cxt_partno = lot_number_effectivity_cxt_partno;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setIteration(int iteration) {
		this.iteration = iteration;
	}
	public void setPrevious_version(String previous_version) {
		this.previous_version = previous_version;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public void setAlternate(String alternate) {
		this.alternate = alternate;
	}
	public void setIs_cad_phantom(boolean is_cad_phantom) {
		this.is_cad_phantom = is_cad_phantom;
	}
	public void setTarget_id(int target_id) {
		this.target_id = target_id;
	}
}
