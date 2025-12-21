package FilesAndStreams_Exercises;

import java.io.*;
import java.util.ArrayList;

public class SerializeArrayList_10 {
    private static final String FILE_NAME = "list.ser";

    public static void main(String[] args) {

        ArrayList<Double> values = new ArrayList<>();
        values.add(1.0);
        values.add(2.5);
        values.add(3.6);

        saveList(values);
        ArrayList<Double> newValues = loadValues();

        if (newValues != null) {
            for (Double value : newValues) {
                System.out.println(value);
            }
        }

    }

    private static ArrayList<Double> loadValues() {
        ArrayList<Double> newValues = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));) {

            return (ArrayList<Double>) ois.readObject();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static void saveList(ArrayList<Double> values) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));) {

            out.writeObject(values);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
