package com.nokia.handson;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class FileWatcher {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Path to watch
        Path pathToWatch = Paths.get("C:/path/"); // <-- change this to your directory

        // Create WatchService
        WatchService watchService = FileSystems.getDefault().newWatchService();

        // Register the path with the watch service for CREATE events
        pathToWatch.register(watchService, ENTRY_CREATE);

        System.out.println("Watching directory: " + pathToWatch.toAbsolutePath());

        // Run forever
        while (true) {
            WatchKey key;
            try {
                // Wait for a watch event
                key = watchService.take();
            } catch (InterruptedException ex) {
                System.out.println("Interrupted. Exiting...");
                break;
            }

            // Process all events
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                // Overflow event (ignore or handle separately)
                if (kind == OVERFLOW) {
                    continue;
                }

                // Get the filename from the event
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path fileName = ev.context();

                System.out.println("New file created: " + fileName);
            }

            // Reset the key to continue watching
            boolean valid = key.reset();
            if (!valid) {
                System.out.println("WatchKey no longer valid. Exiting...");
                break;
            }
        }

        // Close the watch service when done (not reachable here in infinite loop)
        // watchService.close();
    }
}
