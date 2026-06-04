package P03_DependencyInversion.contracts;

public interface Calculator {
    void changeStrategy(Strategy strategy);

    int performCalculation(int firstNumber, int secondNumber);
}
