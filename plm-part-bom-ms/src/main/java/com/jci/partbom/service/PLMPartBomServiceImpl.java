package com.jci.partbom.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jci.partbom.feignclient.PLMStorageFeignClient;

@Service
public class PLMPartBomServiceImpl implements PLMPartBomService {
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;
	@Autowired 
	PLMStorageFeignClient sfClient;

	public String bomApiCallInApigee() {
		// "https://apiqa.jci.com:10450/jcicorp/v1/paymentmanager";
		String uri2 = "https://apidev.jci.com:10450/jcicorp/v1/paymentmanager";

		RestTemplate restTemplate = new RestTemplate();

		// String result1 = restTemplate.getForObject(uri1, String.class);
		String result2 = restTemplate.getForObject(uri2, String.class);

		// System.out.println(result1);
		System.out.println(result2);
		return result2;

	}
	
	
	public String partApiCallInApigee() {
		// "https://apiqa.jci.com:10450/jcicorp/v1/paymentmanager";
		String uri2 = "https://apidev.jci.com:10450/jcicorp/v1/paymentmanager";

		RestTemplate restTemplate = new RestTemplate();

		// String result1 = restTemplate.getForObject(uri1, String.class);
		String result2 = restTemplate.getForObject(uri2, String.class);

		// System.out.println(result1);
		System.out.println(result2);
		return result2;

	}
	

	/*public String jsonSendToStorege(URI uri, HashMap<String, String> jsonXml) {
		try {

			System.out.println("================================================================");
			String temp = jsonXml.get("payloadJsonXml");
			System.out.println("Url = " + uri);
			System.out.println("URI Triggered");
			Map result = restTemplate.postForObject(uri, temp, Map.class);

			// client.sendData(uri, jsonXml);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return "Data printed";
	}*/


	@Override
	public String jsonSendToStorage(HashMap<String, Object> jsonXml) {
		// TODO Auto-generated method stub
		System.out.println("Data reach to service impl of PART-BOM ms");
		sfClient.sendData(jsonXml);
		return null;
	}

	

	
}
