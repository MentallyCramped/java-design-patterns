package dev.abhay.behavioral.strategy;

import java.util.function.Function;
import lombok.Builder;
import lombok.NonNull;
import lombok.Setter;

/**
 * Represents a generic problem solver that uses an interchangeable algorithmic strategy to solve a
 * problem.
 *
 * <p>
 * The ProblemSolver class is part of the Strategy design pattern. It serves as the context within
 * which a strategy (algorithm) is applied. The class is generic, allowing it to work with any type
 * of problem and solution, as defined by the types {@code AlgorithmResultType} and
 * {@code SolutionResultType}, respectively.
 * </p>
 *
 * <p>
 * The algorithm can be set dynamically at runtime via the {@link #setAlgorithm(Algorithm)} method,
 * allowing the solver to adapt to different problem-solving scenarios. A {@link Function} is used
 * to transform the result of the algorithm execution to a different type, if necessary.
 * </p>
 *
 * @param <AlgorithmResultType> The type of the result produced by the algorithm.
 * @param <SolutionResultType>  The type of the result returned after transforming the algorithm's
 *                              result.
 * @see Algorithm
 */
@Builder
@Setter
public class ProblemSolver<AlgorithmResultType, SolutionResultType> {

  @NonNull
  private Algorithm<AlgorithmResultType> algorithm;
  @NonNull
  private final Function<AlgorithmResultType, SolutionResultType> algorithmResultTransformer;

  /**
   * Solves the problem using the currently set algorithmic strategy and transforms its result.
   *
   * @return The transformed result, as defined by the type {@code SolutionResultType}.
   */
  public SolutionResultType solveProblem() {
    AlgorithmResultType algorithmResult = algorithm.executeAlgorithm();
    return algorithmResultTransformer.apply(algorithmResult);
  }
}
