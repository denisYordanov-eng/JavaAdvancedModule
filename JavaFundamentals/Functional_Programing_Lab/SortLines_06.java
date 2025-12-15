package FilesAndStreams_Lab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines_06 {
    public static void main(String[] args) throws IOException {
        Path input = Paths.get("C:\\Users\\Laptop\\Desktop\\inputToSort.txt");
        Path output = Paths.get("C:\\Users\\Laptop\\Desktop\\output.txt");

        try {
            List<String> lines = Files.readAllLines(input);
            Collections.sort(lines);

            Files.write(output, lines);

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
