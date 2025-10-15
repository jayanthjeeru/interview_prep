package com.commonadapterfw;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Writter {

	public static void main(String[] args) {
		BufferedWriter writer =null;
		try {
        	writer = new BufferedWriter(new FileWriter("amptesting.txt"));

        	for(int i=100;i<=4100;i++) {
        		String s= "<amplifier>\r\n"
            			+ "			<name>AMPLIFIER-1-1-2-EGR1-C</name>\r\n"
            			+ "			<config>\r\n"
            			+ "				<name>AMPLIFIER-1-1-2-EGR1-C</name>\r\n"
            			+ "				<target-gain>25.0</target-gain>\r\n"
            			+ "				<target-gain-tilt>0.0</target-gain-tilt>\r\n"
            			+ "				<amp-mode>CONSTANT_GAIN</amp-mode>\r\n"
            			+ "				<enabled>true</enabled>\r\n"
            			+ "			</config>\r\n"
            			+ "			<state>\r\n"
            			+ "				<name>AMPLIFIER-1-1-2-EGR1-C</name>\r\n"
            			+ "				<type>EDFA</type>\r\n"
            			+ "				<target-gain>25.0</target-gain>\r\n"
            			+ "				<target-gain-tilt>0.0</target-gain-tilt>\r\n"
            			+ "				<amp-mode>CONSTANT_GAIN</amp-mode>\r\n"
            			+ "				<enabled>true</enabled>\r\n"
            			+ "				<component>CARD-1-1-2</component>\r\n"
            			+ "				<egress-port>PORT-1-1-2-REPLACEMENT</egress-port>\r\n"
            			+ "			</state>\r\n"
            			+ "		</amplifier>";
        		writer.append(s.replace("REPLACEMENT", i+""));
        	}
        	
        	writer.close();
        	
        	String content = new String(Files.readAllBytes(Paths.get("amptesting.txt")));
        	System.out.println(content.contains("PORT-1-1-2-4101"));
        	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
