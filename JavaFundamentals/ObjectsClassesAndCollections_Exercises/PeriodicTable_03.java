package ObjectsClassesAndCollections_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PeriodicTable_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> elements= new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] element = br.readLine().split("\\s+");
           for(String s: element) {
               elements.add(s);
           }
        }

//        elements = elements.stream()
//                .sorted((e1, e2) -> e1.compareTo(e2))
//                .collect(Collectors.toSet());

        for (String element : elements) {
            System.out.printf("%s ", element);
        }
    }
}
