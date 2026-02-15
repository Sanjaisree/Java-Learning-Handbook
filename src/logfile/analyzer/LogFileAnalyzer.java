package logfile.analyzer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogFileAnalyzer {

    private static final String FILE_NAME = "server_log.txt";

    public static void main(String[] args) throws IOException {

        generateDummyLogFile(10_000);

        try (Stream<String> lines = Files.lines(Paths.get(FILE_NAME))) {

            List<String> logLines = lines.collect(Collectors.toList());

            // 1️⃣ Count total requests per IP
            Map<String, Long> requestsPerIP =
                    logLines.stream()
                            .map(line -> line.split(" "))
                            .collect(Collectors.groupingBy(
                                    parts -> parts[0],
                                    Collectors.counting()
                            ));

            System.out.println("Total Requests Per IP:");
            requestsPerIP.forEach((ip, count) ->
                    System.out.println(ip + " -> " + count));

            // 2️⃣ Top 3 most requested URLs
            Map<String, Long> urlCount =
                    logLines.stream()
                            .map(line -> line.split(" ")[3])
                            .collect(Collectors.groupingBy(
                                    Function.identity(),
                                    Collectors.counting()
                            ));

            System.out.println("\nTop 3 URLs:");
            urlCount.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .limit(3)
                    .forEach(entry ->
                            System.out.println(entry.getKey() + " -> " + entry.getValue()));

            // 3️⃣ Percentage of 404 errors
            long totalRequests = logLines.size();

            long error404Count =
                    logLines.stream()
                            .map(line -> line.split(" ")[2])
                            .filter(status -> status.equals("404"))
                            .count();

            double errorPercentage =
                    (error404Count * 100.0) / totalRequests;

            System.out.printf("\n404 Error Percentage: %.2f%%\n", errorPercentage);
        }
    }

    private static void generateDummyLogFile(int lines) throws IOException {

        List<String> urls = List.of(
                "/home", "/login", "/dashboard",
                "/products", "/cart", "/checkout",
                "/profile", "/search"
        );

        List<Integer> statusCodes = List.of(200, 201, 400, 401, 403, 404, 500);

        Random random = new Random();

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_NAME))) {

            for (int i = 0; i < lines; i++) {

                String ip = "192.168." + random.nextInt(5) + "." + random.nextInt(255);
                String timestamp = LocalDateTime.now().minusSeconds(random.nextInt(100000)).toString();
                int status = statusCodes.get(random.nextInt(statusCodes.size()));
                String url = urls.get(random.nextInt(urls.size()));

                writer.write(ip + " " + timestamp + " " + status + " " + url);
                writer.newLine();
            }
        }

        System.out.println("Dummy log file generated: " + FILE_NAME);
    }
}

