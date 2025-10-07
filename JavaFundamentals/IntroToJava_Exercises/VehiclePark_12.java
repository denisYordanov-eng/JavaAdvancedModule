package InroToJava_Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VehiclePark_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read available cars
        List<String> vehicles = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));

        //Read orders
        String inputOrders = scanner.nextLine();
        String regexPattern = "(?<model>[A-Z]).+?(?<seats>[0-9]+).+";
        Pattern pattern = Pattern.compile(regexPattern);
        int sellCounter = 0;
        while (!inputOrders.equals("End of customers!")) {

            Matcher matcher = pattern.matcher(inputOrders);

            if (matcher.find()) {
                String newOrder = matcher.group("model") + matcher.group("seats");
                newOrder = newOrder.toLowerCase();
                if (vehicles.contains(newOrder)) {
                    int price = calculatePrice(newOrder);
                    System.out.printf("Yes, sold for %d$\n", price);
                    sellCounter++;
                    vehicles.remove(newOrder);
                } else {
                    System.out.println("No");
                }
            }
            inputOrders = scanner.nextLine();
        }

        System.out.println("Vehicles left: " + String.join(", ", vehicles));
        System.out.println("Vehicles sold: " +sellCounter);
    }

    private static int calculatePrice(String newOrder) {
       int sum = 0;
       char model = newOrder.charAt(0);
       int seats = Integer.parseInt(newOrder.substring(1));
       sum = model * seats;
       return sum;

    }
}
