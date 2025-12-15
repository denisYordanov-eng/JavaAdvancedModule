package FilesAndStreams_Lab;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers_04 {
    public static void main(String[] args)  {

        String input = "C:\\Users\\Laptop\\Downloads\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\Files-and-Streams\\input.txt";
        String output = "C:\\Users\\Laptop\\Desktop\\Output.txt";

        try
                (Scanner scanner = new Scanner(new FileInputStream(input));
            PrintWriter out = new PrintWriter(new FileOutputStream(output))){

            while (scanner.hasNextInt()) {
                    out.println(scanner.nextInt());
                  scanner.next();
            }
           // out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
