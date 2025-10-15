package com.commonadapterfw;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Dom {
	public static void main(String[] args) {

		try {
			File inputFile = new File("student.txt"); // input file
			// reading and analyzing the input file
			// creating the DocumentBuilder using the DocumentBuilder clad and
			// DocumentBuilderFactory class
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse(inputFile);
			d.getDocumentElement().normalize();
			System.out.println("Root element :" + d.getDocumentElement().getNodeName());
			NodeList nl = d.getElementsByTagName("student");
			System.out.println("----------------------------"+nl.getLength());
				// printing the components of the file  
			for (int i = 0; i < nl.getLength(); i++) {
				Node n = nl.item(i);
				System.out.println("\nCurrent Element :" + n.getNodeName());

				if (n.getNodeType() == Node.ELEMENT_NODE) {
					// Extracting the root elements
					Element e = (Element) n;
//					Document dd = (Document) e;
					System.out.println(">>>>"+n.getTextContent());
					// Analysing the attributes
					System.out.println("Student roll no : " + e.getAttribute("rollno"));
					System.out.println("First Name : " + e.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name : " + e.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Nick Name : " + e.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Marks : " + e.getElementsByTagName("marks").item(0).getTextContent());
					if(e.getElementsByTagName("pu").item(0)!=null)
						System.out.println("pu : "+ e.getElementsByTagName("pu").item(0).getTextContent());
					
				}
			}
		} catch (Exception z) {
			z.printStackTrace();
		}
	}
}
