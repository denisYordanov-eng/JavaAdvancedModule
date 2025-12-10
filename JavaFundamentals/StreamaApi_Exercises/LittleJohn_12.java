package StreamaApi_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn_12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> hay = new ArrayList<>();

        fillList(hay, br);
        long result = countHaysAndMakeString(hay);

        System.out.println(result);
    }

    private static long countHaysAndMakeString(List<String> hay) {
        int small = 0;
        int medium = 0;
        int large = 0;
        String combinePattern = "(>>>----->>)|(>>----->)|(>----->)";
        Pattern pattern = Pattern.compile(combinePattern);

        for (String currentHay : hay) {
            Matcher matcher = pattern.matcher(currentHay);
            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    large++;
                }
                if (matcher.group(2) != null) {
                    medium++;
                }
                if (matcher.group(3) != null) {
                    small++;
                }
            }
        }

        String ArrowCountString = String.valueOf(small) + String.valueOf(medium) + String.valueOf(large);

        long number = Long.parseLong(ArrowCountString);

        String binaryString = Long.toBinaryString(number);

        String reverseString = new StringBuilder(binaryString).reverse().toString();

        String finalStr = binaryString + reverseString;

        long decimal = Long.parseLong(finalStr, 2);
        return decimal;
    }

    private static void fillList(List<String> hay, BufferedReader br) throws IOException {
        for (int i = 0; i < 4; i++) {
            String input = br.readLine().trim();
            hay.add(input);
        }
    }
}
