package activity4;

public class CalculatorMutant5 extends Calculator {
    @Override
    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number / i == 0) {  // Mutant: Changed % to /
                return false;
            }
        }
        return true;
    }
} 