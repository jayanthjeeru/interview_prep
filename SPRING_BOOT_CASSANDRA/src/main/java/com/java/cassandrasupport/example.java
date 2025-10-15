package com.java.cassandrasupport;

import java.io.*;
import java.util.*;

public class example {
    private static final String PREFIX = "PMDC-";
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        // Step 1: Get the number of instances and create files
        System.out.print("Enter number of PMDC instances: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<String> instances = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            instances.add(PREFIX + (char) ('A' + i));
        }

        // Initialize files with empty data
        initializeFiles(instances);
        
        while (true) {
            System.out.print("Enter NEID and number of ports (or -1 -1 to exit): ");
            int neid = scanner.nextInt();
            int ports = scanner.nextInt();
            
            if (neid == -1 && ports == -1) {
                System.out.println("Exiting program.");
                break;
            }

            allocateToLeastLoadedInstance(instances, neid, ports);
        }
        
        scanner.close();
    }

    private static void initializeFiles(List<String> instances) throws IOException {
        for (String instance : instances) {
            File file = new File(instance + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
        }
    }

    private static void allocateToLeastLoadedInstance(List<String> instances, int neid, int ports) throws IOException {
        Map<String, Integer> instancePortCount = new TreeMap<>(); // TreeMap keeps keys sorted alphabetically

        // Read all instance files and sum the number of ports
        for (String instance : instances) {
            File file = new File(instance + ".txt");
            int totalPorts = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        totalPorts += Integer.parseInt(parts[1]);
                    }
                }
            }
            instancePortCount.put(instance, totalPorts);
        }

        // Find the least loaded instance (prioritizing alphabetically in case of ties)
        String targetInstance = Collections.min(instancePortCount.entrySet(), Map.Entry.comparingByValue()).getKey();

        // Append new entry to the selected file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetInstance + ".txt", true))) {
            writer.write(neid + ":" + ports);
            writer.newLine();
        }

        // Print allocation result
        System.out.println("Allocated NEID " + neid + " to " + targetInstance);

        // Print current state
        for (Map.Entry<String, Integer> entry : instancePortCount.entrySet()) {
            String instance = entry.getKey();
            int updatedPorts = (instance.equals(targetInstance)) ? entry.getValue() + ports : entry.getValue();
            System.out.println(instance + " total ports: " + updatedPorts);
        }
    }
}
