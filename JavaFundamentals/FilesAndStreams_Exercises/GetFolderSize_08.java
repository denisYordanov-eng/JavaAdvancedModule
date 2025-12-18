package FilesAndStreams_Exercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class GetFolderSize_08 {
    public static void main(String[] args) throws IOException {
        String input = "C:\\Users\\Laptop\\Downloads\\08. Java-Advanced-Files-and-Streams-Lab-Resources";
        Path path = Paths.get(input);
        try (Stream<Path> lines = Files.walk(path)) {
            long filesSize = lines
                    .filter(f -> f.toFile().isFile())
                    .mapToLong(s -> s.toFile().length())
                    .sum();

            System.out.printf("Folder size: %d\n", filesSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

