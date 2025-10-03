package IntroToJava;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class EuroTrip_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read kg from the console
        BigDecimal kgWurst = new BigDecimal(scanner.nextLine());

        //price  per kg in bg leva
        BigDecimal wurstPerKgInBgn = new BigDecimal("1.20");

        //the course of dm per 1 leva
        BigDecimal dmPerOneBgn = new BigDecimal("4210500000000");

        //calc the all price in bgn
        BigDecimal allWurstPriceInBgn =(wurstPerKgInBgn.multiply(kgWurst));

        //calc the sum in bg into dm
        BigDecimal priceInDm =(allWurstPriceInBgn.multiply(dmPerOneBgn));

        priceInDm = priceInDm.setScale(2, RoundingMode.HALF_UP);
        //print the output
        System.out.println(priceInDm.toPlainString() + " marks");
    }
}
