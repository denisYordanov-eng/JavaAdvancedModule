package JavaAdvancedExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExtensions_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sentence = new StringBuilder();
        sentence.append(br.readLine());

        String command = br.readLine();

        while (!command.equals("Print")) {
            // initialize Strung buffer result
            StringBuffer result = new StringBuffer();

            // make a regex pattern -> replace  "%" and escape special characters like (.?)
            String regex = Pattern.quote(command).replace("%","\\E[^\\s]*\\Q");


           Pattern pattern = Pattern.compile(regex);

           Matcher matcher = pattern.matcher(sentence.toString());

           //replace every matcher with reversed matcher String using appendReplacement
           while (matcher.find()) {
               String reversedMatch = new StringBuilder(matcher.group()).reverse().toString();
            matcher.appendReplacement(result,Matcher.quoteReplacement(reversedMatch));
           }
            matcher.appendTail(result);

            sentence = new StringBuilder(result.toString());

            command = br.readLine();
        }
        //print output
        System.out.println(sentence.toString());
        }
    }



