# Activity 1: Control Flow Graph & Cyclomatic Complexity Analysis

## Function Under Analysis
```java
public int findMax(int a, int b, int c) {
    int max = a;
    
    if (b > max) {
        max = b;
    }
    
    if (c > max) {
        max = c;
    }
    
    return max;
}
```

## Cyclomatic Complexity Calculation

The cyclomatic complexity is calculated using the formula: C = E - N + 2P

Where:
- E = Number of edges in the graph
- N = Number of nodes in the graph
- P = Number of connected components

For our function:
- E (edges) = 9
  - 1 → 2
  - 2 → 3
  - 3 → 4 (true branch)
  - 3 → 5 (false branch)
  - 4 → 5
  - 5 → 6 (true branch)
  - 5 → 7 (false branch)
  - 6 → 7
  - 7 → 8
- N (nodes) = 8
  - Nodes 1 through 8
- P (connected components) = 1
  - The graph is fully connected

Therefore:
C = E - N + 2P
C = 9 - 8 + 2(1)
C = 3

## Linearly Independent Paths

The cyclomatic complexity of 3 indicates that there are 3 linearly independent paths through the code:

1. **Path 1**: 1 → 2 → 3 → 5 → 7 → 8
   - This path is taken when 'a' is the maximum number
   - Test case: `findMax(5, 3, 2) = 5`
   - Neither if condition is true

2. **Path 2**: 1 → 2 → 3 → 4 → 5 → 7 → 8
   - This path is taken when 'b' is the maximum number
   - Test case: `findMax(3, 7, 2) = 7`
   - First if condition is true, second is false

3. **Path 3**: 1 → 2 → 3 → 5 → 6 → 7 → 8
   - This path is taken when 'c' is the maximum number
   - Test case: `findMax(3, 2, 9) = 9`
   - First if condition is false, second is true

## Test Cases

The test cases are implemented in `MaxOfThreeTest.java` and cover all three independent paths:

```java
@Test
void testPath1_FirstNumberIsMax() {
    assertEquals(5, maxOfThree.findMax(5, 3, 2));
}

@Test
void testPath2_SecondNumberIsMax() {
    assertEquals(7, maxOfThree.findMax(3, 7, 2));
}

@Test
void testPath3_ThirdNumberIsMax() {
    assertEquals(9, maxOfThree.findMax(3, 2, 9));
}
```

All test cases have been verified to pass, confirming that our path analysis is correct and the function works as expected for all possible paths. 