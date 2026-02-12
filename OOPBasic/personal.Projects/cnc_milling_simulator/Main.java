package cnc_milling_simulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> nxProgram = readQueue(br);

        executeProgram(nxProgram);

    }

    private static void executeProgram(ArrayDeque<String> nxProgram) {
        Point startPoint = new Point(0, 0, 0);
        while (!nxProgram.isEmpty()) {
            String program = nxProgram.poll();
            String[] command = program.split("\\s+");
            try {
                switch (command[0]) {
                    case "G0":
                        double endX = readValue(command[1]);
                        double endY = readValue(command[2]);
                        double endZ = readValue(command[3]);
                        Point endPoint = new Point(endX, endY, endZ);

                        double feedRateValue = readValue(command[4]);

                        LinearCommand linearCommand = new LinearCommand(startPoint, endPoint, feedRateValue);
                        System.out.println(linearCommand);
                        startPoint = endPoint;
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

        }
    }

    private static double readValue(String s) {
        if (s.trim().length() >= 2) {
            String value = s.substring(1);
            return Double.parseDouble(value);
        } else throw new IllegalArgumentException("Invalid value!");
    }

    private static ArrayDeque<String> readQueue(BufferedReader br) throws IOException {
        ArrayDeque<String> nxProgram = new ArrayDeque<>();
        String line = br.readLine();
        while (!line.equals("End")) {
            nxProgram.offer(line);
            line = br.readLine();
        }
        return nxProgram;
    }


}

