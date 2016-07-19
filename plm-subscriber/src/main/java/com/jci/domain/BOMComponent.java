package com.jci.jciPLMMQSubcriber.domain;

import javax.xml.bind.annotation.XmlElement;

public class BOMComponent {

	private String object_id;
	private String class_name;
	private int part_number;
	private int assembly_partnumber;
	private String assembly_part_id;
	private int quantity;
	private String unit;
	private int line_number;
	private String find_number;
	private String alternate_item_group;
	private String start_serial_number_effectivity;
	private String end_serial_number_effectivity;
	private String start_lot_number_effectivity;
	private String end_lot_number_effectivity;
	private String component_id;
	private boolean is_child_phantom;
	private String item_relationship;
	private String kit_code;
	private String mandatory_option;
	private String regulated_item;
	private String group_code;
	private int target_id;
	
	@XmlElement(name="ObjectID")
	public String getObject_id() {
		return object_id;
	}
	@XmlElement(name="Class")
	public String getClass_name() {
		return class_name;
	}
	@XmlElement(name="PartNumber")
	public int getPart_number() {
		return part_number;
	}
	@XmlElement(name="AssemblyPartNumber")
	public int getAssembly_partnumber() {
		return assembly_partnumber;
	}
	@XmlElement(name="AssemblyPartID")
	public String getAssembly_part_id() {
		return assembly_part_id;
	}
	@XmlElement(name="Quantity")
	public int getQuantity() {
		return quantity;
	}
	@XmlElement(name="Unit")
	public String getUnit() {
		return unit;
	}
	@XmlElement(name="LineNumber")
	public int getLine_number() {
		return line_number;
	}
	@XmlElement(name="FindNumber")
	public String getFind_number() {
		return find_number;
	}
	@XmlElement(name="AlternateItemGroup")
	public String getAlternate_item_group() {
		return alternate_item_group;
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
	@XmlElement(name="ComponentId")
	public String getComponent_id() {
		return component_id;
	}
	@XmlElement(name="IsChildPhantom")
	public boolean isIs_child_phantom() {
		return is_child_phantom;
	}
	@XmlElement(name="ITEMRELATIONSHIP")
	public String getItem_relationship() {
		return item_relationship;
	}
	@XmlElement(name="KITCODE")
	public String getKit_code() {
		return kit_code;
	}
	@XmlElement(name="MANDATORYOPTION")
	public String getMandatory_option() {
		return mandatory_option;
	}
	@XmlElement(name="REGULATEDITEM")
	public String getRegulated_item() {
		return regulated_item;
	}
	@XmlElement(name="GROUPCODE")
	public String getGroup_code() {
		return group_code;
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
	public void setPart_number(int part_number) {
		this.part_number = part_number;
	}
	public void setAssembly_partnumber(int assembly_partnumber) {
		this.assembly_partnumber = assembly_partnumber;
	}
	public void setAssembly_part_id(String assembly_part_id) {
		this.assembly_part_id = assembly_part_id;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public void setLine_number(int line_number) {
		this.line_number = line_number;
	}
	public void setFind_number(String find_number) {
		this.find_number = find_number;
	}
	public void setAlternate_item_group(String alternate_item_group) {
		this.alternate_item_group = alternate_item_group;
	}
	public void setStart_serial_number_effectivity(String start_serial_number_effectivity) {
		this.start_serial_number_effectivity = start_serial_number_effectivity;
	}
	public void setEnd_serial_number_effectivity(String end_serial_number_effectivity) {
		this.end_serial_number_effectivity = end_serial_number_effectivity;
	}
	public void setStart_lot_number_effectivity(String start_lot_number_effectivity) {
		this.start_lot_number_effectivity = start_lot_number_effectivity;
	}
	public void setEnd_lot_number_effectivity(String end_lot_number_effectivity) {
		this.end_lot_number_effectivity = end_lot_number_effectivity;
	}
	public void setComponent_id(String component_id) {
		this.component_id = component_id;
	}
	public void setIs_child_phantom(boolean is_child_phantom) {
		this.is_child_phantom = is_child_phantom;
	}
	public void setItem_relationship(String item_relationship) {
		this.item_relationship = item_relationship;
	}
	public void setKit_code(String kit_code) {
		this.kit_code = kit_code;
	}
	public void setMandatory_option(String mandatory_option) {
		this.mandatory_option = mandatory_option;
	}
	public void setRegulated_item(String regulated_item) {
		this.regulated_item = regulated_item;
	}
	public void setGroup_code(String group_code) {
		this.group_code = group_code;
	}
	public void setTarget_id(int target_id) {
		this.target_id = target_id;
	}
}
