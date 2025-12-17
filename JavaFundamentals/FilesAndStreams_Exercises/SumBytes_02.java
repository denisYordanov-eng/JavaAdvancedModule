package FilesAndStreams_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumBytes_02 {
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\Laptop\\Downloads\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath))) {
            String line = reader.readLine();

            BigInteger sum = BigInteger.ZERO;

            while (line != null) {

                for (char c : line.toCharArray()) {
                    sum = sum.add((BigInteger.valueOf(c)));
                }
                //add new line to the sum
                sum = sum.add(BigInteger.valueOf(10));

                line = reader.readLine();
            }
            //remove the last new '\n'
            sum = sum.subtract(BigInteger.valueOf(10));
            System.out.println(sum);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
