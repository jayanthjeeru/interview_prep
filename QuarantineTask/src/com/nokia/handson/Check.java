package com.nokia.handson;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Check {public static void main(String[] args) {
    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    
    System.out.println("started...");

    Runnable task = () -> {
        // Current time in IST
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Time (IST): " + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z")));

        // Round down to nearest 15-minute interval
        int minute = now.getMinute();
        int roundedMinute = (minute / 15) * 15;

        ZonedDateTime roundedIstTime = now
                .withMinute(roundedMinute)
                .withSecond(0)
                .withNano(0);

        // Subtract 15 minutes
        ZonedDateTime minus15IstTime = roundedIstTime.minusMinutes(15);

        // Convert to UTC
        ZonedDateTime roundedUtcTime = roundedIstTime.withZoneSameInstant(ZoneOffset.UTC);
        ZonedDateTime minus15UtcTime = minus15IstTime.withZoneSameInstant(ZoneOffset.UTC);

        // Formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

        // Print outputs
        System.out.println("Rounded Time (IST): " + roundedIstTime.format(formatter));
        System.out.println("Rounded Time (UTC): " + roundedUtcTime.format(formatter));
        System.out.println("Rounded -15m Time (IST): " + minus15IstTime.format(formatter));
        System.out.println("Rounded -15m Time (UTC): " + minus15UtcTime.format(formatter));
        System.out.println("-----------------------------");
    };

    long initialDelay = getInitialDelayInSeconds();
    long period = 15 * 60L; // every 15 minutes

    scheduler.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
}

private static long getInitialDelayInSeconds() {
    LocalDateTime now = LocalDateTime.now();
    int minute = now.getMinute();
    int second = now.getSecond();

    int nextQuarter = ((minute / 15) + 1) * 15;
    if (nextQuarter == 60) {
        now = now.plusHours(1).withMinute(0).withSecond(0).withNano(0);
    } else {
        now = now.withMinute(nextQuarter).withSecond(0).withNano(0);
    }

    Duration delay = Duration.between(LocalDateTime.now(), now);
    return delay.getSeconds();
}

}
