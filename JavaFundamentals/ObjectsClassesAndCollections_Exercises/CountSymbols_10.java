package ObjectsClassesAndCollections_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountSymbols_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = readText(br);
        Map<Character, Integer> map = new TreeMap<>();
        map = findCount(text);
        printMap(map);
    }

    private static void printMap(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }

    private static Map<Character, Integer> findCount(String text) {
        Map<Character, Integer> map = new TreeMap<>();
       for (char currentChar : text.toCharArray()) {
           map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
       }

        return map;
    }

    private static String readText(BufferedReader br) throws IOException {
        return br.readLine();
    }
}
