package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class PredicateForNames_07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int wantedLength =  readNumber(br);
        String[] names = readArr(br);

        Predicate<Integer> checkLength = (length)-> length <= wantedLength;
        for (String name: names){

            if(checkLength.test(name.length())){
              printName(name);
            }
        }
    }

    private static void printName(String name) {
        System.out.println(name);
    }

    private static int readNumber(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static String[] readArr(BufferedReader br) throws IOException {
        return br.readLine().split("\\s+");
    }
}
