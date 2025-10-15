package com.commonadapterfw;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.*;

import org.w3c.dom.Element;

public class XmlParser {
    public static void main(String[] args) {
    	BufferedWriter writer =null;
        try {
        	writer = new BufferedWriter(new FileWriter("device2.txt"));
            // Specify the path to your XML file
            File xmlFile = new File("components.xml");
            
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML file and create a Document object
            Document document = builder.parse(xmlFile);//new java.io.ByteArrayInputStream(xmlString.getBytes("UTF-8"))

            File inputFile = new File("amplifier.xml"); // input file
			// reading and analyzing the input file
			// creating the DocumentBuilder using the DocumentBuilder clad and
			// DocumentBuilderFactory class
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			String getAllResponsexml = "<optical-amplifier xmlns=\"http://openconfig.net/yang/optical-amplfier\"><amplifiers><amplifier><name>AMPLIFIER-1-1-2-EGR1-C</name><config><name>AMPLIFIER-1-1-2-EGR1-C</name><target-gain>25.0</target-gain><target-gain-tilt>0.0</target-gain-tilt><amp-mode>CONSTANT_GAIN</amp-mode><enabled>true</enabled></config><state><name>AMPLIFIER-1-1-2-EGR1-C</name><type>EDFA</type><target-gain>25.0</target-gain><target-gain-tilt>0.0</target-gain-tilt><amp-mode>CONSTANT_GAIN</amp-mode><enabled>true</enabled><component>CARD-1-1-2</component><egress-port>PORT-1-1-2-AD1</egress-port></state></amplifier><amplifier><name>AMPLIFIER-1-1-2-EGR1-L</name><config><name>AMPLIFIER-1-1-2-EGR1-L</name><target-gain>24.0</target-gain><target-gain-tilt>0.0</target-gain-tilt><amp-mode>CONSTANT_GAIN</amp-mode><enabled>true</enabled></config><state><name>AMPLIFIER-1-1-2-EGR1-L</name><type>EDFA</type><target-gain>24.0</target-gain><target-gain-tilt>0.0</target-gain-tilt><amp-mode>CONSTANT_GAIN</amp-mode><enabled>true</enabled><component>CARD-1-1-2</component><egress-port>PORT-1-1-2-AD1</egress-port></state></amplifier><amplifier><name>AMPLIFIER-1-1-6-ING1-C</name><config><name>AMPLIFIER-1-1-6-ING1-C</name><target-gain>16.0</target-gain><target-gain-tilt>0.0</target-gain-tilt><gain-range>LOW_GAIN_RANGE</gain-range><amp-mode>CONSTANT_GAIN</amp-mode></config><state><name>AMPLIFIER-1-1-6-ING1-C</name><type>EDFA</type><target-gain>16.0</target-gain><min-gain>10.0</min-gain><max-gain>24.0</max-gain><target-gain-tilt>0.0</target-gain-tilt><gain-range>LOW_GAIN_RANGE</gain-range><amp-mode>DYNAMIC_GAIN</amp-mode><enabled>true</enabled><component>CARD-1-1-6</component><ingress-port>PORT-1-1-6-AD1</ingress-port></state><n-o-oc-amp-ext:dynamic-gain-control xmlns:n-o-oc-amp-ext=\"http://nokia.com/yang/nokia-optics-oc-ampl-ext\"><n-o-oc-amp-ext:config><n-o-oc-amp-ext:auto-gain-adjustment-offset>0</n-o-oc-amp-ext:auto-gain-adjustment-offset><n-o-oc-amp-ext:auto-gain-adjustment-period>60</n-o-oc-amp-ext:auto-gain-adjustment-period><n-o-oc-amp-ext:gain-max-alarm-threshold>19.0</n-o-oc-amp-ext:gain-max-alarm-threshold><n-o-oc-amp-ext:gain-min-alarm-threshold>10.0</n-o-oc-amp-ext:gain-min-alarm-threshold></n-o-oc-amp-ext:config></n-o-oc-amp-ext:dynamic-gain-control></amplifier><amplifier><name>AMPLIFIER-1-1-6-ING1-L</name><config><name>AMPLIFIER-1-1-6-ING1-L</name><target-gain>16.0</target-gain><target-gain-tilt>0.0</target-gain-tilt><gain-range>LOW_GAIN_RANGE</gain-range><amp-mode>CONSTANT_GAIN</amp-mode></config><state><name>AMPLIFIER-1-1-6-ING1-L</name><type>EDFA</type><target-gain>16.0</target-gain><min-gain>10.0</min-gain><max-gain>24.0</max-gain><target-gain-tilt>0.0</target-gain-tilt><gain-range>LOW_GAIN_RANGE</gain-range><amp-mode>DYNAMIC_GAIN</amp-mode><enabled>true</enabled><component>CARD-1-1-6</component><ingress-port>PORT-1-1-6-AD1</ingress-port></state><n-o-oc-amp-ext:dynamic-gain-control xmlns:n-o-oc-amp-ext=\"http://nokia.com/yang/nokia-optics-oc-ampl-ext\"><n-o-oc-amp-ext:config><n-o-oc-amp-ext:auto-gain-adjustment-offset>0</n-o-oc-amp-ext:auto-gain-adjustment-offset><n-o-oc-amp-ext:auto-gain-adjustment-period>60</n-o-oc-amp-ext:auto-gain-adjustment-period><n-o-oc-amp-ext:gain-max-alarm-threshold>19.0</n-o-oc-amp-ext:gain-max-alarm-threshold><n-o-oc-amp-ext:gain-min-alarm-threshold>10.0</n-o-oc-amp-ext:gain-min-alarm-threshold></n-o-oc-amp-ext:config></n-o-oc-amp-ext:dynamic-gain-control></amplifier></amplifiers></optical-amplifier>";

			Document d = db.parse(new java.io.ByteArrayInputStream(getAllResponsexml.getBytes("UTF-8")));
			d.getDocumentElement().normalize();
			NodeList nl = d.getElementsByTagName("amplifier");
			System.out.println("len :: "+nl.getLength());
			Integer count = 0;
			Map<String,Integer> counter  = new HashMap<>();
			for (int i = 0; i < nl.getLength(); i++) {
				
				counter.put("count", 0);
				Node n = nl.item(i);
				XmlParser xp =new XmlParser();
				Element ee = (Element) n;
					xp.amplifierTraverse(n, "","L"); 
					System.out.println("-------------------------");
					writer.append("-----------------------------------new component-------------------------------------------\n");
				}
			
            // Traverse the XML document
			writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    private  void traverse(Node node, String xpath, BufferedWriter writer, Map<String,Integer> counter) {
        // If the current node is an element node
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            // Update the XPath with the current element
            xpath += "/" + node.getNodeName();

            // If the current element has child nodes, recursively traverse them
            NodeList childNodes = node.getChildNodes();
           
            for (int i = 0; i < childNodes.getLength(); i++) {
            	System.out.println("xpat  "+xpath);
                traverse(childNodes.item(i), xpath, writer,counter);
            }
        } else if (node.getNodeType() == Node.TEXT_NODE) {
            // If the current node is a text node (leaf node), print the XPath and its value
            String value = node.getNodeValue().trim();
           
            if (!value.isEmpty()) {
            	if(xpath.equals("/channel-monitor/channels/channel/lower-frequency")) {
            		counter.put("count", counter.get("count") + 1);
            	} 
            	if(xpath.contains("/channel-monitor/channels/channel/")) {
            		xpath = xpath +"$"+ counter.get("count");
            	}
            	
                System.out.println(xpath + " : " + value);
                
                try {
        				writer.append(xpath + " : " + value+"\n");
        			
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
                
            }
        }
        
    }
    
    private  void amplifierTraverse(Node node, String xmlPath, String amplifierType) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            xmlPath += "/" + node.getNodeName();
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
            	amplifierTraverse(childNodes.item(i), xmlPath, amplifierType);
            }
        } else if (node.getNodeType() == Node.TEXT_NODE) {
            String value = node.getNodeValue().trim();
            if (!value.isEmpty()) {
            	value = value.replace("AMPLIFIER", "PORT").replace("ING1", "LINEIN").replace("EGR1", "LINEOUT");
            	if(!amplifierType.isEmpty())
            		xmlPath = xmlPath + "/band:"+amplifierType;
                
            	System.out.println(xmlPath + " : " + value);
            }
        }
        
    }
}


