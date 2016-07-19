package com.jci.jciPLMMQSubcriber.controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.jci.jciPLMMQSubcriber.domain.PLMXmlObjects;
import com.jci.jciPLMMQSubcriber.service.AzureBlobStorageService;
import com.jci.jciPLMMQSubcriber.service.AzureServiceBusContractService;
import com.jci.jciPLMMQSubcriber.service.AzureStorageTableService;
import com.jci.jciPLMMQSubcriber.service.AzureXMLParserService;
import com.microsoft.windowsazure.services.servicebus.ServiceBusContract;
import com.microsoft.windowsazure.services.table.client.CloudTableClient;

/**
 * 
 * @author cups
 *
 */
@RestController
public class PLMERPController {

	private static Logger logger = LoggerFactory.getLogger(PLMERPController.class);
	@Autowired
	private AzureServiceBusContractService azureSBCService;

	@Autowired
	private AzureStorageTableService azureSTService;

	@Autowired
	private AzureXMLParserService azureXMLParserService;
	
	@Autowired
	private AzureBlobStorageService azureBlobStorageService;

	/**
	 * Azure Service Bus
	 * 
	 * @return
	 * @throws IOException
	 * @throws TransformerException 
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 */
	@RequestMapping("/AzureSB")
	public String azureSB() throws IOException, TransformerException, SAXException, ParserConfigurationException {
		ServiceBusContract service = azureSBCService.azureConnectionSetup();
		if (service != null) {
			
			//following part is added later
			
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			InputStream inputStream = new FileInputStream(
					new File("C:/Users/cdeshma2/Desktop/ESI Response Files/ESIResponse_5.xml"));
			org.w3c.dom.Document doc = documentBuilderFactory.newDocumentBuilder().parse(inputStream);
			StringWriter stw = new StringWriter();
			Transformer serializer = TransformerFactory.newInstance().newTransformer();
			serializer.transform(new DOMSource(doc), new StreamResult(stw));
			//stw.toString();
			//above part is added later
			
			if (azureSBCService.azureMessagePublisher(service, stw.toString())) {
				return azureSBCService.azureMessageSubscriber(service);     
				
//				return null;
			} else {
				return "publisher did not publish message to the queue";
			}

		} else {
			System.out.println("Service object returned to controller was null");
			return "Service object returned to controller was null";
		}

	}

	/**
	 * Azure Storage Table
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/AzureST")
	public String azureST() throws IOException {
		CloudTableClient tableClient = null;
		try {
			tableClient = azureSTService.getTableClientReference();
		} catch (InvalidKeyException | RuntimeException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (tableClient != null) {

			boolean createTable = azureSTService.createAzureTableIfNotExists(tableClient, "sample");
			if (createTable) {
				// return azureSBCService.azureMessageSubscriber(service);
				// Adding a entity to table
				// azureSTService.insertAzureTableEntity(tableClient, "sample");
				// System.out.println("entity created successfully");
				// return "entity created successfully";
				azureSTService.readAzureTableEntityList(tableClient, "sample");
				System.out.println("table entities read successfully");
			} else {
				// return "Enity addition to table " + "sample" + "failed";
				// System.out.println("entity creation failed");
				System.out.println("table entities read failed");
			}
			// Deleting a entity from table
			/*
			 * boolean deleteEntity =
			 * azureSTService.deleteAzureTableEntity(tableClient, "sample"); if
			 * (deleteEntity) { System.out.println("Entity deleted"); } else {
			 * System.out.println("Entity deletion failed"); }
			 */

			// Updating an entity in table
			boolean updateEntity = azureSTService.updateAzureTableEntity(tableClient, "sample");
			if (updateEntity) {
				System.out.println("Entity updated");
			} else {
				System.out.println("Entity updation failed");
			}

		} else {
			System.out.println("Table client returned to controller was null");
			return "Table client returned to controller was null";
		}
		return "check logs";
	}

	/**
	 * XML Parser
	 * 
	 * @return
	 * @throws IOException
	 * @throws JAXBException
	 */
	@RequestMapping("/AzureXMLParser")
	@ResponseBody
	public PLMXmlObjects azureXMLParser() throws IOException, JAXBException {
	//	File file = new File("C:\\eclipse\\workspace\\PLMMQSubcriber\\src\\main\\resources\\samplemessage.xml");

		/*
		 * PLMXmlObjects xmlObj = azureXMLParserService.sliceXML(file); return
		 * xmlObj;
		 */

		// PLMXmlObjects xmlObjects = null;
//		System.out.println("file name: " + file.getName());
		System.out.println("dummy");
		JAXBContext jaxbContext = JAXBContext.newInstance(PLMXmlObjects.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		PLMXmlObjects xmlObjects = (PLMXmlObjects) jaxbUnmarshaller
				.unmarshal(new File("C:\\Users\\cups\\samplemessage.xml"));
		// System.out.println(xmlObjects.getAdd_opr_bom_allocated_parts());
		// System.out.println(xmlObjects.getAdded_parts());
		return xmlObjects;

	}

	/*
	 * Logger testing
	 * 
	 */
	@RequestMapping(value = "/Logging")
	public String sampleLog() {
		logger.debug("This is PLMERPController debug message");
		logger.info("This is PLMERPController info message");
		logger.warn("This is PLMERPController warn message");
		logger.error("This is PLMERPController error message");
		return "logfile";
	}
	
	/**
	 * Azure Blob Storage
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/AzureBlobStorage")
	public String azureBlobStorage() throws IOException {
		return null;
		
	}

}
