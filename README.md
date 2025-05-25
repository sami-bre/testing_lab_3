# Software Testing Lab Assignment

## Student Information
### Name: Samuel Birhanu
### ID: UGR/0848/13

## Project Structure
The source code for all activities is located in the `src` directory, organized as follows:

- `src/activity1/`: Boundary Value Analysis
  - MaxOfThree.java
  - MaxOfThreeTest.java

- `src/activity2/`: Equivalence Partitioning
  - GradeCalculator.java
  - GradeCalculatorTest.java

- `src/activity3/`: Data Flow Testing
  - StudentGradeAnalyzer.java
  - StudentGradeAnalyzerTest.java

- `src/activity4/`: Mutation Testing
  - Calculator.java
  - CalculatorTest.java
  - CalculatorMutant*.java
  - MutationTest.java

- `src/activity5/`: JUnit Testing
  - BankAccount.java
  - BankAccountTest.java

## Building and Running Tests
To build and run the tests, use the following command:
```bash
./gradlew test
```

To run tests for a specific activity, use:
```bash
./gradlew test --tests "activity<number>.*"
``` 