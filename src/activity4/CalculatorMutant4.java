package activity4;

public class CalculatorMutant4 extends Calculator {
    @Override
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return (double) a * b;  // Mutant: Changed / to *
    }
} 