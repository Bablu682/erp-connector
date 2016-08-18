package com.jci.payloadprocess;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jci.payloadprocess.service.ProcessPayloadImpl;

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
@RestController
public class PLMPayloadProcessMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PLMPayloadProcessMsApplication.class, args);
	}
	
	/*@Autowired
	BomFeignClient bfClient;*/
	@Autowired
	ProcessPayloadImpl process;
	
	//the below method is called from subscriber ms 
			@RequestMapping(value = "/receiveXml", method = { RequestMethod.POST })
		    
			public  String  processPayload(@RequestBody String xmlPayload, HttpServletRequest request) 
			{
				String xml = request.getParameter("xml");
				System.out.println(xml);
				String ecnNo="1234";
				try
				{
					process.processPayload(xml, ecnNo);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return "Success Node js";
			}
	
	
	
	//the below method is called from the UI (It would be a rest call)
		@RequestMapping(value = "/Reprocess", method = { RequestMethod.GET })
		public  String  reprocessPayload(@RequestBody HashMap<String, String> hashMap) 
		{
		try
			{
			
				System.out.println("Reprocessing call");
				String completeXml=hashMap.get("completeXml");
				String ecnNo=hashMap.get("ecnNo");
				
				
				process.processPayload(completeXml, ecnNo);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}
}
