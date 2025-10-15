package com.commonadapterfw;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Stack;

public class XMLParserWithoutRecursion {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("components.xml");

            Stack<Node> stack = new Stack<>();
            stack.push(document.getDocumentElement());

            while (!stack.isEmpty()) {
                Node currentNode = stack.pop();

                if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) currentNode;

                    if (element.hasChildNodes()) {
                        NodeList children = element.getChildNodes();
                        for (int i = children.getLength() - 1; i >= 0; i--) {
                            stack.push(children.item(i));
                        }
                    } else {
                        // Leaf node, print XPath and value
                        String xpath = getXPath(currentNode);
                        String value = currentNode.getTextContent().trim();
                        System.out.println("XPath: " + xpath + ", Value: " + value);
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static String getXPath(Node node) {
        Node parent = node.getParentNode();
        if (parent == null || parent.getNodeType() == Node.DOCUMENT_NODE) {
            return "/" + node.getNodeName();
        }
        return getXPath(parent) + "/" + node.getNodeName();
    }
}
