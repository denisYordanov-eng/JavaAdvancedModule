package FilesAndStreams_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllCapitals_03 {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Laptop\\Downloads\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\Laptop\\Desktop\\AllCapitals.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter out = new PrintWriter(outputPath)) {
            String line = reader.readLine();
            while (line != null) {
                //  for(Character c : line.toCharArray()){
//               if(Character. isLetter(c)){
//                   c = Character.toUpperCase(c);
//               }
//               out.print(c);
//           }
//            out.println();
                line = line.toUpperCase();

                out.println(line);

                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
