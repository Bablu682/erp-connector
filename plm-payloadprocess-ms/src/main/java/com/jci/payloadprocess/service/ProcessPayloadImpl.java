package com.jci.payloadprocess.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ProcessPayloadImpl implements ProcessPayload{
	
	
	@LoadBalanced
	  @Bean
	  RestTemplate restTemplate(){
	    return new RestTemplate();
	  }
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	BomFeignClient bfClient;
	@Autowired
	StorageFeignClient sfClient;
	
	public static String payLoadType = "";
	public static int reprocess;
	
	
	@Override
	public String processPayload(String completeXml,String ecnNo)
	{
		try
		{
			if(ecnNo!=null)
			{
				reprocess=1;
			}
			else
			{
				reprocess=0;
			}
			
			System.out.println("processpayload() is executed . . . . . . .");
			System.out.println("value of ecnNo is    " + ecnNo);
			
			
		File file = new File("Payload.xml");

		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(completeXml);
		bw.close();
		
		
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer = tFactory
				.newTransformer(new javax.xml.transform.stream.StreamSource("input.xsl"));
		transformer.transform(new javax.xml.transform.stream.StreamSource("Payload.xml"),
				new javax.xml.transform.stream.StreamResult(new FileOutputStream("Payload_XSLT_Out.xml")));

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		InputStream inputStream = new FileInputStream(new File("Payload_XSLT_Out.xml"));
		org.w3c.dom.Document doc = documentBuilderFactory.newDocumentBuilder().parse(inputStream);
		StringWriter xsltXML = new StringWriter();
		Transformer serializer = TransformerFactory.newInstance().newTransformer();
		serializer.transform(new DOMSource(doc), new StreamResult(xsltXML));
		
		JSONObject infoJson = new JSONObject();
		infoJson.put("ecnNo", ecnNo);
		infoJson.put("reprocess", reprocess);
				
		
		//sending XML to Storage client
		sfClient.sendData(xsltXML.toString());   // do we also need to send the ecn number and isProcessed to storage microservice
		
		
		org.json.JSONObject payloadJsonXml = XML.toJSONObject(xsltXML.toString()); 
		
		
		org.json.JSONObject collectionPayload = (JSONObject)payloadJsonXml.get("COLLECTION");
		
		//sending to partbom ms using feign client
		HashMap<String , Object> hashMap = new HashMap<>();
		hashMap.put("json", infoJson.toString());
		hashMap.put("bom", collectionPayload.get("BOMCOMPONENTS-BOMCOMPONENTS").toString());
		hashMap.put("part", collectionPayload.get("PARTS-PARTS").toString());
		bfClient.sendData2(hashMap);
		
		
		
		//implementing rest template
		/*URI uri = new URI("http://10.109.218.70:9090/receiveJson");
		MultiValueMap<String, Object> mvm = new LinkedMultiValueMap<String, Object>();
	    mvm.add("json", obj.toString());
	    mvm.add("bom", collectionPayload.get("BOMCOMPONENTS-BOMCOMPONENTS")); 
	    mvm.add("part", collectionPayload.get("PARTS-PARTS"));*/
		
		/*URI uri = new URI("http://10.109.218.70:9898/receiveJson");
		MultiValueMap<String, Object> mvm = new LinkedMultiValueMap<String, Object>();
	    mvm.add("json", "this is json");
	    mvm.add("bom", "this is bom json"); 
	    mvm.add("part", "this is part json");
	    Map result = restTemplate.postForObject(uri, mvm, Map.class);*/
		
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	
}
