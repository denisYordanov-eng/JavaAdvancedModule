package mood3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" \\| ");
        String username = tokens[0];
        String type = tokens[1];
        String specialPoints = tokens[2];
        int level = Integer.parseInt(tokens[3]);

        switch (type) {
            case "Demon":
                double energy = Double.parseDouble(specialPoints);
                Demon demon = new Demon(username, energy,level);
                System.out.println(demon.toString());
                break;
            case "Archangel":
                int mana = Integer.parseInt(specialPoints);
                Archangel archangel = new Archangel(username,mana,level);
                System.out.println(archangel.toString());
                break;
        }
    }
}
