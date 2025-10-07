package InroToJava_Exercise;

import java.util.Scanner;

public class XBits_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // read input numbers, cast them to binary string and put them in a string aray
        String[] binaries = new String[8];
        for (int i = 0; i < 8; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            String binaryNumber = String.format("%32s", Integer.toBinaryString(number)).replace(' ', '0');
            binaries[i] = binaryNumber;
        }
        //make  a counter
        int counter = 0;
        //make a for loop for cols and rows to length - 2 because we will check another two chars.
        //first for loop make take a whole string on a row
        //second  string check every 3 digits  if first one is equals of 101, second one is equals of 010 //
        // and third one is equals of 101 if it is true increment counter.
        for (int i = 0; i < binaries.length - 2; i++) {
            for (int j = 0; j < binaries[i].length() - 2; j++) {
             // String a = "" + binaries[i]. charAt(j) + binaries[i].charAt(j+1) + binaries[i].charAt(j+2) ;
              //String b = "" + binaries[i+1].charAt(j) + binaries[i+1].charAt(j+1) + binaries[i+1].charAt(j+2);
              //String c = "" + binaries[i+2].charAt(j) + binaries[i+2].charAt(j+1) + binaries[i+2].charAt(j+2);

              String a = binaries[i].substring(j, j+3);
              String b = binaries[i + 1].substring(j, j + 3);
              String c = binaries[i + 2].substring(j, j + 3);
                if (a.equals("101") && b.equals("010") && c.equals("101")) {
                    counter++;
                }
            }
        }
        //print  counter
        System.out.println(counter);
    }
}
