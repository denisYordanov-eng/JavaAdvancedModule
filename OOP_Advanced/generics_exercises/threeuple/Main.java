package threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split("\\s+");
        String name = firstLine[0] + " " + firstLine[1];
        String address = firstLine[2];
        String town = firstLine[3];
        Threeuple<String,String,String> threeuple = new Threeuple<>(name, address, town);


        String[] secondLine = br.readLine().split("\\s+");
        String nameSecondLine = secondLine[0];
        int litersBeer = Integer.parseInt(secondLine[1]);
        String drunkOrNot = secondLine[2];
        boolean drunk = false;
        if (drunkOrNot.equalsIgnoreCase("drunk")) {
            drunk = true;
        }
//        } else if (drunkOrNot.equals("not")) {
//            drunk =  false;
//        }

        Threeuple<String,Integer,Boolean> threeupleTwo = new Threeuple<>(nameSecondLine, litersBeer,drunk);


        String[] thirdLine = br.readLine().split("\\s+");
        String nameThirdLine = thirdLine[0];
        double balance = Double.parseDouble(thirdLine[1]);
        String bankName = thirdLine[2];

        Threeuple<String,Double,String> threeupleThree = new Threeuple<>(nameThirdLine, balance, bankName);


        printOutput(threeuple, threeupleTwo, threeupleThree);
    }

    public static void printOutput(Threeuple threeuple, Threeuple threeupleTwo, Threeuple threeupleThree) {
        System.out.println(threeuple.toString());
        System.out.println(threeupleTwo.toString());
        System.out.println(threeupleThree.toString());
    }
}
