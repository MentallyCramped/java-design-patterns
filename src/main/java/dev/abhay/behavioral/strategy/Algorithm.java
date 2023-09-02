package dev.abhay.behavioral.strategy;

/**
 * Defines the interface for the algorithmic strategy used in problem-solving by
 * {@link ProblemSolver}.
 * <p>
 * This interface serves as the strategy in the Strategy design pattern, outlining the contract that
 * concrete algorithms must fulfill. Classes that implement this interface define specific ways to
 * solve a problem.
 * </p>
 * <p>
 * Implementations of this interface should encapsulate the core logic of the problem-solving
 * algorithm, making it easy to switch or combine strategies in the {@link ProblemSolver}.
 * </p>
 *
 * @see ProblemSolver
 */
public interface Algorithm {

  String executeAlgorithm();
}
