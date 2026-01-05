package JavaAdvancedExam;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TheVLogger_03 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputLine = br.readLine();

        Map<String, Set<String>> vlogFollowers = new HashMap<>();
        Map<String, Set<String>> vlogFollowingsN = new HashMap<>();
        while (!inputLine.equals("Statistics")) {
            String[] tokens = inputLine.split("\\s+");
            String vloggerName = tokens[0];
            String status = tokens[1];
            if (tokens[1].equals("joined")) {
                vlogFollowers.putIfAbsent(vloggerName, new TreeSet<>());
                vlogFollowingsN.putIfAbsent(vloggerName, new HashSet<>());
            } else if (tokens[1].equals("followed")) {
                String followedVlogger = tokens[2];
                if (vlogFollowers.containsKey(followedVlogger)
                        && vlogFollowingsN.containsKey(vloggerName)
                        && !followedVlogger.equals(vloggerName)
                        && !vlogFollowers.get(followedVlogger).contains(vloggerName)) {

                    vlogFollowers.get(followedVlogger).add(vloggerName);
                    vlogFollowingsN.get(vloggerName).add(followedVlogger);
                }
            }
            inputLine = br.readLine();
        }

        System.out.printf("The V-Logger has a total of %d vloggers in its logs.%n", vlogFollowingsN.size());


        List<Map.Entry<String, Set<String>>> sorted = vlogFollowers.entrySet().stream()
                .sorted((e1, e2) -> {
                    int cmp = Integer.compare(e2.getValue().size(), e1.getValue().size());
                    if (cmp == 0) {
                        cmp = Integer.compare(
                                vlogFollowingsN.get(e1.getKey()).size(),
                                vlogFollowingsN.get(e2.getKey()).size()
                        );
                    }
                    return cmp;
                })
                .collect(Collectors.toList());

        int counter = 1;
        for (Map.Entry<String, Set<String>> entry : sorted) {
            System.out.printf("%d. %s : %d followers, %d following%n", counter,
                    entry.getKey(),
                    entry.getValue().size(),
                    vlogFollowingsN.get(entry.getKey()).size());

            if (counter == 1) {
                for (String followedVlogger : entry.getValue()) {
                    System.out.printf("*  %s%n", followedVlogger);
                }
            }
            counter++;
        }
    }
}








