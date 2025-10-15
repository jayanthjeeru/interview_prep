package com.commonadapterfw;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SystemResourcesMonitor {
	
	  public static void main(String[] args) {
	        // Get the Operating System MXBean
	        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
	 
	        // Get the Memory MXBean
	        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
	 
	        // Get memory usage information
	        MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
	        MemoryUsage nonHeapMemoryUsage = memoryBean.getNonHeapMemoryUsage();
	 
	        // Get CPU usage (only available in some JVM implementations)
	        double systemLoadAverage = osBean.getSystemLoadAverage(); // System load average for the last minute
	        int availableProcessors = osBean.getAvailableProcessors(); // Number of processors
	 
	        
	        
	        // Print memory usage
//	        System.out.println("Heap Memory Usage:");
	        
	        
//	        System.out.println("  Used: " + heapMemoryUsage.getUsed() + " bytes");
//	        System.out.println("  Committed: " + heapMemoryUsage.getCommitted() + " bytes");
//	        System.out.println("  Max: " + heapMemoryUsage.getMax() + " bytes");
	        
	        System.out.println(Runtime.getRuntime().freeMemory() +" \t \t " + Runtime.getRuntime().totalMemory() +" \t \t "+ Runtime.getRuntime().maxMemory());
	        
	        Map<String, String> map  = new HashMap<>();
	        map.put("so", "ss");
	        map.put("so1", "ss");
	        map.put("so2", "ss");
	        map.put("so3", "ss");
	        
	        String s= "hi";
	        System.out.println(Runtime.getRuntime().freeMemory() +" \t \t " + Runtime.getRuntime().totalMemory() +" \t \t "+ Runtime.getRuntime().maxMemory());
	        
			ArrayList<Integer> arrayList = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				arrayList.add(i);
				System.out.println(i + " \t " + Runtime.getRuntime().freeMemory() + " \t \t "
						+ Runtime.getRuntime().totalMemory() + " \t \t " + Runtime.getRuntime().maxMemory());
			}
	        
//	        System.out.println();
//	        System.out.println("  Used: " + heapMemoryUsage.getUsed() + " bytes");
//	        System.out.println("  Committed: " + heapMemoryUsage.getCommitted() + " bytes");
//	        System.out.println("  Max: " + heapMemoryUsage.getMax() + " bytes");
	 
	        System.out.println();
	        
//	        System.out.println("Non-Heap Memory Usage:");
//	        System.out.println("  Used: " + nonHeapMemoryUsage.getUsed() + " bytes");
//	        System.out.println("  Committed: " + nonHeapMemoryUsage.getCommitted() + " bytes");
//	        System.out.println("  Max: " + nonHeapMemoryUsage.getMax() + " bytes");
	        
	        
	      
	        
	       
	 
	        // Print CPU usage
	        System.out.println("CPU Usage:");
	        System.out.println("  System Load Average: " + systemLoadAverage);
	        System.out.println("  Available Processors: " + availableProcessors);
	    }

}

