package com.commonadapterfw;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import org.json.JSONObject;

public class PmJsonTrail {
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
//		System.out.println(new Date(Long.parseLong("1701438430000000000")));
		
//		
//		 	LocalDateTime currentDateTime = LocalDateTime.now();
//	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
//	        String formattedDateTime = currentDateTime.format(formatter);
//	        System.out.println(formattedDateTime);
//	        System.out.println(Instant.parse(formattedDateTime).getEpochSecond()); 
		
		
	        
	        
//	        long nanosecondsTimestamp = 1667287540000000000L;
//	        long secondsTimestamp = nanosecondsTimestamp / 1_000_000_000;
//
//	        // Convert seconds to Instant
//	        Instant instantFromNanoseconds = Instant.ofEpochSecond(secondsTimestamp);
//
//	        // Display the timestamp in seconds format
//	        System.out.println(secondsTimestamp);
//
//	        // Display the Instant in nanoseconds format
//	        System.out.println(instantFromNanoseconds.toEpochMilli()); // Convert to milliseconds
		
		
		
		long secondsTimestamp = 1701685020000000000L/1_000_000_000;

        // Convert seconds to Instant
        Instant instant = Instant.ofEpochSecond(secondsTimestamp);

        // Format the Instant in UTC
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withZone(ZoneOffset.UTC);

        // Format and display the timestamp in UTC
        String formattedTimestamp = formatter.format(instant);
        System.out.println(formattedTimestamp);
        
        
        long nanoseconds = 1701438430123456789L;

        // Convert nanoseconds to seconds 1701438430
        long seconds = Duration.ofNanos(nanoseconds).getSeconds();

        System.out.println("Nanoseconds: " + nanoseconds);
        System.out.println("Seconds: " + seconds);
        
        
        List<String> ls = new ArrayList<>();
        
        ls.add("");
        
        System.out.println(ls.get(0).isEmpty());
        
//        Boolean errorFlag = false;
		
        AtomicBoolean errorFlag = new AtomicBoolean(false);
        
        set(errorFlag);
		
        System.out.println(errorFlag.get());
        
        String cmdResponse = "asdasd: sampleInterval: 20ms, abcdccc,asd : sada";
        System.out.println(cmdResponse.substring(cmdResponse.indexOf("sampleInterval: "), cmdResponse.indexOf(",")));
	}
	
	public static void set(AtomicBoolean f) {
		f.set(true);
	}
	

}
