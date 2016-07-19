package com.jci.jciPLMMQSubcriber.service;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Properties;

import javax.json.Json;
import javax.json.JsonObject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.google.gson.Gson;
import com.microsoft.windowsazure.Configuration;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.services.serviceBus.models.ReceiveMessageOptions;
import com.microsoft.windowsazure.services.serviceBus.models.ReceiveMode;
import com.microsoft.windowsazure.services.servicebus.ServiceBusConfiguration;
import com.microsoft.windowsazure.services.servicebus.ServiceBusContract;
import com.microsoft.windowsazure.services.servicebus.ServiceBusService;
import com.microsoft.windowsazure.services.servicebus.models.BrokeredMessage;
import com.microsoft.windowsazure.services.servicebus.models.ReceiveQueueMessageResult;

@Service
public class AzureServiceBusContractService {

	private static String namespace = "";
	private static String sasPolicyKeyName = "";
	private static String sasPolicyKey = "";
	private static String serviceBusRootUri = "";
	private static String queueName = "";
	public static String completeXml="";
	public static String completeXml1="";

	public ServiceBusContract azureConnectionSetup() throws IOException {
		// Retrieve the connection string
		Properties prop = new Properties();
		try {
			InputStream propertyStream = AzureServiceBusContractService.class.getClassLoader()
					.getResourceAsStream("config.properties");
			if (propertyStream != null) {
				prop.load(propertyStream);
			} else {
				throw new RuntimeException();
			}
		} catch (IOException e) {
			System.out.println("\nFailed to load config.properties file.");
			throw e;
		} catch (RuntimeException e) {
			System.out.println("\nFailed to load config.properties file.");
			throw e;
		}
		namespace = prop.getProperty("namespace") == null ? "sbplmdev" : prop.getProperty("namespace");
		sasPolicyKeyName = prop.getProperty("sasPolicyKeyName") == null ? "RootManageSharedAccessKey"
				: prop.getProperty("sasPolicyKeyName");
		sasPolicyKey = prop.getProperty("sasPolicyKey") == null ? "Y3X4ESQe5yP6ZOmz7zB3rbTgRUSEPlvRyLy9LgTbGls="
				: prop.getProperty("sasPolicyKey");
		serviceBusRootUri = prop.getProperty("serviceBusRootUri") == null ? ".servicebus.windows.net"
				: prop.getProperty("serviceBusRootUri");
		queueName = prop.getProperty("queueName") == null ? "sbqplmdev" : prop.getProperty("queueName");
		Configuration config = ServiceBusConfiguration.configureWithSASAuthentication(namespace, sasPolicyKeyName,
				sasPolicyKey, serviceBusRootUri);
		ServiceBusContract service = ServiceBusService.create(config);
		return service;
	}

	public boolean azureMessagePublisher(ServiceBusContract service, String message) {

		try {
			BrokeredMessage brokeredMessage = new BrokeredMessage(message);
			service.sendQueueMessage(queueName, brokeredMessage);
		} catch (ServiceException e) {
			System.out.print("ServiceException encountered: ");
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		return true;

	}

	public String azureMessageSubscriber(ServiceBusContract service) {

		try {
			ReceiveMessageOptions opts = ReceiveMessageOptions.DEFAULT;
			opts.setReceiveMode(ReceiveMode.PEEK_LOCK);
			while (true) {
				ReceiveQueueMessageResult resultQM = service.receiveQueueMessage(queueName);
				BrokeredMessage message = resultQM.getValue();
				if (message != null && message.getMessageId() != null) {
					System.out.println("MessageID: " + message.getMessageId());

					// Display the queue message.
					System.out.print("From queue: ");
					byte[] b = new byte[2000];
					String s = null;
					int numRead = message.getBody().read(b);
					while (-1 != numRead) {
						s = new String(b);
						s = s.trim();

						numRead = message.getBody().read(b);
						completeXml = completeXml + s;
						s=null;
					}
					// completeXml have entire xml as a String which is coming
					// from azure service bus
					// temp solution for retrieving appropriate xml
					
					int index=completeXml.lastIndexOf("</COLLECTION>");
					index=index+ 13;
					completeXml=completeXml.substring(0, index);
					
					System.out.println(completeXml);
					
					// Converting the retrieve XML into JSON
					System.out.println("The json is formed");
					org.json.JSONObject jsonXML = XML.toJSONObject(completeXml);
					System.out.println(jsonXML);
					
					System.out.println("Custom Property: " + message.getProperty("MyProperty"));
					// Remove message from queue.
					System.out.println("Deleting this message.");
					// service.deleteMessage(message);
				} else {
					System.out.println("Finishing up - no more messages.");
					break;
					// Added to handle no more messages.
					// Could instead wait for more messages to be added.
				}
			}
			 return "success in retreiving the message from SB";
			 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("Generic exception encountered: ");
			System.out.println(e.getMessage());
			return "failure in retreiving the message from SB";
		}

	}
	
	/*// written for changes 
	public String azureMessageSubscriber1(ServiceBusContract service){
		try {
		ReceiveMessageOptions opts = ReceiveMessageOptions.DEFAULT;
		opts.setReceiveMode(ReceiveMode.PEEK_LOCK);
		while (true) {
			ReceiveQueueMessageResult resultQM = service.receiveQueueMessage(queueName);
			BrokeredMessage message = resultQM.getValue();
			if (message != null && message.getMessageId() != null) {
				System.out.println("MessageID: " + message.getMessageId());
				System.out.println("Message"+message.getContentType());
				System.out.println("Available "+message.getBody().available());
				System.out.println(message.getBody().read());
				
				byte[] b = new byte[2000];
				
				String s = null;
				int numRead = message.getBody().read(b);
				while (-1 != numRead) 
				{
					s = new String(b);
					s = s.trim();
					numRead = message.getBody().read(b);
					completeXml = completeXml + s;
					s = null;
					
				}
				System.out.println(completeXml);
				// completeXml have entire xml as a String which is coming
				// from azure service bus
				
				// temp solution for retrieving appropriate xml
				
				int index=completeXml.lastIndexOf("</COLLECTION>");
				index=index+ 13;
				completeXml=completeXml.substring(0, index);
				
				//the < char was truncating automatically at the starting of the XML so adding it
				StringBuffer sb = new StringBuffer(completeXml);
			    sb.insert(0,"<");
				System.out.println(sb);
			    
			    
				//written to check how it looks when we insert it into the file
				PrintWriter out = new PrintWriter("filename.xml");
				out.println(sb.toString());
				out.close();
				
				
				//converting to XML file
				
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			    DocumentBuilder builder;
				File file = new File("xmlFileName.xml");
				builder = factory.newDocumentBuilder();
				Document document = builder.parse( new InputSource(new StringReader( sb.toString() ) ) );
		        TransformerFactory tranFactory = TransformerFactory.newInstance();
		        Transformer aTransformer = tranFactory.newTransformer();
		        Source src = new DOMSource( document );
		        Result dest = new StreamResult( new File( "xmlFileName.xml" ) );
		        aTransformer.transform( src, dest );
		        
				// Converting the retrieve XML into JSON
				System.out.println("The json is formed");
				
				org.json.JSONObject jsonXML = XML.toJSONObject(sb.toString());
				System.out.println(jsonXML);
				
				//it is successful to convert the json but i think the format is not suitable
				Gson gson = new Gson();
				System.out.println(gson.toJson(completeXml));
	            
	           
				//converted but string dosent look good.
				ObjectMapper mapper = new ObjectMapper();
	            String jsonInString = mapper.writeValueAsString(completeXml);
	            System.out.println(jsonInString);
	            
				System.out.println("Custom Property: " + message.getProperty("MyProperty"));
				// Remove message from queue.
				System.out.println("Deleting this message.");
				// service.deleteMessage(message);
			} else {
				System.out.println("Finishing up - no more messages.");
				// Added to handle no more messages.
				// Could instead wait for more messages to be added.
			}
		}
		// return "success in retrieving the message from SB";
		 
	} 
		catch (Exception e) {
		e.printStackTrace();
		System.out.print("Generic exception encountered: ");
		System.out.println(e.getMessage());
		return "failure in retreiving the message from SB";
	}
	}
*/	
	
}
