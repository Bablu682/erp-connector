package com.jci.payloadprocess.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="plm-storage-ms",url="http://10.109.218.70:9393")
public interface StorageFeignClient {
	
	
	@RequestMapping(method = RequestMethod.POST, value="/receiveXml")
	public String sendData(@RequestBody  String xmlPayload);
	
}
	


