package collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ListyIterator<String> listyIterator = null;

        while (!input.equalsIgnoreCase("END")) {
            String[] tokens = input.split("\\s+");
            if (listyIterator == null && !tokens[0].equals("Create")) {
                input = br.readLine();
                continue;
            }
            switch (tokens[0]) {
                case "Create":
                    String[] elements = Arrays.stream(tokens).skip(1).toArray(String[]::new);
                    listyIterator = new ListyIterator<>(elements);
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
            }
            input = br.readLine();
        }
    }
}

