package P03_DependencyInversion;

import P03_DependencyInversion.contracts.Calculator;
import P03_DependencyInversion.contracts.Strategy;
import P03_DependencyInversion.models.PrimitiveCalculator;
import P03_DependencyInversion.strategies.AdditionStrategy;
import P03_DependencyInversion.strategies.DivisionStrategy;
import P03_DependencyInversion.strategies.MultiplicationStrategy;
import P03_DependencyInversion.strategies.SubtractionStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Calculator calculator = new PrimitiveCalculator(createStrategy("+"));

        String input = br.readLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            if (tokens[0].equals("mode")) {
                String operand = tokens[1];
                Strategy strategy = createStrategy(tokens[1]);
                if(strategy != null){
                calculator.changeStrategy(strategy);
                }
            } else {
                int firstNumber = Integer.parseInt(tokens[0]);
                int secondNumber = Integer.parseInt(tokens[1]);
                System.out.println(calculator.performCalculation(firstNumber, secondNumber));
            }

            input = br.readLine();
        }
    }

    private static Strategy createStrategy(String operand) {
        switch (operand) {
            case "+":
                return new AdditionStrategy();
            case "-":
                return new SubtractionStrategy();
            case "*":
                return new MultiplicationStrategy();
            case "/":
                return new DivisionStrategy();
        }
        return null;
    }
}
