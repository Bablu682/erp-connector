package com.jci.partbom.feignclient;

import java.net.URI;
import java.util.HashMap;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="plm-storage-ms",url="http://10.109.218.70:9393")//Strorage Microservice
public interface PLMStorageFeignClient {
	@RequestMapping(method = RequestMethod.POST, value="/receiveFromPBMS")
	public String sendData(@RequestBody HashMap<String, Object> jsonXml);
}


