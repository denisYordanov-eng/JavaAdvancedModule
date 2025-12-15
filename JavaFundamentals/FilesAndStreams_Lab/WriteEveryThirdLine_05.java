package FilesAndStreams_Lab;

import java.io.*;

public class WriteEveryThirdLine_05 {
    public static void main(String[] args) {
        String input = "C:\\Users\\Laptop\\Downloads\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output = "C:\\Users\\Laptop\\Desktop\\output3Line.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(input));
             PrintWriter out = new PrintWriter(new FileWriter(output))) {

            String line;
            int count = 1;
            while ((line = in.readLine())  != null) {
                if (count % 3 == 0) {
                    out.println(line);
                }
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
