/**
 * 
 */
package com.jci.portal;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jci.portal.feignservice.*;
import com.jci.portal.service.PLMWebPortalService;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@RestController
public class PLMWebPortalApplication {
	public static void main(String[] args) {

		SpringApplication.run(PLMWebPortalApplication.class, args);

	}

	@Autowired
	PLMWebPortalService service;
	/*@Autowired
	ReprocessFeign client;*/

	@RequestMapping(value = "/Reprocess", method = RequestMethod.GET)
	public String sendToSubscriber(HashMap<String, Object> hashmap) throws Exception {

		
		HashMap<String, Object> hashMap=new HashMap<>();
		Object completeXml=service.getMessage().get("CompleteXml");
		Object ecnNo=service.getMessage().get("EcnNo");
		hashMap.put("ecnNo", ecnNo);
		hashMap.put("completeXml", completeXml);
		service.sendData2(hashMap);
		
		System.out.println(completeXml);
		//System.out.println(ecnNo1);
		//Object xml1=(Object) service.getMessage().get("CompleteXml");
	//	String txnid1=(String) service.getMessage().get("TxnId");
		//String s = service.getMessage();
		//String s1 = service.sendData2(s);

//		hashMap.put("completeXml", value);
	//	hashMap.put("ecnNo", value);
		
		//System.out.println(xml1);
	//	System.out.println(txnid1);
		return "done";

	}
}
