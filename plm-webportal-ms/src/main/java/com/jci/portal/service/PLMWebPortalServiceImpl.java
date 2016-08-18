package com.jci.portal.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jci.portal.dao.PLMPayloadImpl;
import com.jci.portal.dao.PLMWebPortalDaoImpl;
import com.jci.portal.domain.JCIASTSampleEntity;
import com.jci.portal.feigninterface.ReprocessFeign;

import feign.Client;

@Service
public class PLMWebPortalServiceImpl implements PLMWebPortalService {
	@Autowired
	private PLMWebPortalDaoImpl daoImpl;
	@Autowired

	ReprocessFeign feignClient;

	@Override
	@Transactional
	public HashMap<String, Object> getMessage() throws Exception {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		File xmlFile = daoImpl.getXml();
		Reader fileReader = new FileReader(xmlFile);
		BufferedReader bufReader = new BufferedReader(fileReader);
		StringBuilder sb = new StringBuilder();
		String line = bufReader.readLine();
		while (line != null) {
			sb.append(line).append("\n");
			line = bufReader.readLine();
		}
		String xml2String = sb.toString();
		System.out.println("XML to String using BufferedReader : ");
		// System.out.println(xml2String);
		bufReader.close();

		// File xmlFile = daoImpl.getXml();
		// System.out.println(xmlFile);

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(xmlFile);

		document.getDocumentElement().normalize();

		String exp = "/COLLECTION/Release/Transaction/TransactionNumber";
		XPath xPath = XPathFactory.newInstance().newXPath();
		NodeList nodeList = (NodeList) xPath.compile(exp).evaluate(document, XPathConstants.NODESET);
		Node node = nodeList.item(0);
		Element element = (Element) node;
		String result = element.getFirstChild().getTextContent();

		int ecnNo = Integer.parseInt(result);
		hashMap.put("EcnNo", ecnNo);
		hashMap.put("CompleteXml", xml2String);
		// System.out.println(hashMap);
		// return (id) ;
		// feignClient.sendData2("Xml :"+xmlFile+"TxnId :"+txnID);
		// return ("Xml :"+xmlFile+"TxnId :"+txnID);
		return hashMap;

	}

	@Override
	public String sendData2(HashMap<String, Object> hashMap) {
		feignClient.sendData2(hashMap);
		return null;
	}

	@Override
	@Transactional
	public File getXml() {
		return daoImpl.getXml();

	}

	@Override
	public List<JCIASTSampleEntity> getTotalProcessedEntities() {
		// TODO Auto-generated method stub
		return null;
	}

}
