package com.jci.portal.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class PLMWebPortalServiceImpl implements PLMWebportalService
{
	
	
	
//	@LoadBalanced
	  @Bean
	  RestTemplate restTemplate(){
	    return new RestTemplate();
	  }
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	} 

	@Override
	public String reprocessRequest(String ecnNo, String completeXml) {
		
		//sending to payload-process ms
		URI partbomUri;
		try 
		{
			
				List<ServiceInstance> serviceInstance = discoveryClient.getInstances("plm-payloadprocess-ms");
				ServiceInstance bomInstance = serviceInstance.get(0);
				String urlString = "http://" + bomInstance.getHost() + ":" + Integer.toString(bomInstance.getPort())
				+ "/reprocess";
				 HashMap<String, String> mvm = new HashMap<String, String>();
				 mvm.put("ecnNo", ecnNo.toString());
			     mvm.put("completeXml", completeXml); 
						
			     Map result = restTemplate.postForObject( urlString, mvm , Map.class);
		
		       
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	
	@HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "true"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "50000000"),
            @HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout", value = "true"),
            @HystrixProperty(name = "fallback.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10"),
            @HystrixProperty(name = "circuitBreaker.forceOpen", value = "false"),
            @HystrixProperty(name = "circuitBreaker.forceClosed", value = "false") }, fallbackMethod = "error")


	public String hystrixCircuitBreaker() {
		URI uri = URI.create("http://localhost:8091/recommended");
																	

		return this.restTemplate.getForObject(uri, String.class);
	}

	public String error() {
		System.out.println("fall back is call");
		return "fall back is call ";

	}


}
