package ObjectsClassesAndCollections_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AMinerTask_12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> produce =  new LinkedHashMap<>();

        fillMap(produce,br);

        printMap(produce);
    }

    private static void printMap(Map<String, Integer> produce) {
        for (Map.Entry<String, Integer> entry : produce.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }

    private static void fillMap(Map<String, Integer> produce, BufferedReader br) throws IOException {
        int counter = 1;
        String inputLine = br.readLine();
        String key = " ";
        while (!inputLine.equals("stop")){
            if(counter % 2 == 1){
                key = inputLine;
            }else {
                int quantity = Integer.parseInt(inputLine);
                produce.put(key,produce.getOrDefault(key,0) + quantity) ;
            }

            counter++;
            inputLine = br.readLine();
        }
    }
}
