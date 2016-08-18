package com.jci.storage.domain;

import com.microsoft.windowsazure.services.table.client.TableServiceEntity;

public class Payload extends TableServiceEntity{
	
	
	
	private String payload;
	
		public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
		public Payload(String ecnNo, String ecnName) {
        this.partitionKey = ecnNo;
        this.rowKey = ecnName;
    }
	public Payload() { }
}
