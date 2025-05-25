package activity4;

public class CalculatorMutant1 extends Calculator {
    @Override
    public int add(int a, int b) {
        return a - b;  // Mutant: Changed + to -
    }
} 