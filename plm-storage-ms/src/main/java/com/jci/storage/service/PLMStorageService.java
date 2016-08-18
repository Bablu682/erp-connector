package com.jci.storage.service;

import java.util.HashMap;

public interface PLMStorageService {

	String PutXmlBom(HashMap<String, String> mvm);  //xml from Subscriber
	
	String PutJsonBom(String json);  //json from bom
}
