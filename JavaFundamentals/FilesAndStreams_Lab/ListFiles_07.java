package FilesAndStreams_Lab;

import java.io.File;
import java.io.IOException;

public class ListFiles_07 {
    public static  void main(String[] args) throws IOException {
        String path = "C:\\Users\\Laptop\\Downloads\\08. Java-Advanced-Files-and-Streams-Lab-Resources";
        File file = new File(path);
        if (file.exists()) {
            if(file.isDirectory()) {
                File[] files = file.listFiles();
                for(File f : files) {
                    if(!f.isDirectory()) {
                        System.out.printf("%s: %d%n",f.getName(), f.length());
                    }
                }
            }
        }
    }
}
