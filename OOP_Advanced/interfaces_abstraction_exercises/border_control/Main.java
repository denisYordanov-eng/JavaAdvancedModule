package border_control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        List<Identifiable>  nation = new ArrayList<>();

        while (!input.equals("End")) {
        String[] tokens = input.split("\\s+");

        switch (tokens.length) {
            case 2:
             String model = tokens[0];
             String id = tokens[1];
             nation.add(new Robot(model, id));
                break;
            case 3:
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String citizenId = tokens[2];
                nation.add(new Citizen(name,age,citizenId));
                break;
        }

            input = br.readLine();
        }

        String fakeId = br.readLine();

        nation.stream()
                .filter(n -> n.getId().endsWith(fakeId))
                .forEach(n -> System.out.println(n.getId()));
    }
}
