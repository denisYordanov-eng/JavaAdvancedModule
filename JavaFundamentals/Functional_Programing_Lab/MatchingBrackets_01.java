package Functional_Programing_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MatchingBrackets_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> listNumbers = new ArrayList<Integer>();

       fillList(listNumbers,br);

   listNumbers.removeIf(number -> number % 2 != 0);
        printOutput(listNumbers);

        listNumbers.sort((e1,e2) -> e1.compareTo(e2));
        printOutput(listNumbers);
    }

    private static void printOutput(ArrayList<Integer> listNumbers) {
        System.out.println(listNumbers.toString().replaceAll("]", "").replaceAll("\\[", ""));

    }


    private static void fillList(ArrayList<Integer> listNumbers, BufferedReader br) throws IOException {
        String[] input = br.readLine().split("[,\\s]+");
        for (String s : input) {
            listNumbers.add(Integer.parseInt(s));
        }
    }
}
