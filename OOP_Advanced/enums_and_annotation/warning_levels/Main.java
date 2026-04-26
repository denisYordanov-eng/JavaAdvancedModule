package warning_levels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Importance targetImportance = Importance.valueOf(br.readLine().toUpperCase());
        Logger logger = new Logger(targetImportance);
        String input = br.readLine();

        while (!input.equalsIgnoreCase("END")) {
            String[] tokens = input.split(": ");
            Importance importance = Importance.valueOf(tokens[0].toUpperCase());
            logger.receivesMessage(importance, tokens[1]);
            input = br.readLine();
        }

        for (Message message : logger.getMessages()) {
            System.out.println(message);
        }

    }
}
