package activity4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MutationTest {
    private CalculatorTest calculatorTest;

    @Test
    void testOriginalCalculator() {
        calculatorTest = new CalculatorTest();
        calculatorTest.setUp();
        calculatorTest.testAdd();
        calculatorTest.testSubtract();
        calculatorTest.testMultiply();
        calculatorTest.testDivide();
        calculatorTest.testIsPrime();
    }

    @Test
    void testMutant1() {
        // This mutant should be killed by testAdd()
        CalculatorMutant1 mutant = new CalculatorMutant1();
        assertNotEquals(5, mutant.add(2, 3));
        assertNotEquals(0, mutant.add(-2, 2));
        assertNotEquals(-5, mutant.add(-2, -3));
    }

    @Test
    void testMutant2() {
        // This mutant should be killed by testMultiply()
        CalculatorMutant2 mutant = new CalculatorMutant2();
        assertNotEquals(6, mutant.multiply(2, 3));
        assertNotEquals(-6, mutant.multiply(-2, 3));
        assertNotEquals(6, mutant.multiply(-2, -3));
    }

    @Test
    void testMutant3() {
        // This mutant should be killed by testIsPrime()
        CalculatorMutant3 mutant = new CalculatorMutant3();
        assertTrue(mutant.isPrime(1));  // Original would return false
    }

    @Test
    void testMutant4() {
        // This mutant should be killed by testDivide()
        CalculatorMutant4 mutant = new CalculatorMutant4();
        assertNotEquals(2.0, mutant.divide(6, 3));
        assertNotEquals(-2.0, mutant.divide(-6, 3));
        assertNotEquals(2.0, mutant.divide(-6, -3));
    }

    @Test
    void testMutant5() {
        // This mutant should be killed by testIsPrime()
        CalculatorMutant5 mutant = new CalculatorMutant5();
        assertTrue(mutant.isPrime(4));  // Original would return false
        assertTrue(mutant.isPrime(6));  // Original would return false
    }
} 