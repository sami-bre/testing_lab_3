package activity3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentGradeAnalyzerTest {
    private StudentGradeAnalyzer analyzer;

    @BeforeEach
    void setUp() {
        analyzer = new StudentGradeAnalyzer();
    }

    // Test case for All-defs coverage
    @Test
    void testAllDefinitions() {
        // Tests definition of totalScore and numberOfGrades
        analyzer.processGrade(85);
        assertEquals(85.0, analyzer.getAverage());
        assertEquals("Good", analyzer.getGradeStatus());

        // Tests definition of all variables in reset()
        analyzer.reset();
        assertEquals(0.0, analyzer.getAverage());
        assertEquals("No grades processed", analyzer.getGradeStatus());
    }

    // Test cases for All DU pairs coverage
    @Test
    void testAllDUPairs() {
        // DU pair: totalScore definition to c-use in average calculation
        analyzer.processGrade(90);
        assertEquals(90.0, analyzer.getAverage());

        // DU pair: numberOfGrades definition to c-use in average calculation
        analyzer.processGrade(80);
        assertEquals(85.0, analyzer.getAverage());

        // DU pair: average definition to p-use in grade status determination
        analyzer.processGrade(95);
        assertEquals(88.33, analyzer.getAverage(), 0.01);
        assertEquals("Good", analyzer.getGradeStatus());
    }

    // Test cases for All DU paths coverage
    @Test
    void testAllDUPaths() {
        // Path 1: Excellent grade path
        analyzer.processGrade(95);
        analyzer.processGrade(95);
        assertEquals(95.0, analyzer.getAverage());
        assertEquals("Excellent", analyzer.getGradeStatus());

        // Path 2: Good grade path
        analyzer.reset();
        analyzer.processGrade(85);
        analyzer.processGrade(85);
        assertEquals(85.0, analyzer.getAverage());
        assertEquals("Good", analyzer.getGradeStatus());

        // Path 3: Satisfactory grade path
        analyzer.reset();
        analyzer.processGrade(75);
        analyzer.processGrade(75);
        assertEquals(75.0, analyzer.getAverage());
        assertEquals("Satisfactory", analyzer.getGradeStatus());

        // Path 4: Needs Improvement path
        analyzer.reset();
        analyzer.processGrade(65);
        analyzer.processGrade(65);
        assertEquals(65.0, analyzer.getAverage());
        assertEquals("Needs Improvement", analyzer.getGradeStatus());
    }
} 