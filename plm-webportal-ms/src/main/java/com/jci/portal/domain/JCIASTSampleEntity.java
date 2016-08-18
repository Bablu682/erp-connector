package com.jci.portal.domain;

import com.microsoft.windowsazure.services.table.client.TableServiceEntity;

public class JCIASTSampleEntity extends TableServiceEntity {

	private long txnID;
	private Boolean ptcAck;
	private Boolean partPayloadProcessed;
	private Boolean bomPayloadProcessed;
	private String ECNNumber;
	private String Error;
	private Boolean PartError;
	private Boolean BomError;
	private int isProcessedTotal;
	private int isErroredTotal;
	///new
	
	public JCIASTSampleEntity(String partitionKey, String rowKey) {
		this.partitionKey = "Payload";
		this.rowKey = rowKey;

	}

	public int getIsProcessedTotal() {
		return isProcessedTotal;
	}
	public void setIsProcessedTotal(int isProcessedTotal) {
		this.isProcessedTotal = isProcessedTotal;
	}
	public int getIsErroredTotal() {
		return isErroredTotal;
	}
	public void setIsErroredTotal(int isErroredTotal) {
		this.isErroredTotal = isErroredTotal;
	}

	public String getECNNumber() {
		return ECNNumber;
	}

	public void setECNNumber(String eCNNumber) {
		ECNNumber = eCNNumber;
	}

	public JCIASTSampleEntity() {
	}


	public String getError() {
		return Error;
	}

	public void setError(String error) {
		Error = error;
	}

	public Boolean getPtcAck() {
		return ptcAck;
	}

	public Boolean getPartError() {
		return PartError;
	}

	public void setPartError(Boolean partError) {
		PartError = partError;
	}

	public Boolean getBomError() {
		return BomError;
	}

	public void setBomError(Boolean bomError) {
		BomError = bomError;
	}

	public void setPtcAck(Boolean ptcAck) {
		this.ptcAck = ptcAck;
	}

	public Boolean getPartPayloadProcessed() {
		return partPayloadProcessed;
	}

	public void setPartPayloadProcessed(Boolean partPayloadProcessed) {
		this.partPayloadProcessed = partPayloadProcessed;
	}

	public Boolean getBomPayloadProcessed() {
		return bomPayloadProcessed;
	}

	public void setBomPayloadProcessed(Boolean bomPayloadProcessed) {
		this.bomPayloadProcessed = bomPayloadProcessed;
	}

	public long getTxnID() {
		return txnID;
	}

	public void setTxnID(long txnID) {
		this.txnID = txnID;
	}

	@Override
	public String toString() {
		return "JCIASTSampleEntity [txnID=" + txnID + ", ECNNumber=" + ECNNumber + ", Error=" + Error + "]";
	}
	
	

}
