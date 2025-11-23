package Functional_Programing_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class AddVat_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = readInputArr(br);

        Function<String, Double> vat = (element) -> Double.parseDouble(element) * 1.2;
        Set<Double> vatList = new LinkedHashSet<>();
        fillVatList(vatList, input, vat);
        printOutput(vatList);
    }

    private static void printOutput(Set<Double> vatList) {
        System.out.println("Prices with VAT:");
        for (Double vat : vatList) {
            String formattedPrice = String.format("%.2f", vat);
            formattedPrice = formattedPrice.replaceAll("\\.", ",");
            System.out.println(formattedPrice);
        }
    }

    private static void fillVatList(Set<Double> vatList, String[] input, Function<String, Double> vat) {
        for (String word : input) {
            double currentVat = vat.apply(word);
            vatList.add(currentVat);
        }
    }

    private static String[] readInputArr(BufferedReader br) throws IOException {
        return br.readLine().split(", ");
    }
}
