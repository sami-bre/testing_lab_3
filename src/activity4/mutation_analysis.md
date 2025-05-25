# Mutation Testing Analysis

## Overview
This document analyzes the mutation testing performed on the `Calculator` class. We created 5 mutants by introducing small changes to the original code and verified that our test cases could detect these changes.

## Original Code
The `Calculator` class implements basic arithmetic operations and prime number checking:
- Addition
- Subtraction
- Multiplication
- Division
- Prime number checking

## Mutants Created

### Mutant 1: Addition to Subtraction
```java
// Original
return a + b;
// Mutant
return a - b;
```
**Test Case**: `testAdd()` with inputs (2,3), (-2,2), (-2,-3)
**Result**: Killed ✅
**Reason**: Test cases detected the incorrect results (5→-1, 0→-4, -5→1)

### Mutant 2: Multiplication to Addition
```java
// Original
return a * b;
// Mutant
return a + b;
```
**Test Case**: `testMultiply()` with inputs (2,3), (-2,3), (-2,-3)
**Result**: Killed ✅
**Reason**: Test cases detected the incorrect results (6→5, -6→1, 6→-5)

### Mutant 3: Condition Change in isPrime
```java
// Original
if (number <= 1)
// Mutant
if (number < 1)
```
**Test Case**: `testIsPrime()` with input 1
**Result**: Killed ✅
**Reason**: Test case detected that 1 was incorrectly identified as prime

### Mutant 4: Division to Multiplication
```java
// Original
return (double) a / b;
// Mutant
return (double) a * b;
```
**Test Case**: `testDivide()` with inputs (6,3), (-6,3), (-6,-3)
**Result**: Killed ✅
**Reason**: Test cases detected the incorrect results (2.0→18.0, -2.0→-18.0, 2.0→18.0)

### Mutant 5: Modulo to Division
```java
// Original
if (number % i == 0)
// Mutant
if (number / i == 0)
```
**Test Case**: `testIsPrime()` with inputs 4 and 6
**Result**: Killed ✅
**Reason**: Test cases detected that composite numbers were incorrectly identified as prime

## Mutation Score Calculation

### Formula
```
Mutation Score = (Number of Killed Mutants / Total Number of Mutants) × 100%
```

### Calculation
- Total Number of Mutants: 5
- Number of Killed Mutants: 5
- Mutation Score = (5/5) × 100% = 100%

## Analysis
- All mutants were successfully killed by our test cases
- The 100% mutation score indicates that our test suite is effective at detecting the types of bugs represented by these mutations
- The test cases cover various scenarios including:
  - Positive and negative numbers
  - Edge cases (like division by zero)
  - Boundary conditions (like prime number checking)

## Conclusion
The high mutation score demonstrates that our test suite is robust and capable of detecting common types of bugs that might be introduced during development or maintenance. The test cases effectively verify both the correct behavior of the original code and detect incorrect behavior in the mutated versions. 