package util;

import java.io.*;
import java.time.LocalDateTime;

public class LoggerUtil {
    private static final String LOG_FILE = "library_log.txt";

    public static void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(LocalDateTime.now() + ": " + message);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to log: " + e.getMessage());
        }
    }

    public static void readLogs() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading log: " + e.getMessage());
        }
    }
}
