package sample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GradeCalculatorTest {
    private GradeCalculator calculator = new GradeCalculator();

    // Test cases for statement coverage
    @Test
    void testStatementCoverage() {
        // This single test case executes all statements
        assertEquals("A", calculator.calculateGrade(95, false));
        assertEquals("B+", calculator.calculateGrade(85, true));
        assertEquals("C", calculator.calculateGrade(75, false));
        assertEquals("F", calculator.calculateGrade(65, false));
    }

    // Test cases for branch coverage
    @Test
    void testBranchCoverage() {
        // Test all branches of the if-else structure
        assertEquals("A", calculator.calculateGrade(95, false));  // score >= 90
        assertEquals("B", calculator.calculateGrade(85, false));  // score >= 80
        assertEquals("C", calculator.calculateGrade(75, false));  // score >= 70
        assertEquals("F", calculator.calculateGrade(65, false));  // score < 70
        
        // Test both branches of the extra credit condition
        assertEquals("B+", calculator.calculateGrade(85, true));   // isExtraCredit true
        assertEquals("B", calculator.calculateGrade(85, false));   // isExtraCredit false
    }

    // Test cases for condition coverage
    @Test
    void testConditionCoverage() {
        // Test boundary conditions for score
        assertEquals("A", calculator.calculateGrade(90, false));   // score == 90
        assertEquals("B", calculator.calculateGrade(80, false));   // score == 80
        assertEquals("C", calculator.calculateGrade(70, false));   // score == 70
        assertEquals("F", calculator.calculateGrade(69, false));   // score == 69
        
        // Test extra credit conditions
        assertEquals("A", calculator.calculateGrade(95, true));    // score >= 90, extra credit
        assertEquals("B+", calculator.calculateGrade(85, true));   // score < 90, extra credit
    }
} 