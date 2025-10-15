package com.commonadapterfw;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Dom {

    public static void main(String[] args) {
        try {
            // Specify the path to your XML file
            String filePath = "student.xml";

            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and get the Document object
            Document document = builder.parse(new File(filePath));

            // Normalize the document to handle whitespaces
//            document.getDocumentElement().normalize();

            // Get all elements by tag name
            NodeList nodeList = document.getElementsByTagName("*");
            
            // Iterate over the NodeList and print the values
            System.out.println(nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                
                // Check if the node is an element
                if ((node.getNodeType() == Node.ELEMENT_NODE)) {
                    System.out.println(node.getNodeName() + ": " + node.getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
