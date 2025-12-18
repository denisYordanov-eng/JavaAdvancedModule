package FilesAndStreams_Exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers_05  {
   public  static void main(String[] args) throws IOException {
       String inputPath = "C:\\Users\\Laptop\\Desktop\\input.txt";
       String outputPath = "C:\\Users\\Laptop\\Desktop\\outputLinesWithNums.txt";

       try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
            PrintWriter out = new PrintWriter(outputPath)) {
        String line = reader.readLine();

        int counter = 1;
        while (line != null) {
            out.println(counter + ". " + line);
            counter++;
            line = reader.readLine();
        }

       }catch(IOException e) {
           e.printStackTrace();
       }

   }

}
