package dev.abhay.behavioral.strategy;

/**
 * Defines the interface for the algorithmic strategy used in problem-solving by
 * {@link ProblemSolver}.
 *
 * <p>
 * This interface is generic, allowing it to produce results of any type
 * {@code AlgorithmResultType}. It serves as the strategy in the Strategy design pattern, outlining
 * the contract that concrete algorithms must fulfill. Implementations of this interface define
 * specific ways to solve a problem.
 * </p>
 *
 * <p>
 * Implementations of this interface should encapsulate the core logic of the problem-solving
 * algorithm, making it easy to switch or combine strategies in the {@link ProblemSolver}.
 * </p>
 *
 * @param <AlgorithmResultType> The type of result that the algorithm will produce.
 * @see ProblemSolver
 */
public interface Algorithm<AlgorithmResultType> {

  AlgorithmResultType executeAlgorithm();
}
