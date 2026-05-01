package enumerations_and_annotations.traffic_lights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split("\\s+");
        TrafficLight[] trafficLights = new TrafficLight[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            trafficLights[i] = TrafficLight.valueOf(tokens[i].toUpperCase());
        }


        int counter = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counter; i++) {
            for (int j = 0; j < trafficLights.length; j++) {
                trafficLights[j] = trafficLights[j].getNextTrafficLight();
                sb.append(trafficLights[j]);
                sb.append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());

    }
}
