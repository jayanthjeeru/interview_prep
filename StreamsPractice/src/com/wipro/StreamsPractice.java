package com.wipro;

import java.util.*;

public class StreamsPractice {
	
	
		public static void main(String[] args) {
	        // Initialize a list to store maps
	        List<Map<String, String>> neList = new ArrayList<>();

	        // Create some sample entries
	        Map<String, String> entry1 = new HashMap<>();
	        entry1.put("supervisionstate", "supervised");

	        Map<String, String> entry2 = new HashMap<>();
	        entry2.put("supervisionstate", "desupervised");

	        Map<String, String> entry3 = new HashMap<>();
	        entry3.put("supervisionstate", "supervised");

	        // Add entries to the list
	        neList.add(entry1);
	        neList.add(entry2);
	        neList.add(entry3);

	        // Count supervised and desupervised occurrences using streams
	        long inactiveCount = neList.stream()
	                .filter(map -> "desupervised".equals(map.get("supervisionstate")))
	                .count();

	        long activeCount = neList.stream()
	                .filter(map -> "supervised".equals(map.get("supervisionstate")))
	                .count();
	        // Output the counts
	        System.out.println("Supervised count: " + activeCount);
	        System.out.println("Desupervised count: " + inactiveCount);
	        
	        
	       
	        
	}

}
