package com.commonadapterfw;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XPathExample {

    public static void main(String[] args) {
        try {
            // Load XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("student.xml");

            // Create XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();

            // Define XPath expression to select all elements
            XPathExpression expr = xPath.compile("optical-amplifier/amplifiers/amplifier/state//*");

            // Evaluate the XPath expression against the document
            NodeList nodeList = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            // Iterate through the NodeList and print values along with their XPath
            for (int i = 0; i < nodeList.getLength(); i++) {
                String xpath = getXPath(nodeList.item(i));
                String value = nodeList.item(i).getTextContent().trim();
                System.out.println("XPath: " + xpath + ", Value: " + value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to get XPath of a Node
    private static String getXPath(org.w3c.dom.Node node) {
        org.w3c.dom.Node parent = node.getParentNode();
        if (parent == null) {
            return node.getNodeName();
        }
        return getXPath(parent) + "/" + node.getNodeName();
    }
}
