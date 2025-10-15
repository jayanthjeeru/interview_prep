package com.commonadapterfw;

import org.w3c.dom.Element;

import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Xpath {

    public static void main(String[] args) {
        try {
            // Specify the path to your XML file
            String filePath = "student.xml";

            // Specify the XPath expression (path)
            String xPathExpression = "optical-amplifier/amplifiers/amplifier/state/name";

//            int parentLevel = xPathExpression.split("/amplifier/")[1].split("/").length;
//            
//            System.out.println(parentLevel);
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and get the Document object
            Document document = builder.parse(filePath);

            // Create an XPathFactory
            XPathFactory xPathFactory = XPathFactory.newInstance();

            // Create an XPath object
            XPath xpath = xPathFactory.newXPath();

            // Compile the XPath expression
            XPathExpression expr = xpath.compile(xPathExpression);

           
            // Evaluate the XPath expression against the Document
            NodeList nodeList = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            // Iterate through the NodeList and print values
            for (int i = 0; i < nodeList.getLength(); i++) {
            	
            	
//            	Element e  = (Element) nodeList.item(i);
//            		
//            	for(int j=0;!e.getNodeName().equals("optical-amplifier");j++) {
//            		e = (Element) e.getParentNode();
////            		System.out.println(e.getNodeName());
//            	}
//            	Element e1 = (Element) e.getElementsByTagName("amplifiers").item(0);
//            	Element e3 = (Element) e.getElementsByTagName("amplifier").item(0);
//            	System.out.println(e3.getElementsByTagName("name").item(0).getTextContent());
//            	System.out.println(e.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Value " + (i + 1) + nodeList.item(i).getNodeName()+ ": " + nodeList.item(i).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
