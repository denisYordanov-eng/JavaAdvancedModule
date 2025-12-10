package StreamaApi_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class OfficeStuff_13 {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n  = readNumber(br);

    Map<String,LinkedHashMap<String,Integer>>  companySupplyNumbers = new TreeMap<>();

    for (int i = 0; i < n; i++) {
        String[] tokens = br.readLine().trim().split("[-\\s]+");
        String companyName = tokens[0].substring(1);
        int numbers = Integer.parseInt(tokens[1]);
        String supply  = tokens[2].substring(0,tokens[2].length()-1);

        companySupplyNumbers.putIfAbsent(companyName, new LinkedHashMap<>());

        LinkedHashMap<String,Integer> currentProducts = companySupplyNumbers.get(companyName);
        int  currentAmount = currentProducts.getOrDefault(supply,0) + numbers;
       companySupplyNumbers.get(companyName).put(supply, currentAmount);
    }

    printResult(companySupplyNumbers);
    }

    private static void printResult(Map<String, LinkedHashMap<String, Integer>> companySupplyNumbers) {
        for (Map.Entry<String, LinkedHashMap<String, Integer>> companyEntry : companySupplyNumbers.entrySet()) {
            String companyName = companyEntry.getKey();
            System.out.print(companyName + ": ");
            List<String> products = new ArrayList<>();
            for (Map.Entry<String, Integer> productEntry : companyEntry.getValue().entrySet()) {
                products.add(productEntry.getKey() + "-" + productEntry.getValue());
            }
            System.out.println(String.join(", ", products));
        }
    }

    private static int readNumber(BufferedReader br) throws IOException {
        return  Integer.parseInt(br.readLine().trim());
    }
}
