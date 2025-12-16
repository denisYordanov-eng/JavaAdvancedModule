package FilesAndStreams_Lab;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;

public class NestedFolders_08 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Laptop\\Downloads\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(path);
       ArrayDeque<File> queue = new ArrayDeque<>();
       queue.offer(file);

       int count = 0;

       while(!queue.isEmpty()){
           File currentFile =  queue.poll();
           System.out.println(currentFile.getName());
           count++;


           for(File f : currentFile.listFiles()){
               if(f.isDirectory()){
                   queue.offer(f);
               }
           }
       }
        System.out.printf("%d folders",count);
    }
}
