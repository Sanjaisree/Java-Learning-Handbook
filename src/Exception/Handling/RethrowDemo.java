package Exception.Handling;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class DataProcessingException extends RuntimeException {

    public DataProcessingException(String message, Throwable cause) {
        super(message, cause);  // Preserve original exception
    }
}


class FileProcessor {

    public void processFile(String fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            System.out.println(br.readLine());

        } catch (IOException e) {

            // Wrap and rethrow
            throw new DataProcessingException(
                    "Error processing data file",
                    e
            );
        }
    }
}

public class RethrowDemo {

    public static void main(String[] args) {

        FileProcessor processor = new FileProcessor();

        processor.processFile("missing.txt");
    }
}
