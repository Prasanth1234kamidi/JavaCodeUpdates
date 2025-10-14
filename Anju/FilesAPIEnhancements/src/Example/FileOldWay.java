package Example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileOldWay
{
	public static void main(String[] args) throws IOException {
        Path path = Paths.get("sample.txt");

        // Writing (old way)
        Files.write(path, "Hello, Java 9+ ".getBytes());

        // Reading (old way)
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            System.out.println(line);
        }
    }


}
