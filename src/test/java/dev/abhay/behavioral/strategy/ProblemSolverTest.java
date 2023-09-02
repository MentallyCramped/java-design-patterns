package dev.abhay.behavioral.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link ProblemSolver}, focusing on its behavior when provided with different
 * {@link Algorithm} implementations.
 */
public class ProblemSolverTest {

  private ProblemSolver problemSolverUnderTest;
  private final static String TEST_ALGORITHM_ONE_RESULT = "Executing Test Algorithm One";
  private final static String TEST_ALGORITHM_TWO_RESULT = "Executing Test Algorithm Two";

  private static class TestAlgorithmOne implements Algorithm {

    @Override
    public String executeAlgorithm() {
      return TEST_ALGORITHM_ONE_RESULT;
    }
  }

  private static class TestAlgorithmTwo implements Algorithm {

    @Override
    public String executeAlgorithm() {
      return TEST_ALGORITHM_TWO_RESULT;
    }
  }

  @BeforeEach
  public void setup() {
    TestAlgorithmOne testAlgorithmOne = new TestAlgorithmOne();
    problemSolverUnderTest = ProblemSolver.builder()
        .algorithm(testAlgorithmOne)
        .build();
  }

  @Test
  public void testProblemSolver_executesDefaultAlgorithm() {
    Assertions.assertEquals(problemSolverUnderTest.solveProblem(), TEST_ALGORITHM_ONE_RESULT);
  }

  @Test
  public void testProblemSolver_executesAlternativeAlgorithm() {
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
