package FilesAndStreams_Exercises;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyAPicture_09 {
    public static void main(String[] args) throws IOException {
        String imagePath = "C:\\Users\\Laptop\\Pictures\\Screenshots\\CopyAImage.png";
        String newImagePath ="C:\\Users\\Laptop\\Pictures\\Screenshots\\CopyAImage2.png";

        try (FileInputStream fis = new FileInputStream(imagePath);
        FileOutputStream fos = new FileOutputStream(newImagePath)) {

            //initialize byte[] and make it 4 kb
        byte[] buffer = new byte[4096];
        //initialize bytesRead an integer variable
        int bytesRead;
        //make a while loop while bytesRead = FileInputStream.read(current Byte)
            //FileOutputStream write buffer(current bytes) and and integer variable to prevent bytes lost if file is big
        while ((bytesRead = fis.read(buffer)) >= 0) {
            fos.write(buffer, 0, bytesRead);
            }
        //Files.copy(Paths.get(imagePath), Paths.get(newImagePath), StandardCopyOption.REPLACE_EXISTING);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
