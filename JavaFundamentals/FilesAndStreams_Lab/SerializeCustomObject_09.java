package FilesAndStreams_Lab;

import java.io.*;

public class SerializeCustomObject_09 {
    public  static void main(String[] args) throws IOException, ClassNotFoundException {
         initializeCube();

        
    }

    private static void initializeCube() throws IOException {
        Cube cube = new Cube();
        cube.color ="green";
        cube.width = 15.3d;
        cube.height = 12.4d;
        cube.depth = 3.0d;

        String path = "C:\\Users\\Laptop\\Desktop\\safe.txt";
      try  (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))){
            out.writeObject(cube);
        }catch(IOException e){
          e.printStackTrace();
      }

    }
}
