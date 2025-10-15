package com.wipro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScriptClass {

	public static void main(String[] args) {
        try {
            // Command to execute the shell script
            String command = "C:\\Users\\jayreddy\\Documents\\scripts\\script.sh";

            // Create ProcessBuilder with the command
            ProcessBuilder pb = new ProcessBuilder(command);

            // Start the process
            Process process = pb.start();

            // Read the output of the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Script executed with exit code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
	
}
