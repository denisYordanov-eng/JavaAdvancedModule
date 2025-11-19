package ObjectsClassesAndCollections_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;


public class PopulationCounter_14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, LinkedHashMap<String, Long>> countryCityPopulation = new LinkedHashMap<>();
        fillMap(countryCityPopulation, br);
        printMap(countryCityPopulation);
    }

    private static void printMap(Map<String, LinkedHashMap<String, Long>> countryCityPopulation) {
        countryCityPopulation
                .entrySet()
                .stream()
                .sorted((a, b) -> Long.compare(
                        getTotal(b.getValue()),
                        getTotal(a.getValue())

                )).forEach(country -> {
                    long total = getTotal(country.getValue());
                    System.out.printf("%s (total population: %d)%n", country.getKey(), total);

                    country.getValue()
                            .entrySet()
                            .stream()
                            .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });
    }

    private static void fillMap(Map<String, LinkedHashMap<String, Long>> countryCityPopulation, BufferedReader br) throws IOException {
        String inputLine = br.readLine();
        while (!inputLine.equals("report")) {
            String[] inputArray = inputLine.split("\\|");
            String cityName = inputArray[0];
            String countryName = inputArray[1];
            long population = Long.parseLong(inputArray[2]);

            countryCityPopulation.putIfAbsent(countryName, new LinkedHashMap<>());
            countryCityPopulation.get(countryName).putIfAbsent(cityName, population);
            inputLine = br.readLine();
        }
    }

    private static long getTotal(Map<String, Long> cities) {
        return cities.values().stream().mapToLong(Long::longValue).sum();
    }
}
