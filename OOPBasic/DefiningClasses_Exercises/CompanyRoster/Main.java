package DefiningClass_Exercises.CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Employee>> map = new HashMap<>();
        int count = Integer.parseInt(bufferedReader.readLine());


        for (int i = 0; i < count; i++) {
            String[] tokens = bufferedReader.readLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee = null;
            switch (tokens.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (tokens[4].contains("@")) {
                        String email = tokens[4];
                        employee = new Employee(name, salary, position, department, email);
                    } else {
                        int age = Integer.parseInt(tokens[4]);
                        employee = new Employee(name, salary, position, department, age);
                    }
                    break;
                case 6:
                    String currentEmail = tokens[4];
                    int age = Integer.parseInt(tokens[5]);
                    employee = new Employee(name, salary, position, department, currentEmail, age);
            }
            if (!map.containsKey(employee.getDepartment())) {
                map.putIfAbsent(employee.getDepartment(), new ArrayList<>());
            }
            map.get(employee.getDepartment()).add(employee);
        }

        map.entrySet().stream()
                .sorted((e1, e2) ->
                        Double.compare(e2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                                e1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()))
                .limit(1)
                .forEach(entry -> {
                    System.out.printf("Highest Average Salary: %s%n", entry.getKey());
                    entry.getValue().stream()
                            .sorted(Comparator.comparing(Employee::getSalary).reversed())
                            .forEach(employee ->
                                    System.out.println(employee.toString()));
                });
    }
}

