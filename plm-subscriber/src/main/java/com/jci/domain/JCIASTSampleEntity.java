package com.jci.jciPLMMQSubcriber.domain;

import com.microsoft.windowsazure.services.table.client.TableServiceEntity;

public class JCIASTSampleEntity extends TableServiceEntity {

	private String name;

	public JCIASTSampleEntity(String id) {
		this.partitionKey = "PO";
		this.rowKey = id;
	}

	public JCIASTSampleEntity() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
