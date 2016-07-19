package com.jci.jciPLMMQSubcriber.service;

import java.io.File;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.jci.jciPLMMQSubcriber.domain.PLMXmlObjects;

@Service
public class AzureXMLParserService {

	public PLMXmlObjects sliceXML(File file) {
		PLMXmlObjects xmlObjects = null;
		try {
			System.out.println("file name: " + file.getName());
			JAXBContext jaxbContext = JAXBContext.newInstance(PLMXmlObjects.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			xmlObjects = (PLMXmlObjects) jaxbUnmarshaller.unmarshal(file);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmlObjects;
	}

}
