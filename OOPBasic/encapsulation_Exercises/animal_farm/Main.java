package encapsulation_exercise.class_box.animal_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String chickenName = br.readLine();
        int age = Integer.parseInt(br.readLine());
        try {
            Chicken chicken = new Chicken(chickenName, age);
            System.out.println(chicken);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
