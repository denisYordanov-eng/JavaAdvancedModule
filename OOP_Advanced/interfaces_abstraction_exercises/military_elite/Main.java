package military_elite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, ISoldier> allSoldiers = new LinkedHashMap<>();
        Map<Integer, IPrivate> privatesOnly = new LinkedHashMap<>();

        String line = br.readLine();

        while (!line.equalsIgnoreCase("End")) {
            String[] tokens = line.split("\\s+");
            int id = Integer.parseInt(tokens[1]);
            String fName = tokens[2];
            String lName = tokens[3];
            switch (tokens[0]) {
                case "Private":
                    double salary = Double.parseDouble(tokens[4]);
                    IPrivate privateSoldier = new PrivateImpl(fName, lName, id, salary);
                    privatesOnly.put(id, privateSoldier);
                    allSoldiers.put(id, privateSoldier);
                    break;
                case "LeutenantGeneral":

                    double leutanantSalary = Double.parseDouble(tokens[4]);
                    LeutenantGeneral gen = new LeutenantGeneral(id, fName, lName, leutanantSalary);
                    for (int i = 5; i < tokens.length; i++) {
                        int pId = Integer.parseInt(tokens[i]);
                        if (privatesOnly.containsKey(pId)) {
                            gen.addPrivateImpl(privatesOnly.get(pId));
                        }
                    }
                    allSoldiers.put(id, gen);
                    break;
                case "Engineer":
                    double engineerSalary = Double.parseDouble(tokens[4]);
                    String corps = tokens[5];
                    if (!corps.equals("Airforces") && !corps.equals("Marines")) {
                        break;
                    }
                    Engineer engineer = new Engineer(fName, lName, id, engineerSalary, corps);
                    for (int i = 6; i < tokens.length; i += 2) {
                        String partName = tokens[i];
                        int hours = Integer.parseInt(tokens[i + 1]);
                        Repair repair = new Repair(partName, hours);
                        engineer.addRepair(repair);
                    }
                    allSoldiers.put(id, engineer);
                    break;
                case "Commando":
                    double commandoSalary = Double.parseDouble(tokens[4]);
                    String comandoCorps = tokens[5];
                    Commando commando = new Commando(fName, lName, id, commandoSalary, comandoCorps);

                    for (int i = 6; i < tokens.length; i += 2) {
                        String codeName = tokens[i];
                        String state = tokens[i + 1];
                        Mission mission = new Mission(codeName, state);
                        commando.addMission(mission);
                    }
                    allSoldiers.put(id, commando);
                    break;
                case "Spy":
                    String codeName = tokens[4];
                    Spy spy = new Spy(id, fName, lName, codeName);
                    allSoldiers.put(id, spy);
                    break;
            }
            line = br.readLine();
        }
        printOutput(allSoldiers);
    }

    private static void printOutput(Map<Integer, ISoldier> allSoldiers) {
        allSoldiers.forEach((id, soldier) -> {
            System.out.println(soldier.toString());
        });
    }


}
