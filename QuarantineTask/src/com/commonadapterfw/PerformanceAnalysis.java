package com.commonadapterfw;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class PerformanceAnalysis {
	public static void main(String[] args) {
		System.out.println("free mem 17:: "+(Runtime.getRuntime().freeMemory()/1000000)+" MB");
		Map<String , Map<String,String>> shelf = new HashMap<>();
		Map<String , Map<String,String>> card = new HashMap<>();
		System.out.println("free mem 20 :: "+(Runtime.getRuntime().freeMemory()/1000000)+" MB");
		try {
			File inputFile = new File("per.txt"); // input file
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse(inputFile);
			d.getDocumentElement().normalize();
			System.out.println("Root element :" + d.getDocumentElement().getNodeName());
			NodeList nl = d.getElementsByTagName("component");
			System.out.println("----------------------------"+nl.getLength());
			int cardcount = 0; 
			for (int i = 0; i < nl.getLength(); i++) {
				Node n = nl.item(i);
				if (n.getNodeType() == Node.ELEMENT_NODE) {
					// Extracting the root elements
					Element component = (Element) n;
					
//					Element state = (Element) component.getElementsByTagName("state").item(0);
//					String name = state.getElementsByTagName("name").item(0).getTextContent();
//					if(name.toLowerCase().contains("card")||name.toLowerCase().contains("chassis")) {
//						if(name.toLowerCase().contains("card")) {
//							Map<String, String> cardmap = new HashMap<>();
//							String type = state.getElementsByTagName("type").item(0).getTextContent().toLowerCase();
//							cardmap.put("type",type);
//							String parent = state.getElementsByTagName("parent").item(0).getTextContent().toLowerCase();
//							cardmap.put("parent",parent);
//							card.put(name, cardmap);
//						} else if(name.toLowerCase().contains("chassis")) {
//							Map<String, String> shelfmap = new HashMap<>();
//							String type = state.getElementsByTagName("type").item(0).getTextContent().toLowerCase();
//							shelfmap.put("type",type);
//							shelf.put(name, shelfmap);
//						}
//						System.out.println("Component Name " + state.getElementsByTagName("name").item(0).getTextContent());
					System.out.println(component.getElementsByTagName("name").item(0).getTextContent());
						cardcount++;
//					}
				}
			}
			System.out.println(cardcount);
			System.out.println(Integer.parseInt("0.0"));
		} catch (Exception z) {
			z.printStackTrace();
		}
		
		System.out.println("shelf :: "+shelf);
		System.out.println("card :: "+card);
		System.out.println("free mem 65 :: "+(Runtime.getRuntime().freeMemory()/1000000)+" MB");
	}
}
