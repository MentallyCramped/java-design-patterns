package dev.abhay.behavioral.strategy;

import lombok.Builder;
import lombok.NonNull;
import lombok.Setter;

/**
 * Represents a problem solver that uses an interchangeable algorithmic strategy to solve a
 * problem.
 * <p>
 * The ProblemSolver class is a part of the Strategy design pattern. It serves as the context within
 * which a strategy (algorithm) is applied. The class itself is not concerned with the details of
 * the algorithm to solve the problem; instead, it delegates that responsibility to the
 * {@link Algorithm} interface.
 * </p>
 * <p>
 * The algorithm can be set dynamically at runtime via the {@link #setAlgorithm(Algorithm)} method,
 * thereby allowing the solver to adapt to different problem-solving scenarios.
 * </p>
 *
 * @see Algorithm
 */
@Builder
@Setter
public class ProblemSolver {

  @NonNull
  private Algorithm algorithm;

  /**
   * Solves the problem using the algorithmic strategy currently set.
   *
   * @return A string representation of the solution, as produced by the algorithm.
   */
  public String solveProblem() {
    return algorithm.executeAlgorithm();
  }
}
