# Java Design Patterns

This repository contains examples of design patterns implemented in Java. Design patterns are
reusable solutions to recurring problems that you encounter during software development. By using
these patterns, you can make your code more efficient, scalable, and maintainable.

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

The Strategy Pattern is a behavioral design pattern that allows you to define a family of
algorithms, encapsulate each one of them, and make them interchangeable. This pattern allows the
algorithm's implementation to vary independently from the clients that use it. The pattern promotes
adherence to the Open/Closed Principle by enabling you to add new algorithms without altering
existing code.

### Advanced Features in this Repository

- **Generics:** This implementation leverages Java's generics to allow for type-safe algorithm
  strategies. This promotes greater code reusability and cleaner client code.

- **Result Transformation:** A unique twist added to this implementation is the ability to transform
  the result of an algorithm before it gets returned by the `ProblemSolver`. This is done via a
  functional interface, which enables a high degree of flexibility in what the `ProblemSolver` can
  do with the algorithm's result.

### When to Use

- When you have multiple ways to complete a task and want to make it easy to switch between them.

- When the client code that uses the algorithm should not be tightly coupled to the algorithm's
  implementation.

- When you want to add the ability to transform the results of algorithms dynamically.

### Components

- **Context**: The class that uses an algorithm (`ProblemSolver`).

- **Strategy**: The interface common to all supported algorithms (`Algorithm`).

- **Concrete Strategy**: Classes implementing the `Strategy` interface (
  e.g., `TestAlgorithmOne`, `TestAlgorithmTwo`).

- **Result Transformer**: A functional interface used for transforming the algorithm's result to a
  type that the `ProblemSolver` returns (`Function<AlgorithmResultType, SolutionResultType>`).
  
### Example

The `ProblemSolver` class acts as the context and uses an `Algorithm` to solve a problem. You can easily switch algorithms at runtime without altering the `ProblemSolver` class. Here's a minimal example:

```java
// Initialize ProblemSolver with an algorithm
ProblemSolver<String, String> solver = ProblemSolver.<String, String>builder()
    .algorithm(new TestAlgorithmOne())
    .algorithmResultTransformer(result -> result)
    .build();

// Solve problem with the initial algorithm
String resultOne = solver.solveProblem();

// Switch to a different algorithm at runtime
solver.setAlgorithm(new TestAlgorithmTwo());

// Solve problem with the new algorithm
String resultTwo = solver.solveProblem();
```

This example illustrates setting an initial algorithm, solving a problem, and then switching to a different algorithm—all at runtime.

## Contributions

Contributions are welcome! Feel free to add examples of other design patterns or improve existing
ones.

## License

This project does not have a license. It will be added soon.
