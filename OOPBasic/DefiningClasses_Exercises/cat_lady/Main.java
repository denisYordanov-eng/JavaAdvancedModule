package DefiningClass_Exercises.cat_lady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, BaseCat> cats = new HashMap<>();
        String input = br.readLine().trim();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String catType = tokens[0];
            String catName = tokens[1];

            BaseCat cat = null;
            switch (catType) {
                case "Siamese":
                    double earSize = Double.parseDouble(tokens[2]);
                    cat = new Siamese(catName, catType, earSize);
                    break;
                case "Cymric":
                    double furLength = Double.parseDouble(tokens[2]);
                    cat = new Cymric(catName, catType, furLength);
                    break;
                case "StreetExtraordinaire":
                    double decibels = Double.parseDouble(tokens[2]);
                    cat = new StreetExtraordinaire(catName, catType, decibels);
                    break;
            }
            if (cat != null) {
                cats.putIfAbsent(cat.getName(), cat);
            }

            input = br.readLine().trim();
        }
        String targetCat = br.readLine().trim();

        System.out.println(cats.get(targetCat));
    }
}
