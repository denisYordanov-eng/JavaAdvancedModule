import contracts.Kingable;
import contracts.Observer;
import models.FootMan;
import models.King;
import models.RoyalGuard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Observer> observerMap = new LinkedHashMap<>();

        String kingName = br.readLine();
        Kingable king = new King(kingName);

        king.attachObserver(king);

        String[] royalGuards = br.readLine().split("\\s+");
        for (String royalGuardName : royalGuards) {
            Observer royalGuardObserver = new RoyalGuard(royalGuardName);
            observerMap.putIfAbsent(royalGuardName, royalGuardObserver);
            king.attachObserver(royalGuardObserver);
        }

        String[] footManNames = br.readLine().split("\\s+");
        for (String footManName : footManNames) {
            Observer footManObserver = new FootMan(footManName);
            observerMap.putIfAbsent(footManName, footManObserver);
            king.attachObserver(footManObserver);
        }

        String command = br.readLine();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Attack":
                    king.attack();
                    break;
                case "Kill":
                    String targetName = tokens[1];
                    king.detachObserver(observerMap.get(targetName));
                    observerMap.remove(targetName);
                    break;
            }

            command = br.readLine();
        }
    }
}