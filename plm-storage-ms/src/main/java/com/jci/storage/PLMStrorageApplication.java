/**
 * 
 */
package com.jci.storage;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jci.storage.service.PLMStorageService;

@SpringBootApplication
//@EnableDiscoveryClient

@RestController
public class PLMStrorageApplication {

	public static void main(String[] args) {

		SpringApplication.run(PLMStrorageApplication.class, args);

	}

	

	//given by subcriber ms
	@Autowired
	private PLMStorageService storageservice;
		@RequestMapping(value = "/receiveXml", method = { RequestMethod.POST })
	public String recievedXmlFromSubscriber(@RequestBody String s1) throws Exception {

		System.out.println("Data from Subcriber recived at storage");
		System.out.println("-------------------------------------------------------------");
//		System.out.println(s1);
		return s1;

	}
//given by PART-BOM ms
	@RequestMapping(value = "/receiveFromPBMS", method = { RequestMethod.POST })
	public String recievedJson(@RequestBody HashMap<String, Object> jsonXml) throws Exception {

		System.out.println("Storage receiveFromPBMS triggered");

		System.out.println("Data reach at Storage ms from PART-BOM ms");
		System.out.println("===================PART=======================");
		System.out.println(jsonXml.get("part"));
		System.out.println("===================BOM=======================");
		System.out.println(jsonXml.get("bom"));
		System.out.println("===================JSON=======================");
		System.out.println(jsonXml.get("json"));

		return null;
	//	return storageservice.PutJsonBom(json);

	}
}
