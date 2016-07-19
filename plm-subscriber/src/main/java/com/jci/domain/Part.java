package com.jci.jciPLMMQSubcriber.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * Modification done based on latest parts file (24th june 2016).
 * Extra part parameters from previous release are commented.
 * sender: Michal (23th june 2016). */

@XmlRootElement(name = "Part")
public class Part {

	private String object_id;
	private String className;
	private String last_changed_by;
	private String number;
	private Date start_effectivity;
	private Date end_effectivity;
	private Date start_serialnumber_effectivity;
	private Date end_serialnumber_effectivity;
	private Date start_lotnumber_effectivity;
	private Date end_lotnumber_effectivity;
	private String serialnumber_effectivity_cxtpartnumber;
	private String lotnumber_effectivity_cxtpartnumber;
	private String default_unit;
	private String name;
	private String part_type;
	private String source;
	private String state;
	private Boolean is_phantom;
	private String version;
	private Integer iteration;
	private String previous_version;
	
	/* private boolean end_item;
	private String generic_type;
	private String design_controlled;
	private String exteranl_regulations;
	private int id_type_code;
	private int last_group_code;
	private String legacy_name;
	private String cmi_mass;
	private String release_phase_code;
	private int royalty_code;
	private String safety_part;
	private String security_level;
	private int source_code_id;
	private int source_controlled;
	private String effect_code;
	private String item_control;
	private String msds_eligible;
	private String msds_reference;
	private String elective_part;
	private String user_item_type;
	private String marketing_description;
	private String marketing_model_number;
	private String marketing_number;
	private String market_text;
	private String configurable_product;
	private String reference_order_no;
	private String customer_code;
	private String customer_name;
	private String customer_part_number;
	private String saleable_product;
	private String classification;
	private String condition;
	private String remanufacture_type;
	private String designator;
	private String yield;
	private String salvagerate;
	private String manufacturing_usage;
	private String maximum_reusability;*/
	
	private String is_configurable;
	private boolean is_collapsible;
	/*private String agency_required;
	private String code_number;
	private String engineering_desc;
	private String rohs_required;
	private Double weight;*/
	private int target_id;
	
	@XmlElement(name="ObjectID")
	public String getObject_id() {
		return object_id;
	}
	@XmlElement(name="Class")
	public String getClassName() {
		return className;
	}
	@XmlElement(name="LastChangedBy")
	public String getLast_changed_by() {
		return last_changed_by;
	}
	@XmlElement(name="Number")
	public String getNumber() {
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
	public Date getStart_serialnumber_effectivity() {
		return start_serialnumber_effectivity;
	}
	@XmlElement(name="EndSerialNumberEffectivity")
	public Date getEnd_serialnumber_effectivity() {
		return end_serialnumber_effectivity;
	}
	@XmlElement(name="StartLotNumberEffectivity")
	public Date getStart_lotnumber_effectivity() {
		return start_lotnumber_effectivity;
	}
	@XmlElement(name="EndLotNumberEffectivity")
	public Date getEnd_lotnumber_effectivity() {
		return end_lotnumber_effectivity;
	}
	@XmlElement(name="SerialNumberEffectivityCxtPartNumber")
	public String getSerialnumber_effectivity_cxtpartnumber() {
		return serialnumber_effectivity_cxtpartnumber;
	}
	@XmlElement(name="LotNumberEffectivityCxtPartNumber")
	public String getLotnumber_effectivity_cxtpartnumber() {
		return lotnumber_effectivity_cxtpartnumber;
	}
	@XmlElement(name="DefaultUnit")
	public String getDefault_unit() {
		return default_unit;
	}
	@XmlElement(name="Name")
	public String getName() {
		return name;
	}
	@XmlElement(name="PartType")
	public String getPart_type() {
		return part_type;
	}
	@XmlElement(name="Source")
	public String getSource() {
		return source;
	}
	@XmlElement(name="State")
	public String getState() {
		return state;
	}
	@XmlElement(name="IsPhantom")
	public Boolean getIs_phantom() {
		return is_phantom;
	}
	@XmlElement(name="Version")
	public String getVersion() {
		return version;
	}
	@XmlElement(name="Iteration")
	public Integer getIteration() {
		return iteration;
	}
	@XmlElement(name="PreviousVersion")
	public String getPrevious_version() {
		return previous_version;
	}
	@XmlElement(name="IsConfigurable")
	public String getIs_configurable() {
		return is_configurable;
	}
	@XmlElement(name="IsCollapsible")
	public boolean isIs_collapsible() {
		return is_collapsible;
	}
	
	
	/*public boolean isEnd_item() {
		return end_item;
	}
	public String getGeneric_type() {
		return generic_type;
	}
	@XmlElement(name="AgencyRequired")
	public String getAgency_required() {
		return agency_required;
	}
	@XmlElement(name="CodeNumber")
	public String getCode_number() {
		return code_number;
	}
	@XmlElement(name="EngineeringDescription")
	public String getEngineering_desc() {
		return engineering_desc;
	}
	@XmlElement(name="ROHSRequired")
	public String getRohs_required() {
		return rohs_required;
	}
	@XmlElement(name="Weight")
	public Double getWeight() {
		return weight;
	}
	@XmlElement(name="DESIGNCONTROLLED")
	public String getDesign_controlled() {
		return design_controlled;
	}
	@XmlElement(name="EXTERANLREGULATIONS")
	public String getExteranl_regulations() {
		return exteranl_regulations;
	}
	@XmlElement(name="IDTYPECODE")
	public int getId_type_code() {
		return id_type_code;
	}
	@XmlElement(name="LASTGROUPCODE")
	public int getLast_group_code() {
		return last_group_code;
	}
	@XmlElement(name="LEGACYNAME")
	public String getLegacy_name() {
		return legacy_name;
	}
	@XmlElement(name="CMI_MASS")
	public String getCmi_mass() {
		return cmi_mass;
	}
	@XmlElement(name="RELEASEPHASECODE")
	public String getRelease_phase_code() {
		return release_phase_code;
	}
	@XmlElement(name="ROYALTYCODE")
	public int getRoyalty_code() {
		return royalty_code;
	}
	@XmlElement(name="SAFETYPART")
	public String getSafety_part() {
		return safety_part;
	}
	@XmlElement(name="SECURITYLEVEL")
	public String getSecurity_level() {
		return security_level;
	}
	@XmlElement(name="SOURCECODEID")
	public int getSource_code_id() {
		return source_code_id;
	}
	@XmlElement(name="SOURCECONTROLLED")
	public int getSource_controlled() {
		return source_controlled;
	}
	@XmlElement(name="EFFECTCODE")
	public String getEffect_code() {
		return effect_code;
	}
	@XmlElement(name="ITEMCONTROL")
	public String getItem_control() {
		return item_control;
	}
	@XmlElement(name="MSDSELIGIBLE")
	public String getMsds_eligible() {
		return msds_eligible;
	}
	@XmlElement(name="MSDSREFERENCE")
	public String getMsds_reference() {
		return msds_reference;
	}
	@XmlElement(name="ELECTIVEPART")
	public String getElective_part() {
		return elective_part;
	}
	@XmlElement(name="USERITEMTYPE")
	public String getUser_item_type() {
		return user_item_type;
	}
	@XmlElement(name="MARKETINGDESCRIPTION")
	public String getMarketing_description() {
		return marketing_description;
	}
	@XmlElement(name="MARKETINGMODELNUMBER")
	public String getMarketing_model_number() {
		return marketing_model_number;
	}
	@XmlElement(name="MARKETINGNUMBER")
	public String getMarketing_number() {
		return marketing_number;
	}
	@XmlElement(name="MARKETINGTEXT")
	public String getMarket_text() {
		return market_text;
	}
	@XmlElement(name="CONFIGURABLEPRODUCT")
	public String getConfigurable_product() {
		return configurable_product;
	}
	@XmlElement(name="REFERENCEORDERNUMBER")
	public String getReference_order_no() {
		return reference_order_no;
	}
	@XmlElement(name="CUSTOMERCODE")
	public String getCustomer_code() {
		return customer_code;
	}
	@XmlElement(name="CUSTOMERNAME")
	public String getCustomer_name() {
		return customer_name;
	}
	@XmlElement(name="CUSTOMERPARTNUMBER")
	public String getCustomer_part_number() {
		return customer_part_number;
	}
	@XmlElement(name="SALEABLEPRODUCT")
	public String getSaleable_product() {
		return saleable_product;
	}
	@XmlElement(name="CLASSIFICATION")
	public String getClassification() {
		return classification;
	}
	@XmlElement(name="CONDITION")
	public String getCondition() {
		return condition;
	}
	@XmlElement(name="REMANUFACTURETYPE")
	public String getRemanufacture_type() {
		return remanufacture_type;
	}
	@XmlElement(name="DESIGNATOR")
	public String getDesignator() {
		return designator;
	}
	@XmlElement(name="YIELD")
	public String getYield() {
		return yield;
	}
	@XmlElement(name="SALVAGERATE")
	public String getSalvagerate() {
		return salvagerate;
	}
	@XmlElement(name="MANUFACTURINGUSAGE")
	public String getManufacturing_usage() {
		return manufacturing_usage;
	}
	@XmlElement(name="MAXIMUMREUSABILITY")
	public String getMaximum_reusability() {
		return maximum_reusability;
	}
	*/
	@XmlElement(name="TargetID")
	public int getTarget_id() {
		return target_id;
	}
	
	
	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public void setLast_changed_by(String last_changed_by) {
		this.last_changed_by = last_changed_by;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setStart_effectivity(Date start_effectivity) {
		this.start_effectivity = start_effectivity;
	}
	public void setEnd_effectivity(Date end_effectivity) {
		this.end_effectivity = end_effectivity;
	}
	public void setStart_serialnumber_effectivity(Date start_serialnumber_effectivity) {
		this.start_serialnumber_effectivity = start_serialnumber_effectivity;
	}
	public void setEnd_serialnumber_effectivity(Date end_serialnumber_effectivity) {
		this.end_serialnumber_effectivity = end_serialnumber_effectivity;
	}
	public void setStart_lotnumber_effectivity(Date start_lotnumber_effectivity) {
		this.start_lotnumber_effectivity = start_lotnumber_effectivity;
	}
	public void setEnd_lotnumber_effectivity(Date end_lotnumber_effectivity) {
		this.end_lotnumber_effectivity = end_lotnumber_effectivity;
	}
	public void setSerialnumber_effectivity_cxtpartnumber(String serialnumber_effectivity_cxtpartnumber) {
		this.serialnumber_effectivity_cxtpartnumber = serialnumber_effectivity_cxtpartnumber;
	}
	public void setLotnumber_effectivity_cxtpartnumber(String lotnumber_effectivity_cxtpartnumber) {
		this.lotnumber_effectivity_cxtpartnumber = lotnumber_effectivity_cxtpartnumber;
	}
	public void setDefault_unit(String default_unit) {
		this.default_unit = default_unit;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPart_type(String part_type) {
		this.part_type = part_type;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setIs_phantom(Boolean is_phantom) {
		this.is_phantom = is_phantom;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setIteration(Integer iteration) {
		this.iteration = iteration;
	}
	public void setPrevious_version(String previous_version) {
		this.previous_version = previous_version;
	}
	public void setIs_configurable(String is_configurable) {
		this.is_configurable = is_configurable;
	}
	public void setIs_collapsible(boolean is_collapsible) {
		this.is_collapsible = is_collapsible;
	}
	
	/*public void setEnd_item(boolean end_item) {
		this.end_item = end_item;
	}
	public void setGeneric_type(String generic_type) {
		this.generic_type = generic_type;
	}
	public void setAgency_required(String agency_required) {
		this.agency_required = agency_required;
	}
	public void setCode_number(String code_number) {
		this.code_number = code_number;
	}
	public void setEngineering_desc(String engineering_desc) {
		this.engineering_desc = engineering_desc;
	}
	public void setRohs_reqired(String rohs_required) {
		this.rohs_required = rohs_required;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public void setDesign_controlled(String design_controlled) {
		this.design_controlled = design_controlled;
	}
	public void setExteranl_regulations(String exteranl_regulations) {
		this.exteranl_regulations = exteranl_regulations;
	}
	public void setId_type_code(int id_type_code) {
		this.id_type_code = id_type_code;
	}
	public void setLast_group_code(int last_group_code) {
		this.last_group_code = last_group_code;
	}
	public void setLegacy_name(String legacy_name) {
		this.legacy_name = legacy_name;
	}
	public void setCmi_mass(String cmi_mass) {
		this.cmi_mass = cmi_mass;
	}
	public void setRelease_phase_code(String release_phase_code) {
		this.release_phase_code = release_phase_code;
	}
	public void setRoyalty_code(int royalty_code) {
		this.royalty_code = royalty_code;
	}
	public void setSafety_part(String safety_part) {
		this.safety_part = safety_part;
	}
	public void setSecurity_level(String security_level) {
		this.security_level = security_level;
	}
	public void setSource_code_id(int source_code_id) {
		this.source_code_id = source_code_id;
	}
	public void setSource_controlled(int source_controlled) {
		this.source_controlled = source_controlled;
	}
	public void setEffect_code(String effect_code) {
		this.effect_code = effect_code;
	}
	public void setItem_control(String item_control) {
		this.item_control = item_control;
	}
	public void setMsds_eligible(String msds_eligible) {
		this.msds_eligible = msds_eligible;
	}
	public void setMsds_reference(String msds_reference) {
		this.msds_reference = msds_reference;
	}
	public void setElective_part(String elective_part) {
		this.elective_part = elective_part;
	}
	public void setUser_item_type(String user_item_type) {
		this.user_item_type = user_item_type;
	}
	public void setMarketing_description(String marketing_description) {
		this.marketing_description = marketing_description;
	}
	public void setMarketing_model_number(String marketing_model_number) {
		this.marketing_model_number = marketing_model_number;
	}
	public void setMarketing_number(String marketing_number) {
		this.marketing_number = marketing_number;
	}
	public void setMarket_text(String market_text) {
		this.market_text = market_text;
	}
	public void setConfigurable_product(String configurable_product) {
		this.configurable_product = configurable_product;
	}
	public void setReference_order_no(String reference_order_no) {
		this.reference_order_no = reference_order_no;
	}
	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public void setCustomer_part_number(String customer_part_number) {
		this.customer_part_number = customer_part_number;
	}
	public void setSaleable_product(String saleable_product) {
		this.saleable_product = saleable_product;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public void setRemanufacture_type(String remanufacture_type) {
		this.remanufacture_type = remanufacture_type;
	}
	public void setDesignator(String designator) {
		this.designator = designator;
	}
	public void setYield(String yield) {
		this.yield = yield;
	}
	public void setSalvagerate(String salvagerate) {
		this.salvagerate = salvagerate;
	}
	public void setManufacturing_usage(String manufacturing_usage) {
		this.manufacturing_usage = manufacturing_usage;
	}
	public void setMaximum_reusability(String maximum_reusability) {
		this.maximum_reusability = maximum_reusability;
	}*/
	public void setTarget_id(int target_id) {
		this.target_id = target_id;
	}
}
