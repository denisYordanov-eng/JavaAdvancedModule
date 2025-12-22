package FilesAndStreams_Exercises;

import java.io.*;


import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive_12 {


    public static void main(String[] args) throws IOException {
        String[] inputs = {
                "C:\\Users\\Laptop\\Desktop\\FirstInput.txt",
                "C:\\Users\\Laptop\\Desktop\\SecondInput.txt",
                "C:\\Users\\Laptop\\Desktop\\ThirdUnput.txt"
        };

        String zip = "C:\\Users\\Laptop\\Desktop\\files.zip";

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zip))) {

            for(String path: inputs) {
                File fileToZip = new File(path);

                if(!fileToZip.isFile()) {
                    continue;
                }
                ZipEntry entry = new ZipEntry(fileToZip.getName());
                zos.putNextEntry(entry);
                try(FileInputStream fis = new FileInputStream(fileToZip);){

                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while((bytesRead = fis.read(buffer)) >= 0) {
                        zos.write(buffer, 0, bytesRead);
                    }
                }catch(FileNotFoundException e) {
                    e.printStackTrace();
                }catch(IOException e) {
                    e.printStackTrace();
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
