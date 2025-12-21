package FilesAndStreams_Exercises;

import java.io.*;

public class SerializeCustomObject_11 {

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\Laptop\\Desktop\\course.ser";

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            //initialize new course object
            Course course = new Course();
            course.name = "Alone course";
            course.numberOfStudents = 1;

            //serialize object in fileName
            objectOutputStream.writeObject(course);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

            Course serializedCourse = (Course) ois.readObject();
            //print the object fields
            System.out.println(serializedCourse.name);
            System.out.println(serializedCourse.numberOfStudents);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
