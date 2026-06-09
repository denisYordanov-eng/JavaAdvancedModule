package panzer;

import panzer.manager.ManagerImpl;
import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.io.Reader;
import panzer.io.Writer;

import java.io.IOException;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        InputReader reader = new Reader();
        OutputWriter writer = new Writer();
        Manager manager = new ManagerImpl();

        while (true) {
            String[] input = reader.readLine().split("\\s+");

            if (input[0].equals("Terminate")) {
                writer.println(manager.terminate(Arrays.asList(input)));
                break;
            }
            String command = input[0];

            switch (command) {
                case "Vehicle":
                   writer.println(manager.addVehicle(Arrays.asList(input)));
                    break;
                case "Part":
                    writer.println(manager.addPart(Arrays.asList(input)));
                    break;
                case "Inspect":
                   writer.println(manager.inspect(Arrays.asList(input)));
                    break;
                case "Battle":
                    writer.println(manager.battle(Arrays.asList(input)));
                    break;
            }
        }
    }
}
