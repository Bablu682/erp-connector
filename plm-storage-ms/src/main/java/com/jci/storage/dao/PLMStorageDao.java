package com.jci.storage.dao;

import java.util.HashMap;

public interface PLMStorageDao {
	
	
	String PutXmlBom(HashMap<String, String> xml);

	

	String PutjsonBom(String json);

	
}
