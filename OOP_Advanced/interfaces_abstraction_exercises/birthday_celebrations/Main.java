package birthday_celebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        List<Birthable> birthdayDays = new ArrayList<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String kind = tokens[0];
            switch (kind) {
                case"Pet":
                    String name = tokens[1];
                    String birthday = tokens[2];
                    birthdayDays.add(new Pet(name, birthday));
                    break;
                case"Citizen":
                    String citizenName = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String citizenBirthday = tokens[4];
                    birthdayDays.add(new Citizen(citizenName, age, id, citizenBirthday));
                    break;
            }

            input = br.readLine();
        }
        String targetYear = br.readLine();

        birthdayDays.stream()
                .filter(k -> k.getBirthday().endsWith(targetYear))
                .forEach(k -> System.out.println(k.getBirthday()));
    }
}
