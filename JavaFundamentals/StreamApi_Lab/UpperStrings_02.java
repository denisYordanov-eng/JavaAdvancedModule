package StreamApi_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpperStrings_02 {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       List<String> names = readAndFillList(br);

       names.stream()
               .map(name -> name.toUpperCase())
               .forEach(name -> System.out.print(name + " "));
    }

    private static List<String> readAndFillList(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine()
                        .split("\\s+"))
                .collect(Collectors.toList());
    }
}
