package dev.abhay.behavioral.strategy;

/**
 * Defines the interface for the algorithmic strategy used in problem-solving by
 * {@link ProblemSolver}.
 *
 * <p>
 * This interface is generic, allowing it to handle input and produce results of any type. It serves
 * as the strategy in the Strategy design pattern, outlining the contract that concrete algorithms
 * must fulfill. Implementations of this interface define specific ways to solve a problem.
 * </p>
 *
 * @param <R> The type of input that the algorithm will accept.
 * @param <T> The type of result that the algorithm will produce.
 * @see ProblemSolver
 */
public interface Algorithm<R, T> {
  T executeAlgorithm(R problem);
}