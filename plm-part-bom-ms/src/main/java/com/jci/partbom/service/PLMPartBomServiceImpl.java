package com.jci.partbom.service;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class PLMPartBomServiceImpl implements PLMPartBomService {
	@Autowired
	RestTemplate resttemplate;
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	

		@Autowired
		private DiscoveryClient discoveryClient;
		@Autowired
		RestTemplate restTemplate;
		
		
		@RequestMapping("/service-instances/{applicationName}")
		public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
			return this.discoveryClient.getInstances(applicationName);
		} 

	public String bomApiCallInApigee() {
		
		// Apigee API Url
		String uri = "http://johnsoncontroll-test.apigee.net/v1/hello_policies";
		RestTemplate restTemplate = new RestTemplate();

		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result.getBytes());

		System.out.println(result);
		return result;


	}

	public String partApiCallInApigee() {
		
		// Apigee API Url
		String uri2 = "https://apidev.jci.com:10450/jcicorp/v1/paymentmanager";

		RestTemplate restTemplate = new RestTemplate();

		String result2 = restTemplate.getForObject(uri2, String.class);

		System.out.println(result2);
		return result2;

	}

	

	@Override
	public String jsonSendToStorage(HashMap<String, Object> jsonXml) {

		System.out.println("Data reach to service impl of PART-BOM ms");
		
			//sending to storage- ms
					String storageUri;
					try 
					{
					List<ServiceInstance> serviceInstance = discoveryClient.getInstances("plm-storage-ms");
					ServiceInstance bomInstance = serviceInstance.get(0);
					storageUri = "http://" + bomInstance.getHost() + ":" + Integer.toString(bomInstance.getPort())
					+ "/sendJsonStorage";
					 Map result = restTemplate.postForObject( storageUri, jsonXml , Map.class); 
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}

		
		return null;
	}

	@Override
	@HystrixCommand(fallbackMethod = "error")
	public String hystrixCircuitBreaker() {
		URI uri = URI.create("http://localhost:8090/recommended");
																	

		return this.restTemplate.getForObject(uri, String.class);
	}

	public String error() {
		System.out.println("fall back is call");
		return "fall back is call ";

	}

}
