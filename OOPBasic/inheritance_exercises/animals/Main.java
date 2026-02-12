package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        while (!input.equalsIgnoreCase("Beast!")) {
            try {

                String[] tokens = br.readLine().split("\\s+");
                if (tokens.length != 3) {
                    throw new IllegalArgumentException("Invalid input!");
                }
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String gender = tokens[2];
                switch (input.toLowerCase()) {
                    case "cat":
                        Cat cat = new Cat(name, age, gender);
                        System.out.println("Cat");
                        System.out.println(cat);
                        cat.produceSound();
                        break;
                    case "dog":
                        Dog dog = new Dog(name, age, gender);
                        System.out.println("Dog");
                        System.out.println(dog);
                        dog.produceSound();
                        break;
                    case "frog":
                        Frog frog = new Frog(name, age, gender);
                        System.out.println("Frog");
                        System.out.println(frog);
                        frog.produceSound();
                        break;
                    case "tomcat":
                        Tomcat tomcat = new Tomcat(name, age, gender);
                        System.out.println("Tomcat");
                        System.out.println(tomcat);
                        tomcat.produceSound();
                        break;
                    case "kitten":
                        Kitten kitten = new Kitten(name, age, gender);
                        System.out.println("Kitten");
                        System.out.println(kitten);
                        kitten.produceSound();
                        break;
                        default:
                            throw new IllegalArgumentException("Invalid input!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
            input = br.readLine();
        }
    }
}
