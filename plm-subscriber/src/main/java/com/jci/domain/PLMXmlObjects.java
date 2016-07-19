
package com.jci.jciPLMMQSubcriber.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="COLLECTION")
public class PLMXmlObjects {
	
	private Release release;
	private DeletedECN deleted_ecn;
	private AddedECN added_ecn;
	private ChangedECN changed_ecn;
	private	UnchangedECN unchanged_ecn;
	private DeletedParts deleted_parts;
	private AddedParts added_parts;
	private ChangedParts changed_parts;
	private UnchangedParts unchanged_parts;
	private DeletedBOMs deleted_boms;
	private AddedBOMs added_boms;
	private ChangedBOMs changed_boms;
	private UnchangedBOMs unchanged_boms;
	private DeletedBOMComponents deleted_bom_components;
	private AddedBOMComponents added_bom_components;
	private ChangedBOMComponents changed_bom_components;
	private UnchangedBOMComponents unchanged_bom_components;
	private DeletedOprBomAllocatedParts del_opr_bom_allocated_parts;
	private AddedOprBomAllocatedParts add_opr_bom_allocated_parts;
	private ChangedOprBomAllocatedParts change_opr_bom_allocated_parts;
	private UnchangedOprBomAllocatedParts unchange_opr_bom_allocated_parts;
	private DeletedOprBomAllocatedParts deleted_opr_bom_allocated_parts;
	private AddedOprOperatedOnParts added_opr_operated_on_parts;
	private ChangedOprOperatedOnParts changed_opr_operated_on_parts;
	private UnchangedOprOperatedOnParts unchanged_opr_operated_on_parts;
	
	@XmlElement(name="Release")
	public Release getRelease() {
		return release;
	}
	@XmlElement(name="DeletedECN")
	public DeletedECN getDeleted_ecn() {
		return deleted_ecn;
	}
	@XmlElement(name="AddedECN")
	public AddedECN getAdded_ecn() {
		return added_ecn;
	}
	@XmlElement(name="ChangedECN")
	public ChangedECN getChanged_ecn() {
		return changed_ecn;
	}
	@XmlElement(name="UnchangedECN")
	public UnchangedECN getUnchanged_ecn() {
		return unchanged_ecn;
	}
	@XmlElement(name="DeletedParts")
	public DeletedParts getDeleted_parts() {
		return deleted_parts;
	}
	@XmlElement(name="AddedParts")
	public AddedParts getAdded_parts() {
		return added_parts;
	}
	@XmlElement(name="ChangedParts")
	public ChangedParts getChanged_parts() {
		return changed_parts;
	}
	@XmlElement(name="UnchangedParts")
	public UnchangedParts getUnchanged_parts() {
		return unchanged_parts;
	}
	@XmlElement(name="DeletedBOMs")
	public DeletedBOMs getDeleted_boms() {
		return deleted_boms;
	}
	@XmlElement(name="AddedBOMs")
	public AddedBOMs getAdded_boms() {
		return added_boms;
	}
	@XmlElement(name="ChangedBOMs")
	public ChangedBOMs getChanged_boms() {
		return changed_boms;
	}
	@XmlElement(name="UnchangedBOMs")
	public UnchangedBOMs getUnchanged_boms() {
		return unchanged_boms;
	}
	@XmlElement(name="DeletedBOMComponents")
	public DeletedBOMComponents getDeleted_bom_components() {
		return deleted_bom_components;
	}
	@XmlElement(name="AddedBOMComponents")
	public AddedBOMComponents getAdded_bom_components() {
		return added_bom_components;
	}
	@XmlElement(name="ChangedBOMComponents")
	public ChangedBOMComponents getChanged_bom_components() {
		return changed_bom_components;
	}
	@XmlElement(name="UnchangedBOMComponents")
	public UnchangedBOMComponents getUnchanged_bom_components() {
		return unchanged_bom_components;
	}
	@XmlElement(name="DeletedOprBomAllocatedParts")
	public DeletedOprBomAllocatedParts getDel_opr_bom_allocated_parts() {
		return del_opr_bom_allocated_parts;
	}
	@XmlElement(name="AddedOprBomAllocatedParts")
	public AddedOprBomAllocatedParts getAdd_opr_bom_allocated_parts() {
		return add_opr_bom_allocated_parts;
	}
	@XmlElement(name="ChangedOprBomAllocatedParts")
	public ChangedOprBomAllocatedParts getChange_opr_bom_allocated_parts() {
		return change_opr_bom_allocated_parts;
	}
	@XmlElement(name="UnchangedOprBomAllocatedParts")
	public UnchangedOprBomAllocatedParts getUnchange_opr_bom_allocated_parts() {
		return unchange_opr_bom_allocated_parts;
	}
	@XmlElement(name="DeletedOprBomAllocatedParts")
	public DeletedOprBomAllocatedParts getDeleted_opr_bom_allocated_parts() {
		return deleted_opr_bom_allocated_parts;
	}
	@XmlElement(name="AddedOprOperatedOnParts")
	public AddedOprOperatedOnParts getAdded_opr_operated_on_parts() {
		return added_opr_operated_on_parts;
	}
	@XmlElement(name="ChangedOprOperatedOnParts")
	public ChangedOprOperatedOnParts getChanged_opr_operated_on_parts() {
		return changed_opr_operated_on_parts;
	}
	@XmlElement(name="UnchangedOprOperatedOnParts")
	public UnchangedOprOperatedOnParts getUnchanged_opr_operated_on_parts() {
		return unchanged_opr_operated_on_parts;
	}
	public void setRelease(Release release) {
		this.release = release;
	}
	public void setDeleted_ecn(DeletedECN deleted_ecn) {
		this.deleted_ecn = deleted_ecn;
	}
	public void setAdded_ecn(AddedECN added_ecn) {
		this.added_ecn = added_ecn;
	}
	public void setChanged_ecn(ChangedECN changed_ecn) {
		this.changed_ecn = changed_ecn;
	}
	public void setUnchanged_ecn(UnchangedECN unchanged_ecn) {
		this.unchanged_ecn = unchanged_ecn;
	}
	public void setDeleted_parts(DeletedParts deleted_parts) {
		this.deleted_parts = deleted_parts;
	}
	public void setAdded_parts(AddedParts added_parts) {
		this.added_parts = added_parts;
	}
	public void setChanged_parts(ChangedParts changed_parts) {
		this.changed_parts = changed_parts;
	}
	public void setUnchanged_parts(UnchangedParts unchanged_parts) {
		this.unchanged_parts = unchanged_parts;
	}
	public void setDeleted_boms(DeletedBOMs deleted_boms) {
		this.deleted_boms = deleted_boms;
	}
	public void setAdded_boms(AddedBOMs added_boms) {
		this.added_boms = added_boms;
	}
	public void setChanged_boms(ChangedBOMs changed_boms) {
		this.changed_boms = changed_boms;
	}
	public void setUnchanged_boms(UnchangedBOMs unchanged_boms) {
		this.unchanged_boms = unchanged_boms;
	}
	public void setDeleted_bom_components(DeletedBOMComponents deleted_bom_components) {
		this.deleted_bom_components = deleted_bom_components;
	}
	public void setAdded_bom_components(AddedBOMComponents added_bom_components) {
		this.added_bom_components = added_bom_components;
	}
	public void setChanged_bom_components(ChangedBOMComponents changed_bom_components) {
		this.changed_bom_components = changed_bom_components;
	}
	public void setUnchanged_bom_components(UnchangedBOMComponents unchanged_bom_components) {
		this.unchanged_bom_components = unchanged_bom_components;
	}
	public void setDel_opr_bom_allocated_parts(DeletedOprBomAllocatedParts del_opr_bom_allocated_parts) {
		this.del_opr_bom_allocated_parts = del_opr_bom_allocated_parts;
	}
	public void setAdd_opr_bom_allocated_parts(AddedOprBomAllocatedParts add_opr_bom_allocated_parts) {
		this.add_opr_bom_allocated_parts = add_opr_bom_allocated_parts;
	}
	public void setChange_opr_bom_allocated_parts(ChangedOprBomAllocatedParts change_opr_bom_allocated_parts) {
		this.change_opr_bom_allocated_parts = change_opr_bom_allocated_parts;
	}
	public void setUnchange_opr_bom_allocated_parts(UnchangedOprBomAllocatedParts unchange_opr_bom_allocated_parts) {
		this.unchange_opr_bom_allocated_parts = unchange_opr_bom_allocated_parts;
	}
	public void setDeleted_opr_bom_allocated_parts(DeletedOprBomAllocatedParts deleted_opr_bom_allocated_parts) {
		this.deleted_opr_bom_allocated_parts = deleted_opr_bom_allocated_parts;
	}
	public void setAdded_opr_operated_on_parts(AddedOprOperatedOnParts added_opr_operated_on_parts) {
		this.added_opr_operated_on_parts = added_opr_operated_on_parts;
	}
	public void setChanged_opr_operated_on_parts(ChangedOprOperatedOnParts changed_opr_operated_on_parts) {
		this.changed_opr_operated_on_parts = changed_opr_operated_on_parts;
	}
	public void setUnchanged_opr_operated_on_parts(UnchangedOprOperatedOnParts unchanged_opr_operated_on_parts) {
		this.unchanged_opr_operated_on_parts = unchanged_opr_operated_on_parts;
	}
}
