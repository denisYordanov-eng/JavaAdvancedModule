package telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Smartphone smartphone = new Smartphone();

        String[] numbers = br.readLine().split("\\s+");

        Arrays.stream(numbers).filter(n -> n.length() > 0).forEach(n -> {
            System.out.println(smartphone.call(n));
        });


        String[] sites = br.readLine().split("\\s+");
       Arrays.stream(sites).filter(s -> s.length() > 0).forEach(s -> {
           System.out.println(smartphone.browse(s));
       });

    }
}
