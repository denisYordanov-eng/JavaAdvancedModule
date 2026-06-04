package P03_DependencyInversion.models;


import P03_DependencyInversion.contracts.Calculator;
import P03_DependencyInversion.contracts.Strategy;

public class PrimitiveCalculator  implements Calculator {

    private Strategy strategy;

    public PrimitiveCalculator(Strategy strategy) {
       this.strategy = strategy;
    }

    @Override
    public void changeStrategy(Strategy strategy) {
       this.strategy = strategy;
    }

    @Override
    public int performCalculation(int firstNumber, int secondNumber){
     return  this.strategy.calculate(firstNumber, secondNumber);
    }
}
