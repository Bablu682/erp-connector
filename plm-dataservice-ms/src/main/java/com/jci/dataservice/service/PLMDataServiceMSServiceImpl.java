package com.jci.dataservice.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@Service
public class PLMDataServiceMSServiceImpl implements PLMDataServiceMSService{
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Autowired
	RestTemplate restTemplate;
	
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
