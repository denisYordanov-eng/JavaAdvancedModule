package FilesAndStreams_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines_01 {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Laptop\\Downloads\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath))){
        String line = reader.readLine();

            while(line != null){
                long sum = 0L;
                for(char ch : line.toCharArray()){
                sum += ch;
            }
            line = reader.readLine();
                System.out.println(sum);
            }

        }catch(IOException e){
            e.printStackTrace();
        }




    }

}
