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

The Strategy Pattern is a behavioral design pattern that enables the definition and encapsulation of a family of algorithms, making them interchangeable. This pattern allows the algorithm's behavior to vary independently from the clients that use it, adhering to the Open/Closed Principle by enabling the addition of new algorithms without modifying existing code.

### Features

- **Generics**: Utilizes Java's generics to allow for type-safe algorithm strategies, enhancing code reusability and maintainability.
- **Dynamic Strategy Management**: Supports dynamic changes to the problem-solving strategies at runtime, accommodating flexible solutions to complex problems.

### When to Use

- When you have multiple algorithms for processing data or solving a problem and you need to select between them dynamically at runtime.
- When the algorithms should be easily switchable without altering the client code that uses them.
- When promoting testability through decoupling and adherence to the Single Responsibility and Open/Closed principles.

### Graph Traversal Example

This repository includes a sophisticated example using the Strategy pattern with graph traversal algorithms, showcasing dynamic selection between different traversal methods such as BFS and DFS based on runtime decisions.

#### Components

- **Graph**: Represents the graph structure with nodes and edges.
- **BFSAlgorithm and DFSAlgorithm**: Concrete strategies for breadth-first and depth-first graph traversal, respectively.
- **ProblemSolver**: The context class configured with an `Algorithm` to perform the graph traversal.

#### Example Usage

```java
// Create a graph and add edges
Graph graph = new Graph();
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 3);

// Initialize the ProblemSolver with BFS algorithm
    ProblemSolver<Graph, List<Integer>> solver = ProblemSolver.<Graph, List<Integer>>builder()
    .algorithm(new BFSAlgorithm(0))
    .build();

// Perform BFS on the graph
    List<Integer> bfsResult = solver.solveProblem(graph);

// Switch to DFS and perform it on the same graph
    solver.setAlgorithm(new DFSAlgorithm(0));
    List<Integer> dfsResult = solver.solveProblem(graph);
```

This example emphasizes the flexibility of the Strategy pattern, facilitating runtime switches between different graph traversal strategies without altering the ProblemSolver or client code, showcasing how strategies can be applied to solve practical problems dynamically.

# Design Principles
- [Composition Over Inheritance](#composition-over-inheritance-code-ref)

## Composition Over Inheritance [[Code Ref]](src/main/java/dev/abhay/designprinciples/favourcomposition)

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
