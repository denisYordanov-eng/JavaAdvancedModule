package StreamApi_Lab;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;

public class FindAndSumIntegers_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        OptionalInt numbers = Arrays.stream(input.split("\\s+"))
                .filter(n -> isNumber(n))
                .mapToInt(Integer::parseInt)
                .reduce((x1,x2) ->x1 + x2);

        if (numbers.isPresent()) {
            System.out.println(numbers.getAsInt());
        }else {
            System.out.println("No match");
        }
    }

    private static boolean isNumber(String n) {
     if(n.isEmpty()){
         return false;
     }
     int start = (n.charAt(0) == '+' || n.charAt(0) == '-') ? 1 : 0;
     if (start == 1 && n.length() == 1){
         return false;
     }
     for (int i = start; i < n.length(); i++) {
         if(!Character.isDigit(n.charAt(i))){
             return false;
         }
     }
        return true;
    }
}
