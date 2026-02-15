package File.Serialization;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class DirectoryWalker {

    public static void main(String[] args) {

        Path startPath = Path.of("C:\\Users\\hp\\OneDrive\\Documents"); // change path

        try (Stream<Path> paths = Files.walk(startPath)) {

            paths
                    .filter(Files::isRegularFile)   // only files
                    .forEach(path -> {
                        try {
                            long size = Files.size(path);
                            System.out.println(path + " -> " + size + " bytes");
                        } catch (IOException e) {
                            System.out.println("Cannot read file: " + path);
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
