package P03_DependencyInversion.strategies;

import P03_DependencyInversion.contracts.Strategy;

public class AdditionStrategy implements Strategy {

    @Override
    public int calculate(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
