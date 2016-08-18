package com.jci.partbom;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jci.partbom.feignclient.PLMStorageFeignClient;
import com.jci.partbom.service.PLMPartBomService;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class PLMPartBomApplication {
	public static void main(String[] args) {

		SpringApplication.run(PLMPartBomApplication.class, args);

	}

	@Autowired
	private PLMPartBomService partbomservice;
	/*
	 * @Autowired PLMStorageBomConnFeignClient client;
	 */

	@RequestMapping(value = "/bomcall")
	public String bomApiCallInApigee() {

		String name = partbomservice.bomApiCallInApigee();
		return name;

	}

	@RequestMapping(value = "/partcall")
	public String partApiCallInApigee() {

		String name = partbomservice.partApiCallInApigee();
		return name;

	}

	@RequestMapping(value = "/receiveJson", method = { RequestMethod.POST })
	public String jsonRecieveAndSend(@RequestBody HashMap<String, Object> jsonXml) throws Exception {

		System.out.println("Data reach at Bom ms from subcriber ms");
		System.out.println("===================PART=======================");
		System.out.println(jsonXml.get("part"));
		System.out.println("===================BOM=======================");
		System.out.println(jsonXml.get("bom"));
		System.out.println("===================JSON=======================");
		System.out.println(jsonXml.get("json"));

		 partbomservice.jsonSendToStorage(jsonXml);

		return " Successs fully send data to Storage Ms ";

	}

	// code get from scheduler
	/*
	 * @RequestMapping(value="/bom", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public String bomNode(HttpServletRequest request,
	 * HttpServletResponse response){
	 * System.out.println(request.getParameter("bomObj"));
	 * System.out.println(request.getContentType()); return "bom response"; }
	 */
}
