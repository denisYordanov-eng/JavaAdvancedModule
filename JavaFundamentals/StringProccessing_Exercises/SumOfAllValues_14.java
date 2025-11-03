package StringProcessing_Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyInput = scanner.nextLine();
        String text = scanner.nextLine();

        Matcher startMatcher = Pattern.compile("^([A-Za-z_]+)[0-9]").matcher(keyInput);
        Matcher endMatcher =  Pattern.compile("[0-9]([A-Za-z_]+)$").matcher(keyInput);

        String startKey = "";
        String endKey = "";

        if (startMatcher.find()) {
            startKey = startMatcher.group(1);
        }

        if (endMatcher.find()) {
            endKey = endMatcher.group(1);
        }
        if(startKey.isEmpty() || endKey.isEmpty()){
            System.out.println("<p>A key is missing</p>");
            return;
        }

        String regex = Pattern.quote(startKey) + "([0-9]+(?:\\.[0-9]+)?)" + Pattern.quote(endKey);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        double sum = 0;

        while (matcher.find()) {
            sum += Double.parseDouble(matcher.group(1));
        }

        if (sum == 0){
            System.out.println("<p>The total value is: <em>nothing</em></p>");

        } else if (sum == Math.floor(sum)) {
            System.out.printf("<p>The total value is: <em>%.0f</em></p>", sum);
        }else {
            System.out.printf("<p>The total value is: <em>%.2f</em></p>", sum);
        }
    }
}