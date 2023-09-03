package dev.abhay.behavioral.strategy;

import java.util.function.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link ProblemSolver}, focusing on its behavior when provided with different
 * {@link Algorithm} implementations.
 */
public class ProblemSolverTest {

  private ProblemSolver<String, String> problemSolverUnderTest;
  private final static String TEST_ALGORITHM_ONE_RESULT = "Executing Test Algorithm One";
  private final static String TEST_ALGORITHM_TWO_RESULT = "Executing Test Algorithm Two";

  private static class TestAlgorithmOne implements Algorithm<String> {

    @Override
    public String executeAlgorithm() {
      return TEST_ALGORITHM_ONE_RESULT;
    }
  }

  private static class TestAlgorithmTwo implements Algorithm<String> {

    @Override
    public String executeAlgorithm() {
      return TEST_ALGORITHM_TWO_RESULT;
    }
  }

  @BeforeEach
  public void setup() {
    TestAlgorithmOne testAlgorithmOne = new TestAlgorithmOne();
    Function<String, String> algorithmResultTransformer = (algorithmResult) -> algorithmResult;

    problemSolverUnderTest = ProblemSolver.<String, String>builder()
        .algorithm(testAlgorithmOne)
        .algorithmResultTransformer(algorithmResultTransformer)
        .build();
  }

  @Test
  public void testProblemSolver_executesTestAlgorithmOne() {
    Assertions.assertEquals(problemSolverUnderTest.solveProblem(), TEST_ALGORITHM_ONE_RESULT);
  }

  @Test
  public void testProblemSolver_executesTestAlgorithmTwo() {
    TestAlgorithmTwo testAlgorithmTwo = new TestAlgorithmTwo();
    problemSolverUnderTest.setAlgorithm(testAlgorithmTwo);

    Assertions.assertEquals(problemSolverUnderTest.solveProblem(), TEST_ALGORITHM_TWO_RESULT);
  }

  @Test
  public void testProblemSolver_throwsException_whenAlgorithmIsNull() {
    Assertions.assertThrows(NullPointerException.class,
        () -> problemSolverUnderTest.setAlgorithm(null));
  }
}
