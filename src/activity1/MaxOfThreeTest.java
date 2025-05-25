package sample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaxOfThreeTest {
    private MaxOfThree maxOfThree = new MaxOfThree();

    @Test
    void testPath1_FirstNumberIsMax() {
        // Path 1: a is max
        assertEquals(5, maxOfThree.findMax(5, 3, 2));
    }

    @Test
    void testPath2_SecondNumberIsMax() {
        // Path 2: b is max
        assertEquals(7, maxOfThree.findMax(3, 7, 2));
    }

    @Test
    void testPath3_ThirdNumberIsMax() {
        // Path 3: c is max
        assertEquals(9, maxOfThree.findMax(3, 2, 9));
    }
} 