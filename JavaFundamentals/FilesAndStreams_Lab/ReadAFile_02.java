package FilesAndStreams_Lab;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAFile_02 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\Laptop\\Downloads\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\input.txt";
        String output = "C:\\Users\\Laptop\\Downloads\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\output.txt";
        List<Character> bannedChars = List.of('.', ',', '!', '?');


        try (FileInputStream in = new FileInputStream(path);
             OutputStream out = new FileOutputStream(output)) {

            int oneByte = 0;

            while ((oneByte = in.read()) >= 0) {
                if (!bannedChars.contains((char) oneByte)) {
                    out.write((char) oneByte);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
