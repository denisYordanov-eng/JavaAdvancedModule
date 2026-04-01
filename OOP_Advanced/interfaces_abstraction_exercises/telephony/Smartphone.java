package telephony;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Browsable, Callable {
    @Override
    public String browse(String url) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            return "Invalid URL!";
        }

        return String.format("Browsing: %s!", url);
    }

    @Override
    public String call(String number) {
        if (!number.matches("\\d+")) {
            return "Invalid number!";
        }
        return String.format("Calling... %s", number);
    }
}
