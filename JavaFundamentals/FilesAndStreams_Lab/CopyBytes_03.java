package FilesAndStreams_Lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes_03 {
    public static void main(String[] args) throws IOException{
        String input = "C:\\Users\\Laptop\\Downloads\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\Files-and-Streams\\Streams-and-Files\\input.txt";
        String output = "C:\\Users\\Laptop\\Downloads\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\Files-and-Streams\\Streams-and-Files\\output.txt";

        try(FileInputStream in  = new FileInputStream(input);
        FileOutputStream out = new FileOutputStream(output)){


            int oneByte = 0;
            while((oneByte  = in.read()) >= 0){
               if(oneByte == 10 || oneByte == 32){
                 out.write(oneByte);
               }else {
                   String digits = String.valueOf(oneByte);
                   for(int i = 0; i < digits.length(); i++){
                       out.write(digits.charAt(i));
                   }
               }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
