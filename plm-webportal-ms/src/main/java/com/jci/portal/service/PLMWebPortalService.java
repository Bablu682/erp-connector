package com.jci.portal.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.jci.portal.domain.JCIASTSampleEntity;
import com.jci.portal.domain.TotalData;

public interface PLMWebPortalService {
	public List<JCIASTSampleEntity> getTotalProcessedEntities();

	public HashMap<String, Object> getMessage() throws Exception;
	public String sendData2(@RequestBody  HashMap<String, Object> hashMap);
	public File getXml();

}
