package FilesAndStreams_Exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeTwoFiles_07 {
    public static void main(String[] args) {
        String firstInput = "C:\\Users\\Laptop\\Desktop\\FirstInput.txt";
        String secondInput = "C:\\Users\\Laptop\\Desktop\\SecondInput.txt";
        String output = "C:\\Users\\Laptop\\Desktop\\MergeOutput.txt";

        try (BufferedReader first = Files.newBufferedReader(Paths.get(firstInput));
             BufferedReader second = Files.newBufferedReader(Paths.get(secondInput));
             PrintWriter out = new PrintWriter(output)
        ) {

            String firstLine = first.readLine();
            while (firstLine != null) {
                out.println(firstLine);
                firstLine = first.readLine();
            }

            String secondLine = second.readLine();
            while (secondLine != null) {
                out.println(secondLine);
                secondLine = second.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
