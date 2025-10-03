package IntroToJava;

import java.util.Scanner;

public class TransportPrice_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int distance = Integer.parseInt(scanner.nextLine());
        String dayTime = scanner.nextLine();
        // initial tax for taxy
        double initialTax = 0.70;

        String transportType = "";
        double finalPrice = 0;

        if(distance >= 20 && distance < 100){
            transportType = "Bus";
            finalPrice = distance*0.09;
        }else if(distance >= 100){
            transportType = "Train";
            finalPrice = distance * 0.06;
        }else {
            if(dayTime.equals("day")){
                finalPrice = distance * 0.79 ;
            } else if (dayTime.equals("night")) {
                finalPrice = distance * 0.90;
            }
            finalPrice += initialTax;
        }

        //print output price
        System.out.printf("%.2f",finalPrice);

    }
}
