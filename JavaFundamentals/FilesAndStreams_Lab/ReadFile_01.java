package FilesAndStreams_Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.stream.Stream;

public class ReadFile_01 {
    public static void main(String[] args) {
        String path = "C:\\Users\\Laptop\\Downloads\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\input.txt";
        try(FileInputStream fis = new FileInputStream(path)){
           int oneByte = fis.read();
           while (oneByte >= 0) {
               System.out.printf("%s ",Integer.toBinaryString(oneByte));
               oneByte = fis.read();
           }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
