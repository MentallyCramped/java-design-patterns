# Java Design Patterns

This repository contains examples of design patterns implemented in Java. Design patterns are
reusable solutions to recurring problems that you encounter during software development. By using
these patterns, you can make your code more efficient, scalable, and maintainable.

If you need to revisit a few core design principles of software design, visit the [Design 
Principles](#design-principles) section.

## Patterns Covered

- [Strategy Pattern](#strategy-pattern-code-ref)

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

## Strategy Pattern [[Code Ref]](src/main/java/dev/abhay/behavioral/strategy/)

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
  type that the `ProblemSolver` returns (`Function<T, R>`).

### Example

The `ProblemSolver` class acts as the context and uses an `Algorithm` to solve a problem. You can easily switch algorithms at runtime without altering the `ProblemSolver` class. Here's a minimal example:

```java
// Initialize ProblemSolver with an algorithm
ProblemSolver<String, String> solver = ProblemSolver.builder()
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

# Design Principles
- [Composition Over Inheritance](#composition-over-inheritance-code-ref)

## Composition Over Inheritance [[Code Ref]](src/test/java/dev/abhay/designprinciples/favourcomposition)

Composition over inheritance is a fundamental software design principle that emphasizes using object composition (having objects contain other objects) over classical inheritance (extending classes). This principle helps keep each class encapsulated and focused on one task, promotes greater flexibility in code maintenance, and enhances the modularity of the application.

Using composition over inheritance allows for more dynamic and flexible configurations of behaviors at runtime. It can be especially beneficial in environments where behavior changes are expected or when functionality needs to be shared across unrelated classes.

### Advantages

- **Improved Modularity**: Composition allows for more modular code. By keeping related properties and behaviors together in distinct components, each class remains focused on one primary task, reducing its interface and interactions with other parts of the system.
- **Increased Flexibility**: Systems built with composition can be more easily reconfigured with new or altered behaviors without changing existing classes. You can mix and match capabilities as the runtime requirements change.
- **Ease of Maintenance**: With fewer dependencies and less deep class hierarchies, the code is easier to understand and maintain. Bugs are easier to trace and fix because the system's behavior is more predictable and localized to specific components.

### When to Use

- When designing systems that need to incorporate behavior that is liable to change or extend over time, without modifying existing code.
- In applications where multiple objects share similar behaviors that can be encapsulated into interchangeable components.
- When creating classes that can benefit from various unrelated capabilities, which can be added or removed dynamically.

### Key Concepts Illustrated in This Repository

The provided examples demonstrate the application of composition over inheritance through a transportation context where different types of engines and their behaviors can be composed dynamically.

#### Components of the Example

- **Engine Interface**: Defines the contract for engine behaviors with methods like `turnOn` and `turnOff`. This interface allows different types of engines to be interchanged within the `Transport` class without modifying its structure.
- **Concrete Engine Classes**: Like `ElectricEngine` and `FossilFuelEngine`, these classes implement the `Engine` interface, each providing specific behaviors for starting and stopping engines according to their unique mechanisms.
- **Transport Class**: Uses an engine component, showcasing how an engine's behavior can be composed at runtime depending on the specific engine instance it contains. This approach avoids inheritance and instead uses composition to delegate the engine-related behavior.

### Example

Consider the `Transport` class, which encapsulates an `Engine`. This design allows the `Transport` object to use any kind of engine, demonstrating a flexible structure:

```java
public class Transport {
    private Engine engine;

    public Transport(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.turnOn();
    }

    public void stop() {
        engine.turnOff();
    }
}
```

# Contributions

Contributions are welcome! Feel free to add examples of other design patterns or improve existing
ones.

# License

This project does not have a license. It will be added soon.
