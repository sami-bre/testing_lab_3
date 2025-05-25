package activity4;

public class CalculatorMutant2 extends Calculator {
    @Override
    public int multiply(int a, int b) {
        return a + b;  // Mutant: Changed * to +
    }
} 