package com.nokia.handson;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class StartTimeGx24h {

	 public static void main(String[] args) {
		
	        // Get current date in UTC (drops hours/min/sec)
	        LocalDate todayUtc = LocalDate.now(ZoneOffset.UTC);

	        // Start of the day in UTC (00:00:00Z)
	        ZonedDateTime startOfDayUtc = todayUtc.atStartOfDay(ZoneOffset.UTC);

	        // Format as required: 2025-08-17T00:00:00Z
	        String formatted = startOfDayUtc.format(DateTimeFormatter.ISO_INSTANT);
	        
	        System.out.println(formatted);

	        LocalDate yesterdayUtc = todayUtc.minusDays(1);
	        
	        ZonedDateTime startYestOfDayUtc = yesterdayUtc.atStartOfDay(ZoneOffset.UTC);

	        // Format as required: 2025-08-17T00:00:00Z
	        String formattedYest = startYestOfDayUtc.format(DateTimeFormatter.ISO_INSTANT);
	        
	        startYestOfDayUtc.toInstant().toEpochMilli();
	        
	        System.out.println(formattedYest);
	    }
}
