package dev.abhay.behavioral.strategy;

import lombok.Builder;
import lombok.NonNull;
import lombok.Setter;

/**
 * Represents a generic problem solver that uses an interchangeable algorithmic strategy to solve a
 * specific problem represented by the input data.
 *
 * <p>
 * The ProblemSolver class is part of the Strategy design pattern. It serves as the context within
 * which a strategy (algorithm) is applied. The class is generic, allowing it to work with any type
 * of problem data, as defined by the type {@code R}.
 * </p>
 *
 * <p>
 * The algorithm can be set dynamically at runtime via the {@link #setAlgorithm(Algorithm)} method,
 * allowing the solver to adapt to different problem-solving scenarios.
 * </p>
 *
 * @param <R> The type of the input representing the problem.
 * @param <T> The type of the result produced by the algorithm.
 * @see Algorithm
 */
@Builder
@Setter
public class ProblemSolver<R, T> {

  @NonNull
  private Algorithm<R, T> algorithm;

  /**
   * Solves the problem using the currently set algorithmic strategy.
   *
   * @param problem The problem data to be solved.
   * @return The result of the algorithm, as defined by the type {@code T}.
   */
  public T solveProblem(R problem) {
    return algorithm.executeAlgorithm(problem);
  }
}