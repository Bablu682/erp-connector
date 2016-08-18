package com.jci.payloadprocess.service;

import java.util.HashMap;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="plm-part-bom-ms",url="http://10.109.218.70:9090")
public interface BomFeignClient {
	

	@RequestMapping(method = RequestMethod.POST, value="/receiveJson")
	public String sendData2(@RequestBody HashMap<String, Object> hashMap);
	
	
}
	
	
	
	
	