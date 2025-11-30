package StreamApi_Lab;

import jdk.dynalink.linker.LinkerServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class MinEvenNumber_05 {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //read input
        String input = br.readLine();
        if(input.isEmpty()){
            System.out.println("No match");
            return;
        }
    //filter the collection
        OptionalDouble minNumber = Arrays.stream(input.split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .filter(n -> n % 1 == 0)
                .filter(n ->  n % 2 == 0)
                        .min();

        //print output
        if (minNumber.isPresent()) {
            System.out.printf("%.2f", minNumber.getAsDouble());
        }else {
            System.out.println("No match");
        }
    }
}
