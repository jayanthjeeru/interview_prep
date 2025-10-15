package com.wipro.vaish;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;

//@Component
public class Test {
	
	
	public static void main(String[] args) {
//		try {
//			updateFileSystemInfo("ss","sss");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		String s = "<hi sdsds> hello </hi>";
		
		System.out.println(s.indexOf("<hi"));
	}

//	public static void updateFileSystemInfo(String paramName, String paramValue) throws IOException {
//        // Shell script as a Java String (Korn shell version)
//		String scriptContent = "#!/bin/bash\n"
//                + "echo \"Running updateFileSystemInfo with $1 and $2\"\n"
//                + "echo \"Param name: $1\"\n"
//                + "echo \"Param value: $2\"\n";
//
//        // Write script to a temporary file
//        File scriptFile = File.createTempFile("updateFileSystemInfo", ".sh");
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(scriptFile))) {
//            writer.write(scriptContent);
//        }
//
//        // Make script executable
//        scriptFile.setExecutable(true);
//
//        // Execute the script with two arguments
//        Process process = Runtime.getRuntime().exec(new String[]{
//                scriptFile.getAbsolutePath(), paramName, paramValue
//        });
//
//        // Print output
//        try (BufferedReader reader = new BufferedReader(
//                new InputStreamReader(process.getInputStream()))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println("SCRIPT OUT: " + line);
//            }
//        }
//
//        // Wait for the script to finish
//        try {
//            int exitCode = process.waitFor();
//            System.out.println("Script exited with code: " + exitCode);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            throw new IOException("Interrupted while waiting for script", e);
//        }
//
//        // Optionally delete the script file after use
//        // scriptFile.delete();
//    }
}
