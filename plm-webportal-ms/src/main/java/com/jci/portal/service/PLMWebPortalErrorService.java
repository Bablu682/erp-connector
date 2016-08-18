package com.jci.portal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jci.portal.dao.PLMErrorDao;
import com.jci.portal.domain.JCIASTSampleEntity;

@Service
public class PLMWebPortalErrorService {

	@Autowired
	PLMErrorDao dao;

	public List<JCIASTSampleEntity> getJsonData()

	{
	List<JCIASTSampleEntity> en=new ArrayList<JCIASTSampleEntity>();
		en=  (List<JCIASTSampleEntity>) dao.getJsonData();
		return en;
	}
}
