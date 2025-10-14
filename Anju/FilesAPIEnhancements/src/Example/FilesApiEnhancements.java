package Example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesApiEnhancements 
{
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("sample.txt");

        // Writing string to file (new in Java 11)
        Files.writeString(path, "Hello, Java 11 Files API! ");

        // Reading string from file (new in Java 11)
        String content = Files.readString(path);

        System.out.println("File Content: " + content);
    }


}
