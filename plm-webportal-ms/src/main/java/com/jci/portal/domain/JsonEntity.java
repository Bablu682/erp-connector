package com.jci.portal.domain;

import java.util.HashMap;

public class JsonEntity {
	
	private HashMap<String, JCIASTSampleEntity> resultSet;

	public HashMap<String, JCIASTSampleEntity> getResultSet() {
		return resultSet;
	}

	public void setResultSet(HashMap<String, JCIASTSampleEntity> resultSet) {
		this.resultSet = resultSet;
	}

	@Override
	public String toString() {
		return "JsonEntity [resultSet=" + resultSet + "]";
	}
	
	

}
