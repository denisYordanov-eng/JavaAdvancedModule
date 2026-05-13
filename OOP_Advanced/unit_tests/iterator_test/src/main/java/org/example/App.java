package org.example;


import Interfaces.ListCommands;
import models.ListIterator;

import javax.naming.OperationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] create = br.readLine().split("\\s+");
            List<String> list = new ArrayList<String>(Arrays.stream(create).skip(1).collect(Collectors.toList()));
            ListCommands<String> collection = new ListIterator<>(list);

            String command = br.readLine();
            while (!command.equals("END")) {
                switch (command) {
                    case "HasNext":
                        System.out.println(collection.hasNext());
                        break;
                    case "Print":
                       collection.print();
                        break;
                    case "Move":
                        System.out.println(collection.move());
                        break;
                }
                command = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
}
