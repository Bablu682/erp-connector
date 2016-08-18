package com.jci.storage.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.storage.dao.PLMStorageDao;

@Service
public class PLMStorageServiceImpl implements PLMStorageService {

	

	@Autowired
	PLMStorageDao plmStorageDao;
	
	public String PutXmlBom(HashMap<String, String> xml) {
		
		plmStorageDao.PutXmlBom(xml);	
		return null;

	}

	public String PutJsonBom(String json) {
		
		plmStorageDao.PutjsonBom(json);
		
		return null;
	}

	
	
	}
