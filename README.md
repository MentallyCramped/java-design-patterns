# Java Design Patterns

This repository contains examples of design patterns implemented in Java. Design patterns are reusable solutions to recurring problems that you encounter during software development. By using these patterns, you can make your code more efficient, scalable, and maintainable.

## Patterns Covered

- [Strategy Pattern](src/main/java/dev/abhay/behavioral/strategy/)

## Getting Started

To get started with the project:

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/java-design-patterns.git
    ```

2. Navigate to the cloned directory:

    ```bash
    cd java-design-patterns
    ```

3. Build the project:

    ```bash
    ./gradlew build
    ```

## Strategy Pattern

The Strategy Pattern is a behavioral design pattern that defines a family of algorithms and encapsulates each one, making them interchangeable. The pattern allows the algorithm to vary independently from the context that uses the algorithm.

### When to Use

- When you have multiple ways to accomplish something, but you don’t want to hard-code your code for any of them.
- When you want to separate the concerns of how to accomplish a task from the actual task itself.

### Components

- **Context**: The class that uses an algorithm (e.g., `ProblemSolver`)
- **Strategy**: The interface common to all supported algorithms (e.g., `Algorithm`)
- **Concrete Strategy**: The classes that implement the `Strategy` interface (e.g., `TestAlgorithmOne`, `TestAlgorithmTwo`)

### Example

In the example provided, `ProblemSolver` acts as the context and uses an `Algorithm` to solve a problem. You can easily switch algorithms at runtime without altering the `ProblemSolver` class.

Here's a simplified snippet from the [ProblemSolverTest](src/test/java/dev/abhay/behavioral/strategy/ProblemSolverTest.java) to illustrate how to use different algorithms:

```java
@Test
public void testProblemSolver_executesDefaultAlgorithm() {
    Assertions.assertEquals(problemSolverUnderTest.solveProblem(), TEST_ALGORITHM_ONE_RESULT);
}

@Test
public void testProblemSolver_executesAlternativeAlgorithm() {
    TestAlgorithmTwo testAlgorithmTwo = new TestAlgorithmTwo();
    problemSolverUnderTest.setAlgorithm(testAlgorithmTwo);
    Assertions.assertEquals(problemSolverUnderTest.solveProblem(), TEST_ALGORITHM_TWO_RESULT);
}
```

With the Strategy Pattern, you can add a new algorithm without altering existing code, thus adhering to the Open/Closed Principle.

## Contributions

Contributions are welcome! Feel free to add examples of other design patterns or improve existing ones.

## License

This project does not have a license. It will be added soon.
