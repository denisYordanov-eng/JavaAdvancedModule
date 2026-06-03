import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Dispatcher dispatcher = new Dispatcher();
        Handler handler = new Handler();

        dispatcher.addNameChangeListener(handler);
        String line = br.readLine();

        while (!line.equals("End")) {
            dispatcher.setName(line);
            dispatcher.fireNameChangeEvent();
            line = br.readLine();
        }
    }
}